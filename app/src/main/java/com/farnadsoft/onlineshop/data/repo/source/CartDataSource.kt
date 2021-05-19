package com.farnadsoft.onlineshop.data.repo.source

import com.farnadsoft.onlineshop.data.AddToCartResponse
import com.farnadsoft.onlineshop.data.CartItemCount
import com.farnadsoft.onlineshop.data.CartResponse
import com.farnadsoft.onlineshop.data.MessageResponse
import io.reactivex.Single

interface CartDataSource {

    fun addToCart(productId: Int): Single<AddToCartResponse>
    fun get(): Single<CartResponse>
    fun remove(cartItemId: Int): Single<MessageResponse>
    fun changeCount(cartItemId: Int, count: Int): Single<AddToCartResponse>
    fun getCartItemsCount(): Single<CartItemCount>
}