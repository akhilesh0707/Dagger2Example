package com.aqube.dagger.di.module

import com.aqube.dagger.di.auth.AuthViewModelsModule
import com.aqube.dagger.ui.auth.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = [AuthViewModelsModule::class])
    abstract fun contributeAuthActivity(): AuthActivity
}