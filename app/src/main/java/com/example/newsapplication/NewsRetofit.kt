package com.example.newsapplication


import com.example.newsapplication.ModelItem.ResponseNews
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.newsapplication.ModelTest.EmployeeList




interface NewsRetofit {

    @GET("top-headlines?sources=bbc-news&apiKey=ce6cca4d41c8472ba2e4acd1d7064fd6")
//    fun getJSON(@Query("sources=bbc-news&apiKey=ce6cca4d41c8472ba2e4acd1d7064fd6") sources:Int): Call<ResponseNews>
//    fun getJSON(@Query("company_no") companyNo: Int): Call<EmployeeList>
    fun getJSON() : Call<ResponseNews>


}