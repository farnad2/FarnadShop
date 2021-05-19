package com.farnadsoft.onlineshop.data.repo.source

import com.farnadsoft.onlineshop.data.Banner
import com.farnadsoft.onlineshop.services.http.ApiService
import io.reactivex.Single

class BannerRemoteDataSource(val apiService: ApiService) : BannerDataSource {
    override fun getBanners(): Single<List<Banner>> = apiService.getBanners()
}