package com.aqube.dagger

import android.graphics.drawable.Drawable
import android.os.Bundle
import com.bumptech.glide.RequestManager
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject

class AuthActivity : BaseActivity() {
    private val TAG: String = AuthActivity::class.java.simpleName

    @Inject
    lateinit var logo: Drawable
    @Inject
    lateinit var requestManager: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        bindLogo()
    }

    fun bindLogo() {
        requestManager.load(logo).into(imageViewLogo)
    }
}
