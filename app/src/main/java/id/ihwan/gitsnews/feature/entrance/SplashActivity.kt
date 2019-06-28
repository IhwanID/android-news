package id.ihwan.gitsnews.feature.entrance

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import id.ihwan.gitsnews.feature.home.view.HomeActivity
import id.ihwan.gitsnews.R
import id.ihwan.gitsnews.core.platform.BaseActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFullScreen()
        setContentView(R.layout.activity_splash)
        goToHomePage()
    }

    fun goToHomePage(){

        Handler().postDelayed({
            val i = Intent(this, HomeActivity::class.java)
            startActivity(i)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            finish()
        }, 1500)
    }
}
