package com.infinitybet.sport.domain.repository

import kotlinx.coroutines.flow.Flow
import com.infinitybet.sport.domain.model.Product
import com.infinitybet.sport.domain.model.Response

typealias ProductList = List<Product>
typealias ProductListResponse = Response<ProductList>

interface ProductListRepository {
    fun getProductListFromFirestore(searchText: String): Flow<ProductListResponse>
}