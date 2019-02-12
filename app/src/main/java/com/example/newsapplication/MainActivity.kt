package com.example.newsapplication


import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Callback
import retrofit2.converter.gson.GsonConverterFactory
import android.util.Log
import android.widget.Toast
import com.example.newsapplication.ModelItem.ArticlesItem
import com.example.newsapplication.ModelItem.ResponseNews
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadJson()

    }

        private fun loadJson() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        val request = retrofit.create(NewsRetofit::class.java)
        val call = request.getJSON()
        Log.d("URLCalled", ""+call.request().url())



        call.enqueue(object : Callback<ResponseNews> {
            override fun onResponse(call: Call<ResponseNews>, response: Response<ResponseNews>) {
//                val jsonResponse = response.body()?.getEmployeeArrayList()
                  initView(response.body()?.getNewsArrayList(),this@MainActivity)  //articles
            }

            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show()
            }
        })

    }

        fun initView(NewsArrayList: ArrayList<ArticlesItem>?,context: Context) {
            recycler_view.setHasFixedSize(true)

            val layoutManager = LinearLayoutManager(this@MainActivity)
            recycler_view.layoutManager = layoutManager
            recycler_view.adapter = AdapterRecycle(NewsArrayList,context)
        }


}
