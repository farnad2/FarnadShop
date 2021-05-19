package com.farnadsoft.onlineshop.feature.product.comment

import androidx.lifecycle.MutableLiveData
import com.farnadsoft.onlineshop.common.SingleObserver
import com.farnadsoft.onlineshop.common.ShopViewModel
import com.farnadsoft.onlineshop.common.asyncNetworkRequest
import com.farnadsoft.onlineshop.data.Comment
import com.farnadsoft.onlineshop.data.repo.CommentRepository

class CommentListViewModel(productId: Int, commentRepository: CommentRepository) : ShopViewModel() {
    val commentsLiveData = MutableLiveData<List<Comment>>()

    init {
        progressBarLiveData.value = true
        commentRepository.getAll(productId)
            .asyncNetworkRequest()
            .doFinally { progressBarLiveData.value = false }
            .subscribe(object : SingleObserver<List<Comment>>(compositeDisposable) {
                override fun onSuccess(t: List<Comment>) {
                    commentsLiveData.value = t
                }
            })
    }
}