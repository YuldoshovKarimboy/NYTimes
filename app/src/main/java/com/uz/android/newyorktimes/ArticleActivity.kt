package com.uz.android.newyorktimes

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity


class ArticleActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private var addBookmark = false
    private lateinit var titlePage: String
    private lateinit var url: String

    @SuppressLint("UseSupportActionBar")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        titlePage = intent.extras?.getString("title").toString()
        url = intent.extras?.getString("url").toString()
        addBookmark = intent.extras?.getBoolean("hasBookmark", false) == true
        title = titlePage
        webView = findViewById(R.id.web_view)
        webView.loadUrl(url)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.page_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_bookmark -> {
                if (addBookmark) {
                    item.setIcon(R.drawable.ic_baseline_bookmark_border_24)
                    addBookmark = false
                } else {
                    item.setIcon(R.drawable.ic_baseline_bookmark_24)
                    addBookmark = true
                }
                return true
            }
            R.id.share_article -> {
                val i = Intent(Intent.ACTION_SEND)
                i.type = "text/plain"
                i.putExtra(Intent.EXTRA_TEXT, url)
                startActivity(Intent.createChooser(i, titlePage))
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (addBookmark) {
            this.getSharedPreferences("data", Context.MODE_PRIVATE).edit().putString(titlePage, url)
                .apply()
        }
    }
}