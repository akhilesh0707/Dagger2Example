package com.aqube.dagger.di

import com.aqube.dagger.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        AppModule::class
    ]
)

interface AppComponent : AndroidInjector<MyApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: MyApplication): AppComponent
    }
}