package com.infinitybet.sport.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.infinitybet.sport.navigation.Screen.*
import com.infinitybet.sport.presentation.product_details.ProductDetailsScreen
import com.infinitybet.sport.presentation.product_list.ProductListScreen
import com.infinitybet.sport.presentation.product_search.ProductSearchScreen

@Composable
@ExperimentalComposeUiApi
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ProductListScreen.route
    ) {
        fun navigateToProductSearchScreen() = navController.navigate(ProductSearchScreen.route)

        fun navigateToProductDetailsScreen(
            productName: String
        ) = navController.navigate("${ProductDetailsScreen.route}/${productName}")

        fun navigateBack() = navController.popBackStack()

        composable(
            route = ProductListScreen.route
        ) {
            ProductListScreen(
                navigateToProductSearchScreen = {
                    navigateToProductSearchScreen()
                },
                navigateToProductDetailsScreen = { productName ->
                    navigateToProductDetailsScreen(productName)
                }
            )
        }
        composable(
            route = ProductSearchScreen.route
        ) {
            ProductSearchScreen(
                navigateBack = {
                    navigateBack()
                },
                navigateToProductDetailsScreen = { productName ->
                    navigateToProductDetailsScreen(productName)
                }
            )
        }
        composable(
            route = "${ProductDetailsScreen.route}/{productName}",
            arguments = listOf(
                navArgument("productName") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val productName = backStackEntry.arguments?.getString("productName") ?: ""
            ProductDetailsScreen(
                navigateBack = {
                    navigateBack()
                },
                productName = productName
            )
        }
    }
}