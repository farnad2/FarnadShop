package com.farnadsoft.onlineshop.data.repo

import com.farnadsoft.onlineshop.data.Comment
import io.reactivex.Single

interface CommentRepository {

    fun getAll(productId:Int): Single<List<Comment>>

    fun insert(): Single<Comment>
}