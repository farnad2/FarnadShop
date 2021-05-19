package com.farnadsoft.onlineshop.data.repo.source

import com.farnadsoft.onlineshop.data.Comment
import com.farnadsoft.onlineshop.services.http.ApiService
import io.reactivex.Single

class CommentRemoteDataSource(val apiService: ApiService):CommentDataSource {
    override fun getAll(productId:Int): Single<List<Comment>> = apiService.getComments(productId)

    override fun insert(): Single<Comment> {
        TODO("Not yet implemented")
    }
}