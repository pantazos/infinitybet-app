package com.infinitybet.sport.presentation.product_details

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.infinitybet.sport.presentation.product_details.components.ProductDetailsContent
import com.infinitybet.sport.presentation.product_details.components.ProductDetailsTopBar

@Composable
fun ProductDetailsScreen(
    navigateBack: () -> Unit,
    productName: String
) {
    Scaffold(
        topBar = {
            ProductDetailsTopBar(
                onArrowBackClick = navigateBack
            )
        },
        content = { padding ->
            ProductDetailsContent(
                padding = padding,
                productName = productName
            )
        }
    )
}