package com.infinitybet.sport.presentation.product_list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.infinitybet.sport.presentation.product_list.components.ProductListContent
import com.infinitybet.sport.presentation.product_list.components.ProductListTopBar

@Composable
fun ProductListScreen(
    navigateToProductSearchScreen: () -> Unit,
    navigateToProductDetailsScreen: (productName: String) -> Unit
) {
    Scaffold(
        topBar = {
            ProductListTopBar(
                onSearchIconClick = navigateToProductSearchScreen
            )
        },
        content = { padding ->
            ProductListContent(
                padding = padding,
                navigateToProductDetailsScreen = navigateToProductDetailsScreen
            )
        }
    )
}