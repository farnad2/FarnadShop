package com.farnadsoft.onlineshop.data.repo

import com.farnadsoft.onlineshop.data.Banner
import com.farnadsoft.onlineshop.data.repo.source.BannerDataSource
import io.reactivex.Single

class BannerRepositoryImpl(val bannerRemoteDataSource: BannerDataSource) : BannerRepository {
    override fun getBanners(): Single<List<Banner>> = bannerRemoteDataSource.getBanners()
}