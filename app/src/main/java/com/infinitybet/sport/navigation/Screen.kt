package com.infinitybet.sport.navigation

import com.infinitybet.sport.core.Constants.PRODUCT_LIST_SCREEN
import com.infinitybet.sport.core.Constants.PRODUCT_DETAILS_SCREEN
import com.infinitybet.sport.core.Constants.PRODUCT_SEARCH_SCREEN

sealed class Screen(val route: String) {
    object ProductListScreen: Screen(PRODUCT_LIST_SCREEN)
    object ProductSearchScreen: Screen(PRODUCT_SEARCH_SCREEN)
    object ProductDetailsScreen: Screen(PRODUCT_DETAILS_SCREEN)
}