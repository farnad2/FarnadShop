package com.farnadsoft.onlineshop.services

import com.farnadsoft.onlineshop.view.ImageView

interface ImageLoadingService {
    fun load(imageView: ImageView, imageUrl: String)
}