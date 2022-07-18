package com.infinitybet.sport.di

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.infinitybet.sport.core.Constants.NAME
import com.infinitybet.sport.core.Constants.PRODUCTS
import com.infinitybet.sport.data.repository.ProductListRepositoryImpl
import com.infinitybet.sport.domain.repository.ProductListRepository

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideFirebaseFirestore() = Firebase.firestore

    @Provides
    fun provideProductsQuery(
        db: FirebaseFirestore
    ) = db.collection(PRODUCTS).orderBy(NAME)

    @Provides
    fun provideProductListRepository(
        productsQuery: Query
    ): ProductListRepository = ProductListRepositoryImpl(productsQuery)
}