package id.ihwan.gitsnews.feature.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import id.ihwan.gitsnews.R
import id.ihwan.gitsnews.databinding.ActivityHomeBinding
import id.ihwan.gitsnews.feature.home.adapter.NewsAdapter
import id.ihwan.gitsnews.feature.home.viewmodel.HomeViewModel

class HomeActivity : AppCompatActivity() {

    private lateinit  var viewPager: ViewPager

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
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

    inner class NewsPagerAdapter( manager: FragmentManager) : FragmentStatePagerAdapter(manager) {
        private var headlineFragment: HeadlineFragment = HeadlineFragment.newInstance()
        private var androidFragment: AndroidFragment = AndroidFragment.newInstance()
        private var designFragment: DesignFragment = DesignFragment.newInstance()


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
            return  when(position){
                0 -> "Headline"
                1 -> "Android"
                else -> "Design"
            }

        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.about -> {

            true
        }

        else -> {

            super.onOptionsItemSelected(item)
        }
    }


}
