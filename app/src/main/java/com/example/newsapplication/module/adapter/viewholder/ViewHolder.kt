package com.example.newsapplication.module.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.example.newsapplication.R
import com.example.newsapplication.model.ArticlesItem
import com.example.newsapplication.module.activity.MainActivity
import com.example.newsapplication.module.fragment.PageNewsFragment
import kotlinx.android.synthetic.main.fragment_page_news2.view.*
import kotlinx.android.synthetic.main.main_recycleview.view.*

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    init {
//Ex1        this.context = context
//            this.a = a
    }

    fun bind(
        item: ArticlesItem,
        pages: PageNewsFragment?,
        mainActivity: MainActivity
    ) {

        with(itemView){

            text_topic.text = item.title
            text_sub_content.text = item.description
            Glide.with(context).load(item.urlToImage).into(Image_topic)
            Realtime_date.text = item.publishedAt


            Image_topic.setOnClickListener {
                val integer = Integer.valueOf(position)
//                Log.i("Profile","$integer")

                mainActivity.ProfileNews(integer, item.title!!, item.urlToImage!!, item.author!!,
                    item.content!!,item.publishedAt!!,item.url!!,item.description!!)

            }



            bt_ic_starborder.setOnClickListener{
            if(!bt_ic_starborder.isSelected){
//                sparseBooleanArray!!.put(adapterPosition,true)

                itemView.tag = item
                bt_ic_starborder.isSelected = true
                bt_ic_starborder.setImageResource(R.drawable.ic_check_star)
//                listCurrentSelect.add(data)

            }
            else{
//                sparseBooleanArray!!.put(adapterPosition,false)

                bt_ic_starborder.isSelected = false
                bt_ic_starborder.setImageResource(R.drawable.ic_check_starborder)
//                listCurrentSelect.add(data)
            }


//            Toast.makeText(context,
//                "selector is clicked! $position",
//                Toast.LENGTH_SHORT).show()

            }



        }

    }
}
