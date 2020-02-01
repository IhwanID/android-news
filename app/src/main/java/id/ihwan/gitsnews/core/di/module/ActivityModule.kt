package id.ihwan.gitsnews.core.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.ihwan.gitsnews.core.di.ActivityScoped
import id.ihwan.gitsnews.feature.about.AboutActivity
import id.ihwan.gitsnews.feature.home.view.DetailActivity
import id.ihwan.gitsnews.feature.home.view.HomeActivity
import id.ihwan.gitsnews.feature.profile.ProfileActivity

@Module
abstract class ActivityModule {
    @ActivityScoped
    @ContributesAndroidInjector()
    abstract fun contributeAboutActivity(): AboutActivity

    @ActivityScoped
    @ContributesAndroidInjector()
    abstract fun contributeHomeActivity(): HomeActivity

    @ActivityScoped
    @ContributesAndroidInjector()
    abstract fun contributeDetailActivity(): DetailActivity

    @ActivityScoped
    @ContributesAndroidInjector()
    abstract fun contributeProfileActivity(): ProfileActivity


}