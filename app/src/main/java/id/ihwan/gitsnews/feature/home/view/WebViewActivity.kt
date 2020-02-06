package id.ihwan.gitsnews.feature.home.view

import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import id.ihwan.gitsnews.R
import id.ihwan.gitsnews.core.platform.BaseActivity
import id.ihwan.gitsnews.databinding.ActivityWebViewBinding

class WebViewActivity : BaseActivity<ActivityWebViewBinding>(R.layout.activity_web_view) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initWebView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView() {
        val url = intent.getStringExtra("url")
        val title = intent.getStringExtra("title")

        val toolbar = binding.toolbar.apply {
            this.title = title
            this.subtitle = url
        }

        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener { onBackPressed() }
        binding.webView.apply {
            settings.javaScriptEnabled = true
            webViewClient = CustomWebViewClient()
            loadUrl(url)
        }
    }

    inner class CustomWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            binding.webView.loadUrl(url)
            return false
        }

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            binding.apply {
                progressBar.visibility = View.VISIBLE
                webView.visibility = View.GONE
            }
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            binding.apply {
                progressBar.visibility = View.GONE
                webView.visibility = View.VISIBLE
            }
        }
    }
}
