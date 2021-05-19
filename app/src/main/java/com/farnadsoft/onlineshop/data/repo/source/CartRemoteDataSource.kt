package com.farnadsoft.onlineshop.data.repo.source

import com.google.gson.JsonObject
import com.farnadsoft.onlineshop.data.AddToCartResponse
import com.farnadsoft.onlineshop.data.CartItemCount
import com.farnadsoft.onlineshop.data.CartResponse
import com.farnadsoft.onlineshop.data.MessageResponse
import com.farnadsoft.onlineshop.services.http.ApiService
import io.reactivex.Single

class CartRemoteDataSource(val apiService: ApiService) : CartDataSource {
    override fun addToCart(productId: Int): Single<AddToCartResponse> = apiService.addToCart(
        JsonObject().apply {
            addProperty("product_id", productId)
        }
    )

    override fun get(): Single<CartResponse> = apiService.getCart()

    override fun remove(cartItemId: Int): Single<MessageResponse> = apiService.removeItemFromCart(
        JsonObject().apply {
            addProperty("cart_item_id", cartItemId)
        }
    )

    override fun changeCount(cartItemId: Int, count: Int): Single<AddToCartResponse> =
        apiService.changeCount(JsonObject().apply {
            addProperty("cart_item_id", cartItemId)
            addProperty("count", count)
        })

    override fun getCartItemsCount(): Single<CartItemCount> = apiService.getCartItemsCount()
}