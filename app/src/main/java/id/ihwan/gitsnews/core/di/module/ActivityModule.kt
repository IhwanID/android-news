package id.ihwan.gitsnews.core.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.ihwan.gitsnews.core.di.ActivityScoped
import id.ihwan.gitsnews.feature.about.AboutActivity
import id.ihwan.gitsnews.feature.home.view.HomeActivity
import id.ihwan.gitsnews.feature.home.view.HomeActivityModule
import id.ihwan.gitsnews.feature.home.view.WebViewActivity
import id.ihwan.gitsnews.feature.profile.ProfileActivity

@Module
abstract class ActivityModule {
    @ActivityScoped
    @ContributesAndroidInjector()
    abstract fun contributeAboutActivity(): AboutActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [HomeActivityModule::class])
    abstract fun contributeHomeActivity(): HomeActivity


    @ActivityScoped
    @ContributesAndroidInjector()
    abstract fun contributeProfileActivity(): ProfileActivity

    @ActivityScoped
    @ContributesAndroidInjector()
    abstract fun contributeWebViewActivity(): WebViewActivity


}