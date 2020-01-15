package com.aqube.dagger.ui.auth

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aqube.dagger.R
import com.aqube.dagger.base.BaseActivity
import com.aqube.dagger.base.Resource
import com.aqube.dagger.base.ViewModelProviderFactory
import com.bumptech.glide.RequestManager
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject

class AuthActivity : BaseActivity(), View.OnClickListener {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory
    @Inject
    lateinit var logo: Drawable
    @Inject
    lateinit var requestManager: RequestManager

    private lateinit var viewModel: AuthViewModel

    private val TAG: String = AuthActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        viewModel = ViewModelProvider(this, providerFactory).get(AuthViewModel::class.java)
        bindListeners()
        observerUser()
        bindLogo()
    }

    fun bindListeners() {
        buttonLogin.setOnClickListener(this)
    }

    fun bindLogo() {
        requestManager.load(logo).into(imageViewLogo)
    }

    fun observerUser() {
        viewModel.observeUser().observe(this, Observer { resource ->
            when (resource) {
                is Resource.Loading -> {
                    showHideProgressBar(View.VISIBLE)
                }
                is Resource.Success -> {
                    Log.d(TAG, resource.data.toString())
                    showHideProgressBar(View.GONE)
                }
                is Resource.Failure -> {
                    Toast.makeText(
                        this@AuthActivity,
                        resource.throwable.message,
                        Toast.LENGTH_LONG
                    ).show()
                    showHideProgressBar(View.GONE)
                }
            }
        })
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.buttonLogin -> attemptLogin()
        }
    }

    private fun attemptLogin() {
        if (TextUtils.isEmpty(editTextUser.text.toString())) {
            return
        } else {
            viewModel.authenticateUserWithId(editTextUser.text.toString().toInt())
        }
    }

    private fun showHideProgressBar(visibility: Int) {
        progressBar.visibility = visibility
    }
}
