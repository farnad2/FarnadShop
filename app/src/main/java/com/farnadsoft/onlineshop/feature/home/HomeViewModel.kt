package com.farnadsoft.onlineshop.feature.home

import androidx.lifecycle.MutableLiveData
import com.farnadsoft.onlineshop.common.SingleObserver
import com.farnadsoft.onlineshop.common.ShopViewModel
import com.farnadsoft.onlineshop.data.Banner
import com.farnadsoft.onlineshop.data.Product
import com.farnadsoft.onlineshop.data.SORT_LATEST
import com.farnadsoft.onlineshop.data.repo.BannerRepository
import com.farnadsoft.onlineshop.data.repo.ProductRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeViewModel(productRepository: ProductRepository, bannerRepository: BannerRepository) :
    ShopViewModel() {
    val productsLiveData = MutableLiveData<List<Product>>()
    val bannersLiveData = MutableLiveData<List<Banner>>()

    init {
        progressBarLiveData.value = true
        productRepository.getProducts(SORT_LATEST)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally { progressBarLiveData.value = false }
            .subscribe(object : SingleObserver<List<Product>>(compositeDisposable) {
                override fun onSuccess(t: List<Product>) {
                    productsLiveData.value = t
                }
            })

        bannerRepository.getBanners()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<Banner>>(compositeDisposable) {
                override fun onSuccess(t: List<Banner>) {
                    bannersLiveData.value=t
                }
            })
    }
}