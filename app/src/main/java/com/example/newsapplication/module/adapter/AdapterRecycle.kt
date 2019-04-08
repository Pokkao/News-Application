package com.example.newsapplication.module.adapter


import android.view.ViewGroup
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import com.example.newsapplication.R
import com.example.newsapplication.module.adapter.viewholder.ViewHolder
import com.example.newsapplication.model.ArticlesItem
import com.example.newsapplication.module.activity.MainActivity
import android.util.SparseBooleanArray
import kotlinx.android.synthetic.main.main_recycleview.view.*


class AdapterRecycle(
    private val item: ArrayList<ArticlesItem>?,
    val activityMain: MainActivity,
    val pagenew: String?,
    val callBack: (ArticlesItem) -> Unit
) : RecyclerView.Adapter<ViewHolder>() {

    var selectedItems = SparseBooleanArray()


    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.main_recycleview,
                parent,
                false
            ),this
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        selectedItems.get(position,false)
         holder.itemView.bt_ic_starborder.isSelected = selectedItems.get(position,false)

         holder.bind(item!![position],pagenew,activityMain,selectedItems,callBack)

    }

    override fun getItemCount(): Int {
        return item!!.size
    }


    fun remove(position: Int){

        item!!.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, itemCount)

    }

}
