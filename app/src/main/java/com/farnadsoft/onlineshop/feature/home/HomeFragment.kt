package com.farnadsoft.onlineshop.feature.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.farnadsoft.onlineshop.R
import com.farnadsoft.onlineshop.common.EXTRA_KEY_DATA
import com.farnadsoft.onlineshop.common.ShopFragment
import com.farnadsoft.onlineshop.common.convertDpToPixel
import com.farnadsoft.onlineshop.data.Product
import com.farnadsoft.onlineshop.data.SORT_LATEST
import com.farnadsoft.onlineshop.feature.common.ProductListAdapter
import com.farnadsoft.onlineshop.feature.common.VIEW_TYPE_ROUND
import com.farnadsoft.onlineshop.feature.list.ProductListActivity
import com.farnadsoft.onlineshop.feature.main.BannerSliderAdapter
import com.farnadsoft.onlineshop.feature.product.ProductDetailActivity
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import timber.log.Timber

class HomeFragment : ShopFragment(), ProductListAdapter.OnProductClickListener {
    val homeViewModel: HomeViewModel by viewModel()
    val productListAdapter: ProductListAdapter by inject{ parametersOf(VIEW_TYPE_ROUND)}
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        latestProductsRv.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        latestProductsRv.adapter = productListAdapter
        productListAdapter.onProductClickListener = this

        homeViewModel.productsLiveData.observe(viewLifecycleOwner) {
            Timber.i(it.toString())
            productListAdapter.products = it as ArrayList<Product>
        }

        viewLatestProductsBtn.setOnClickListener {
            startActivity(Intent(requireContext(), ProductListActivity::class.java).apply {
                putExtra(EXTRA_KEY_DATA, SORT_LATEST)
            })
        }

        homeViewModel.progressBarLiveData.observe(viewLifecycleOwner) {
            setProgressIndicator(it)
        }

        homeViewModel.bannersLiveData.observe(viewLifecycleOwner) {
            Timber.i(it.toString())
            val bannerSliderAdapter = BannerSliderAdapter(this, it)
            bannerSliderViewPager.adapter = bannerSliderAdapter
            val viewPagerHeight = (((bannerSliderViewPager.measuredWidth - convertDpToPixel(
                32f,
                requireContext()
            )) * 173) / 328).toInt()

            val layoutParams = bannerSliderViewPager.layoutParams
            layoutParams.height = viewPagerHeight
            bannerSliderViewPager.layoutParams = layoutParams

            sliderIndicator.setViewPager2(bannerSliderViewPager)

        }

    }

    override fun onProductClick(product: Product) {
        startActivity(Intent(requireContext(), ProductDetailActivity::class.java).apply {
            putExtra(EXTRA_KEY_DATA, product)
        })
    }
}