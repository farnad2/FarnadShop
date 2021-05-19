package com.farnadsoft.onlineshop.data.repo.source

import com.farnadsoft.onlineshop.data.MessageResponse
import com.farnadsoft.onlineshop.data.TokenResponse
import io.reactivex.Single

interface UserDataSource {

    fun login(username: String, password: String): Single<TokenResponse>
    fun signUp(username: String, password: String): Single<MessageResponse>
    fun loadToken()
    fun saveToken(token: String, refreshToken: String)
}