package com.farnadsoft.onlineshop.feature

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.farnadsoft.onlineshop.common.EXTRA_KEY_DATA
import com.farnadsoft.onlineshop.common.SingleObserver
import com.farnadsoft.onlineshop.common.ShopViewModel
import com.farnadsoft.onlineshop.common.asyncNetworkRequest
import com.farnadsoft.onlineshop.data.Comment
import com.farnadsoft.onlineshop.data.Product
import com.farnadsoft.onlineshop.data.repo.CartRepository
import com.farnadsoft.onlineshop.data.repo.CommentRepository
import io.reactivex.Completable

class ProductDetailViewModel(bundle: Bundle, commentRepository: CommentRepository,val cartRepository: CartRepository) :
    ShopViewModel() {
    val productLiveData = MutableLiveData<Product>()
    val commentsLiveData = MutableLiveData<List<Comment>>()

    init {
        productLiveData.value = bundle.getParcelable(EXTRA_KEY_DATA)
        progressBarLiveData.value = true
        commentRepository.getAll(productLiveData.value!!.id)
            .asyncNetworkRequest()
            .doFinally { progressBarLiveData.value = false }
            .subscribe(object : SingleObserver<List<Comment>>(compositeDisposable) {
                override fun onSuccess(t: List<Comment>) {
                    commentsLiveData.value = t
                }
            })
    }

    fun onAddToCartBtn():Completable = cartRepository.addToCart(productLiveData.value!!.id).ignoreElement()
}