package id.ihwan.gitsnews.core.platform

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import id.ihwan.gitsnews.core.di.component.DaggerAppComponent

class BaseApplication : DaggerApplication(){

    private val appComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .build()
    }


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent.inject(this)
        return appComponent
    }

}