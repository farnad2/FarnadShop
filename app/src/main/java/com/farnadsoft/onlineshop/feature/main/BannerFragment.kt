package com.farnadsoft.onlineshop.feature.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.farnadsoft.onlineshop.R
import com.farnadsoft.onlineshop.common.EXTRA_KEY_DATA
import com.farnadsoft.onlineshop.data.Banner
import com.farnadsoft.onlineshop.services.ImageLoadingService
import com.farnadsoft.onlineshop.view.ImageView
import org.koin.android.ext.android.inject
import java.lang.IllegalStateException

class BannerFragment : Fragment() {
    val imageLoadingService: ImageLoadingService by inject()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val imageView =
            inflater.inflate(R.layout.fragment_banner, container, false) as ImageView
        val banner =
            requireArguments().getParcelable<Banner>(EXTRA_KEY_DATA) ?: throw IllegalStateException(
                "Banner cannot be null"
            )
        imageLoadingService.load(imageView, banner.image)
        return imageView
    }

    companion object {
        fun newInstance(banner: Banner): BannerFragment {
            return BannerFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(EXTRA_KEY_DATA, banner)
                }
            }
        }
    }
}