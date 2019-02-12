package com.example.newsapplication.ModelItem

import com.google.gson.annotations.SerializedName

class Source {

    @SerializedName("name")
    var name: String? = null

    @SerializedName("id")
    var id: String? = null

    override fun toString(): String {
        return "Source{" +
                "name = '" + name + '\''.toString() +
                ",id = '" + id + '\''.toString() +
                "}"
    }
}