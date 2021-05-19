package com.farnadsoft.onlineshop.data.repo

import com.farnadsoft.onlineshop.data.Banner
import io.reactivex.Single

interface BannerRepository {
    fun getBanners():Single<List<Banner>>
}