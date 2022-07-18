package com.infinitybet.sport.presentation.product_search.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.TextFieldValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.infinitybet.sport.components.NoSearchResults
import com.infinitybet.sport.components.ProgressBar
import com.infinitybet.sport.core.Utils.Companion.print
import com.infinitybet.sport.domain.model.Response.*
import com.infinitybet.sport.presentation.product_list.ProductListViewModel
import com.infinitybet.sport.presentation.product_list.components.ProductListLazyColumn

@Composable
fun ProductSearchContent(
    viewModel: ProductListViewModel = hiltViewModel(),
    padding: PaddingValues,
    savedValue: TextFieldValue,
    navigateToProductDetailsScreen: (productName: String) -> Unit
) {
    val searchText = savedValue.text
    viewModel.getProductList(searchText)
    when (val productsResponse = viewModel.productListState.value) {
        is Loading -> ProgressBar()
        is Success -> {
            val productList = productsResponse.data
            if (productList.isNotEmpty()) {
                ProductListLazyColumn(
                    padding = padding,
                    productList = productList,
                    navigateToProductDetailsScreen = navigateToProductDetailsScreen
                )
            } else {
                if (searchText.isNotEmpty()) {
                    NoSearchResults()
                }
            }
        }
        is Error -> print(productsResponse.message)
    }
}