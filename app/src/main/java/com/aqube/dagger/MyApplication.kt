package com.aqube.dagger

import com.aqube.dagger.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class MyApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<MyApplication>? {
        return DaggerAppComponent.factory().create(this)
    }
}