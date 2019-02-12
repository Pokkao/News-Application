package com.example.newsapplication


import android.content.Context
import android.view.ViewGroup
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import com.bumptech.glide.Glide
import com.example.newsapplication.ModelItem.ArticlesItem
import kotlinx.android.synthetic.main.main_recycleview.view.*


class AdapterRecycle(
    private val item: ArrayList<ArticlesItem>?,val context: Context) :
    RecyclerView.Adapter<AdapterRecycle.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.main_recycleview, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvNewsType?.text = item?.get(position)?.title
        holder.tvContentType?.text = item?.get(position)?.description
        Glide.with(context).load(item?.get(position)?.urlToImage).into(holder.Imcontent)
    }


    override fun getItemCount(): Int {
        return item!!.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvNewsType = view.text_topic
        val tvContentType = view.text_sub_content
        val Imcontent = view.Image_topic
    }
}
