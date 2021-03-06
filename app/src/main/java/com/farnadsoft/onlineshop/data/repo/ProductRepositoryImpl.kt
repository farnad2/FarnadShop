package com.farnadsoft.onlineshop.data.repo

import com.farnadsoft.onlineshop.data.Product
import com.farnadsoft.onlineshop.data.repo.source.ProductDataSource
import com.farnadsoft.onlineshop.data.repo.source.ProductLocalDataSource
import io.reactivex.Completable
import io.reactivex.Single

class ProductRepositoryImpl(
    val remoteDataSource: ProductDataSource,
    val localDataSource: ProductLocalDataSource
) : ProductRepository {
    override fun getProducts(sort:Int): Single<List<Product>> = remoteDataSource.getProducts(sort)

    override fun getFavoriteProducts(): Single<List<Product>> {
        TODO("Not yet implemented")
    }

    override fun addToFavorites(): Completable {
        TODO("Not yet implemented")
    }

    override fun deleteFromFavorites(): Completable {
        TODO("Not yet implemented")
    }
}