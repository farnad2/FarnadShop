package com.farnadsoft.onlineshop.data.repo.source

import com.farnadsoft.onlineshop.data.Banner
import io.reactivex.Single

interface BannerDataSource {
    fun getBanners():Single<List<Banner>>
}