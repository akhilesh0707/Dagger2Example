package com.aqube.dagger.di.module

import com.aqube.dagger.di.auth.AuthModule
import com.aqube.dagger.di.auth.AuthViewModelModule
import com.aqube.dagger.ui.auth.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = [AuthViewModelModule::class, AuthModule::class])
    abstract fun contributeAuthActivity(): AuthActivity
}