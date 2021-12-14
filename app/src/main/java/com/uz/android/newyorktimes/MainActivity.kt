package com.uz.android.newyorktimes

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.uz.android.newyorktimes.core.OnArticleClickListener
import com.uz.android.newyorktimes.core.adapter.DayAdapter
import com.uz.android.newyorktimes.core.adapter.MostAdapter
import com.uz.android.newyorktimes.core.api_key
import com.uz.android.newyorktimes.core.model.ArticlePage
import com.uz.android.newyorktimes.core.network.NYTimesApi
import com.uz.android.newyorktimes.core.network.NYTimesRetrofit
import com.uz.android.newyorktimes.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), OnArticleClickListener {

    private lateinit var bind: ActivityMainBinding
    private lateinit var api: NYTimesApi
    private lateinit var mostViewAdapter: MostAdapter
    private lateinit var mostFacebookAdapter: MostAdapter
    private lateinit var dayAdapter: DayAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(this, R.layout.activity_main)
        api = NYTimesRetrofit().api()

        bind.apply {
            api.mostViewPage(api_key).enqueue(object : Callback<ArticlePage> {
                override fun onResponse(call: Call<ArticlePage>, response: Response<ArticlePage>) {
                    if (response.isSuccessful) {
                        mostViewAdapter = MostAdapter(response.body()!!, this@MainActivity)
                        mostViewed.adapter = mostViewAdapter
                    }
                }

                override fun onFailure(call: Call<ArticlePage>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }
            })

            api.facebookPage(api_key).enqueue(object : Callback<ArticlePage> {
                override fun onResponse(call: Call<ArticlePage>, response: Response<ArticlePage>) {
                    if (response.isSuccessful) {
                        mostFacebookAdapter = MostAdapter(response.body()!!, this@MainActivity)
                        mostFacebook.adapter = mostFacebookAdapter
                    }
                }

                override fun onFailure(call: Call<ArticlePage>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }
            })

            api.dayPage(api_key).enqueue(object : Callback<ArticlePage> {
                override fun onResponse(call: Call<ArticlePage>, response: Response<ArticlePage>) {
                    if (response.isSuccessful) {
                        dayAdapter = DayAdapter(response.body()!!, this@MainActivity)
                        mostLastDay.adapter = dayAdapter
                    }
                }

                override fun onFailure(call: Call<ArticlePage>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    override fun onClick(result: ArticlePage.Result) {
        val bundle = Bundle()
        val intent = Intent(this, ArticleActivity::class.java)
        bundle.putString("title", result.title)
        bundle.putString("url", result.url)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.bookmarks -> {
                startActivity(Intent(this, BookmarksActivity::class.java))
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }
}