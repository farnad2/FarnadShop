package com.farnadsoft.onlineshop.data.repo

import com.farnadsoft.onlineshop.data.AddToCartResponse
import com.farnadsoft.onlineshop.data.CartItemCount
import com.farnadsoft.onlineshop.data.CartResponse
import com.farnadsoft.onlineshop.data.MessageResponse
import com.farnadsoft.onlineshop.data.repo.source.CartDataSource
import io.reactivex.Single

class CartRepositoryImpl(val remoteDataSource: CartDataSource) : CartRepository {
    override fun addToCart(productId: Int): Single<AddToCartResponse> =
        remoteDataSource.addToCart(productId)

    override fun get(): Single<CartResponse> =remoteDataSource.get()

    override fun remove(cartItemId: Int): Single<MessageResponse> =remoteDataSource.remove(cartItemId)

    override fun changeCount(cartItemId: Int, count: Int): Single<AddToCartResponse> = remoteDataSource.changeCount(cartItemId,count)

    override fun getCartItemsCount(): Single<CartItemCount> =remoteDataSource.getCartItemsCount()
}