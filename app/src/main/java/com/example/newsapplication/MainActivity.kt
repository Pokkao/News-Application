package com.example.newsapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    val news: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addNews()

        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = LinearLayoutManager(this)


        recycler_view.layoutManager = GridLayoutManager(this, 1)
        recycler_view.adapter = AdapterRecycle(news,this)
    }

    fun addNews() {
        news.add("dog")
        news.add("cat")
        news.add("owl")
        news.add("cheetah")
        news.add("raccoon")
        news.add("bird")
        news.add("snake")
        news.add("ant")
        news.add("bee")
        news.add("tiger")
    }


}
