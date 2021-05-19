package com.farnadsoft.onlineshop.common

import com.farnadsoft.onlineshop.R
import org.json.JSONObject
import retrofit2.HttpException
import timber.log.Timber

class ExceptionMapper {
    companion object {
        fun map(throwable: Throwable): Exception {
            if (throwable is HttpException) {
                try {
                    val errorJsonObject = JSONObject(throwable.response()?.errorBody()!!.string())
                    val errorMessage=errorJsonObject.getString("message")
                    return Exception(if (throwable.code()==401) Exception.Type.AUTH else Exception.Type.SIMPLE,serverMessage = errorMessage)
                } catch (exception: java.lang.Exception) {
                    Timber.e(exception)
                }
            }

            return Exception(Exception.Type.SIMPLE, R.string.unknown_error)
        }
    }
}