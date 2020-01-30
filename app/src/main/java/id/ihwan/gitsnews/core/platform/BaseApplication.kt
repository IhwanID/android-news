package id.ihwan.gitsnews.core.platform

import android.app.Service
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasServiceInjector
import id.ihwan.gitsnews.core.di.component.DaggerAppComponent
import id.ihwan.gitsnews.core.di.module.Provider
import javax.inject.Inject

class BaseApplication : DaggerApplication(), HasServiceInjector {

    @Inject
    lateinit var dispatchingServiceInjector: DispatchingAndroidInjector<Service>

    private val appComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .build()
    }

    override fun serviceInjector(): DispatchingAndroidInjector<Service> {
        return dispatchingServiceInjector
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent.inject(this)
        Provider.appComponent = appComponent
        return appComponent
    }

}