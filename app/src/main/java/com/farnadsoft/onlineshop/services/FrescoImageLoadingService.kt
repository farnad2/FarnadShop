package com.farnadsoft.onlineshop.services

import com.facebook.drawee.view.SimpleDraweeView
import com.farnadsoft.onlineshop.view.ImageView
import java.lang.IllegalStateException

class FrescoImageLoadingService :ImageLoadingService{
    override fun load(imageView: ImageView, imageUrl: String) {
        if (imageView is SimpleDraweeView)
            imageView.setImageURI(imageUrl)
        else
            throw IllegalStateException("ImageView must be instance of SimpleDraweeView")
    }
}