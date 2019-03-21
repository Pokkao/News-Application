package com.example.newsapplication


import android.content.Context
import android.view.ViewGroup
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import com.example.newsapplication.ModelItem.ArticlesItem


class AdapterRecycle(
    private val item: ArrayList<ArticlesItem>?,
    val activityMain: MainActivity,
    val pages: PageNewsFragment?
) : RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.main_recycleview, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         holder.bind(item!![position],pages,activityMain)


    }

    override fun getItemCount(): Int {
        return item!!.size
    }


}
