package com.aqube.dagger.ui.auth

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.aqube.dagger.R
import com.aqube.dagger.base.BaseActivity
import com.aqube.dagger.viewmodels.ViewModelProviderFactory
import com.bumptech.glide.RequestManager
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject

class AuthActivity : BaseActivity() {

    private val TAG: String = AuthActivity::class.java.simpleName

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory
    @Inject
    lateinit var logo: Drawable
    @Inject
    lateinit var requestManager: RequestManager

    private lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        viewModel = ViewModelProvider(this, providerFactory).get(AuthViewModel::class.java)

        bindLogo()
    }

    fun bindLogo() {
        requestManager.load(logo).into(imageViewLogo)
    }
}
