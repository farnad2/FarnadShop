package com.farnadsoft.onlineshop.feature.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.farnadsoft.onlineshop.R
import com.farnadsoft.onlineshop.common.ShopFragment

class ProfileFragment: ShopFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile,container,false)
    }
}