package com.uz.android.newyorktimes.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uz.android.newyorktimes.R
import com.uz.android.newyorktimes.core.OnArticleClickListener
import com.uz.android.newyorktimes.core.model.ArticlePage
import com.uz.android.newyorktimes.databinding.ArticleMostBinding

class MostAdapter(var data: ArticlePage, var listener: OnArticleClickListener) :
    RecyclerView.Adapter<MostAdapter.Holder>() {

    inner class Holder(var bind: ArticleMostBinding) : RecyclerView.ViewHolder(bind.root) {
        fun bind(result: ArticlePage.Result) {
            bind.apply {
                if (result.media.isNotEmpty()) {
                    Glide.with(bind.root)
                        .load(result.media[0].mediaMetadata[result.media[0].mediaMetadata.size - 1].url)
                        .into(bind.img)
                }
                title.text = result.title
                info.text = result.abstract

                root.setOnClickListener {
                    listener.onClick(result)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.article_most, parent, false
        )
    )

    override fun onBindViewHolder(holder: Holder, position: Int) =
        holder.bind(data.results[position])

    override fun getItemCount(): Int = data.numResults
}