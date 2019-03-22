package com.example.newsapplication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_page_news2.*
import android.content.Intent
import android.net.Uri


class PageNews : Fragment() {

    var title:String? = null
    var urlToImage:String? = null
    var author:String? = null
    var content:String? = null
    var date:String? = null
    var url:String?=null
    var desc: String?=null

    var activityMain:MainActivity?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMain = activity as MainActivity


        if(savedInstanceState==null) {
            title = arguments!!.getString("key_title")
            urlToImage = arguments!!.getString("key_urlToImage")
            author = arguments!!.getString("key_author")
            content = arguments!!.getString("key_content")
            date = arguments!!.getString("key_publishedAt")
            url = arguments!!.getString("key_url")
            desc = arguments!!.getString("key_description")
        } else {
            title = savedInstanceState.getString("key_title")
            urlToImage = savedInstanceState.getString("key_urlToImage")
            author = savedInstanceState.getString("key_author")
            content = savedInstanceState.getString("key_content")
            date = savedInstanceState.getString("key_publishedAt")
            url = savedInstanceState.getString("key_url")
            desc = savedInstanceState.getString("key_description")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_page_news2, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setView()
        initListener(url)

    }

    private fun initListener(url: String?) {
        tv_url.setOnClickListener {
            val uri = Uri.parse(url) // missing 'http://' will cause crashed
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }

    private fun setView() {
        text_page_topic.text = title
        tv_content.text = content
        Glide.with(this).load(urlToImage).into(im_page_topic)
        tv_page_author.text = author
        tv_page_realtime_date.text = date
        tv_url.text = url
        tv_page_desc.text = desc
    }

    companion object {
            fun newInstance(
                title: String,
                urlToImage: String,
                author: String,
                content: String,
                publishedAt: String,
                url: String,
                desc: String
            ): PageNews{
                val fm =PageNews()
                val bundle = Bundle()
                bundle.putString("key_title",title)
                bundle.putString("key_urlToImage",urlToImage)
                bundle.putString("key_author",author)
                bundle.putString("key_content",content)
                bundle.putString("key_publishedAt",publishedAt)
                bundle.putString("key_url",url)
                bundle.putString("key_description",desc)
                fm.arguments = bundle
            return fm
            }
    }
}
