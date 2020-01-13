package com.aqube.dagger.di.module

import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import com.aqube.dagger.MyApplication
import com.aqube.dagger.R
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideRequestOption(): RequestOptions {
        return RequestOptions.placeholderOf(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
    }

    @Singleton
    @Provides
    fun provideGlideInstance(
        application: MyApplication,
        requestOptions: RequestOptions
    ): RequestManager {
        return Glide.with(application).setDefaultRequestOptions(requestOptions)
    }

    @Singleton
    @Provides
    fun provideAppLogo(application: MyApplication): Drawable{
        return ResourcesCompat.getDrawable(application.resources, R.drawable.logo, null)!!
    }
}