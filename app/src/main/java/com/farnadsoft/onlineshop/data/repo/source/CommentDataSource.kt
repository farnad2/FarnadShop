package com.farnadsoft.onlineshop.data.repo.source

import com.farnadsoft.onlineshop.data.Comment
import io.reactivex.Single

interface CommentDataSource {

    fun getAll(productId:Int): Single<List<Comment>>

    fun insert(): Single<Comment>
}