package id.ihwan.gitsnews.feature.entrance

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.ihwan.gitsnews.feature.home.view.HomeActivity
import id.ihwan.gitsnews.R
import id.ihwan.gitsnews.core.utils.setWhiteStatusBar

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.SplashTheme)
        super.onCreate(savedInstanceState)
        setWhiteStatusBar()
        goToHomePage()
    }

    private fun goToHomePage(){
            val i = Intent(this, HomeActivity::class.java)
            startActivity(i)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            finish()
    }
}
