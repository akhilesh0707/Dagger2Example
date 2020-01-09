package com.aqube.dagger.di

import com.aqube.dagger.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeAuthActivity(): AuthActivity
}