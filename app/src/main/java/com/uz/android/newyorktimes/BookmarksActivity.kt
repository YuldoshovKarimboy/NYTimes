package com.uz.android.newyorktimes

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.uz.android.newyorktimes.core.OnBookmarkClickListener
import com.uz.android.newyorktimes.core.adapter.BookmarksAdapter

class BookmarksActivity : AppCompatActivity(), OnBookmarkClickListener {

    private lateinit var adapter: BookmarksAdapter
    private lateinit var list: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookmarks)
        list = findViewById(R.id.bookmarks)

        val data = getSharedPreferences("data", Context.MODE_PRIVATE).all
        val keys: List<String> = data.keys.toList()
        val values: List<Any?> = data.values.toList()
        adapter = BookmarksAdapter(keys, values, this)
        list.adapter = adapter

    }

    override fun onClick(key: String, url: String) {

        val bundle = Bundle()
        val intent = Intent(this, ArticleActivity::class.java)
        bundle.putString("title", key)
        bundle.putString("url", url)
        bundle.putBoolean("hasBookmark",true)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}