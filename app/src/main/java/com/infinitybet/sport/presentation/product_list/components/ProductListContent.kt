package com.infinitybet.sport.presentation.product_list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.infinitybet.sport.components.ProgressBar
import com.infinitybet.sport.core.Utils.Companion.print
import com.infinitybet.sport.domain.model.Response.*
import com.infinitybet.sport.presentation.product_list.ProductListViewModel

@Composable
fun ProductListContent(
    viewModel: ProductListViewModel = hiltViewModel(),
    padding: PaddingValues,
    navigateToProductDetailsScreen: (productName: String) -> Unit
) {
    when(val productsResponse = viewModel.productListState.value) {
        is Loading -> ProgressBar()
        is Success -> ProductListLazyColumn(
            padding = padding,
            productList = productsResponse.data,
            navigateToProductDetailsScreen = navigateToProductDetailsScreen
        )
        is Error -> print(productsResponse.message)
    }
}