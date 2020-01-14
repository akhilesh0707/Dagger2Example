package com.aqube.dagger.di.component

import com.aqube.dagger.base.MyApplication
import com.aqube.dagger.di.module.ActivityBuilderModule
import com.aqube.dagger.di.module.AppModule
import com.aqube.dagger.di.module.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        AppModule::class,
        ViewModelFactoryModule::class
    ]
)

interface AppComponent : AndroidInjector<MyApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: MyApplication): AppComponent
    }
}