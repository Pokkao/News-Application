package com.example.newsapplication.model

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