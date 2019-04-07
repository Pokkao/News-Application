package com.example.newsapplication.module.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.util.SparseBooleanArray
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.newsapplication.R
import com.example.newsapplication.model.ArticlesItem
import com.example.newsapplication.module.activity.MainActivity
import kotlinx.android.synthetic.main.main_recycleview.view.*

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var arrayList: ArrayList<ArticlesItem> = arrayListOf()

    init {
//Ex1        this.context = context
//            this.a = a
    }


    fun bind(
        item: ArticlesItem,
        pages: String?,
        mainActivity: MainActivity,
        selected: SparseBooleanArray?,
        callBack: (ArticlesItem) -> Unit
    ) {

        with(itemView){

            text_topic.text = item.title
            text_sub_content.text = item.description
            Glide.with(context).load(item.urlToImage).into(Image_topic)
            Realtime_date.text = item.publishedAt

            bt_ic_starborder.isSelected = item.isChecked

//            Log.d("ListArrayNoinBtn","${arrayList.size}")

            Image_topic.setOnClickListener {
                val integer = Integer.valueOf(position)
//                Log.i("Profile","$integer")
                if(item.content != null) {
                    mainActivity.ProfileNews(
                        integer, item.title!!, item.urlToImage!!, item.author!!,
                        item.content!!, item.publishedAt!!, item.url!!, item.description!!
                    )
                }else {
                    Toast.makeText(context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show()

                }

            }


//            selected!!.get(adapterPosition, false)

            if (selected!!.get(adapterPosition, false)) {
                bt_ic_starborder.isSelected = true
                selected.put(adapterPosition,true)
                bt_ic_starborder.setImageResource(R.drawable.ic_check_star)
            }else{
                selected.put(adapterPosition,false)
                bt_ic_starborder.isSelected = false
                bt_ic_starborder.setImageResource(R.drawable.ic_check_starborder)
            }


            bt_ic_starborder.setOnClickListener{
//                selected!!.get(adapterPosition, false)

                    if (!bt_ic_starborder.isSelected) {
//                                        sparseBooleanArray!!.put(adapterPosition,true)
//                        bt_ic_starborder.isSelected = false
                        selected.put(adapterPosition,true)


                        item.isChecked = true
//                        itemView.tag = item
                        bt_ic_starborder.isSelected = true

                        bt_ic_starborder.setImageResource(R.drawable.ic_check_star)
                        //                listCurrentSelect.add(data)

//                        arrayList.add(item)
//                        Log.d("ListArray","${arrayList.size}")

                        callBack.invoke(item)

                    } else {
                        //                sparseBooleanArray!!.put(adapterPosition,false)
//                        selected.put(adapterPosition,true)
                        selected.delete(adapterPosition)



                        item.isChecked = false
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
