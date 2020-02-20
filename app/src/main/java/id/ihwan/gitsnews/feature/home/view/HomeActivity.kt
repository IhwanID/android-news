package id.ihwan.gitsnews.feature.home.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.ihwan.gitsnews.R
import id.ihwan.gitsnews.core.di.FragmentScoped
import id.ihwan.gitsnews.core.platform.BaseActivity
import id.ihwan.gitsnews.databinding.ActivityHomeBinding
import id.ihwan.gitsnews.feature.about.AboutActivity
import id.ihwan.gitsnews.feature.profile.ProfileActivity

class HomeActivity : BaseActivity<ActivityHomeBinding>(R.layout.activity_home) {

    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)
        initViewPager()
    }

    private fun initViewPager() {
        viewPager = binding.viewPager
        viewPager.adapter = NewsPagerAdapter(supportFragmentManager)
        binding.tabLayout.setupWithViewPager(viewPager)

        val position = 0
        viewPager.apply {
            currentItem = position
            offscreenPageLimit = 4
        }

    }

    inner class NewsPagerAdapter(manager: FragmentManager) : FragmentStatePagerAdapter(manager) {
        private var headlineFragment: HeadlineFragment = HeadlineFragment.newInstance()
        private var androidFragment: EverythingFragment = EverythingFragment.newInstance()
        private var designFragment: SourcesFragment = SourcesFragment.newInstance()


        override fun getCount(): Int {
            return 3
        }

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> headlineFragment
                1 -> androidFragment
                else -> designFragment

            }
        }


        override fun getPageTitle(position: Int): CharSequence? {
            return when (position) {
                0 -> "Headline"
                1 -> "Everything"
                else -> "Sources"
            }

        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_app_bar, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.about -> {
            startActivity(Intent(this, AboutActivity::class.java))
            true
        }

        else -> {
            startActivity(Intent(this, ProfileActivity::class.java))
            super.onOptionsItemSelected(item)
        }
    }


}

@Module
abstract class HomeActivityModule{
    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributeHeadlineFragment(): HeadlineFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributeAndroidFragment(): EverythingFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributeDesignFragment(): SourcesFragment
}
