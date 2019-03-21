package com.example.newsapplication

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.example.newsapplication.ModelItem.ArticlesItem
import kotlinx.android.synthetic.main.main_recycleview.view.*
import android.util.SparseBooleanArray

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//    override fun onClick(v: View?) {
//        Toast.makeText(context,
//                "ImageButton (selector) is clicked!$position",
//                Toast.LENGTH_SHORT).show()
//    }


    private var pagenews: PageNewsFragment? = null
    var myFragmentNew=PageNewsFragment()


    var listCurrentSelect: ArrayList<ArticlesItem> = arrayListOf()
//    lateinit var data :ArticlesItem
    var sparseBooleanArray: SparseBooleanArray? = null
    var selectedItemCount = 0
//    private val items: ArrayList<ArticlesItem>? = null

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
//            pagenews = pages

//            itemView.setOnClickListener(this@ViewHolder)
//            this.myFragmentNew = myFragmentNew

            text_topic.text = item.title
            text_sub_content.text = item.description
            Glide.with(context).load(item.urlToImage).into(Image_topic)
            Realtime_date.text = item.publishedAt

//            val intent = Intent()

            Image_topic.setOnClickListener {
//
//                pages!!.ProfileNews(position)
                mainActivity.ProfileNews(position)

//                Log.i("Profile","Viewholder")
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
