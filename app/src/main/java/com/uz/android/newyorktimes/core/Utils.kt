package com.uz.android.newyorktimes.core

import com.uz.android.newyorktimes.core.model.ArticlePage

const val api_key = "WGMUK4uYtdkqLlgsdzk4AglbRzxcX19p"

const val base_url = "https://api.nytimes.com/"

interface OnArticleClickListener {
    fun onClick(result: ArticlePage.Result)
}

interface OnBookmarkClickListener {

    fun onClick(key: String, url: String)
}