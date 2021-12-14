package com.uz.android.newyorktimes.core.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uz.android.newyorktimes.core.OnBookmarkClickListener

class BookmarksAdapter(
    var keys: List<String>,
    var values: List<Any?>,
    var listener: OnBookmarkClickListener
) :
    RecyclerView.Adapter<BookmarksAdapter.Holder>() {

    inner class Holder(var view: View) : RecyclerView.ViewHolder(view) {

        private var textView = view.findViewById<TextView>(android.R.id.text1)
        fun bind(key: String, url: Any?) {
            textView.text = key
            view.setOnClickListener {
                listener.onClick(key, url!!.toString())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder(
        LayoutInflater.from(parent.context).inflate(
            android.R.layout.simple_list_item_1, parent, false
        )
    )

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(keys[position], values[position])
    }

    override fun getItemCount(): Int = keys.size
}