package com.example.newsapplication.model

import com.google.gson.annotations.SerializedName

class ResponseNews {

    @SerializedName("status")
    var status: String? = null

    @SerializedName("totalResults")
    var totalResults: Int = 0

    @SerializedName("articles")
    var articles: ArrayList<ArticlesItem>? = null

    fun getNewsArrayList(): ArrayList<ArticlesItem>? {
        return articles
    }

    override fun toString(): String {
        return "Response{" +
                "totalResults = '" + totalResults + '\''.toString() +
                ",articles = '" + articles + '\''.toString() +
                ",status = '" + status + '\''.toString() +
                "}"
    }
}