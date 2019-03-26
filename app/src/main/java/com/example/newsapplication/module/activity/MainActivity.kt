package com.example.newsapplication.module.activity


import android.app.PendingIntent.getActivity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.newsapplication.module.fragment.PageNewsFragment
import com.example.newsapplication.R
import com.example.newsapplication.module.fragment.PageNews
import kotlinx.android.synthetic.main.fragment_page_news.*
import kotlinx.android.synthetic.main.fragment_page_news2.*
import kotlinx.android.synthetic.main.fragment_page_news2.view.*


class MainActivity : AppCompatActivity() {

    var recyclerViewState: Parcelable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        settitlebar()
        ProfileNews()

    }


    fun settitlebar() {
        setSupportActionBar(my_toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }

    fun setupTitleName(title: String?) {
        tv_toolbar.text = "$title"
    }

    fun setupTitle() {
        tv_toolbar.text = "News Application"
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_favorite) {
            Toast.makeText(this@MainActivity, "Thank you for Click! :)", Toast.LENGTH_LONG).show()
            return true
        }

        return super.onOptionsItemSelected(item)
    }


     private fun ProfileNews() {
        val fragment = PageNewsFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_page_news, fragment)
                .commit()
    }


    fun ProfileNews(position: Int, title: String, urlToImage: String, author: String, content: String, publishedAt: String, url: String, desc: String) {
        val fragment = PageNews

        supportFragmentManager.beginTransaction()
            .add(
                R.id.fragment_profile_news,
                PageNews.newInstance(
                    position,
                    title,
                    urlToImage,
                    author,
                    content,
                    publishedAt,
                    url,
                    desc
                ), "findThisFragment")
            .addToBackStack(null)
            .commit()
    }

    public override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        recyclerViewState = recycler_view.layoutManager!!.onSaveInstanceState()

    }

    public override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            recycler_view.layoutManager!!.onRestoreInstanceState(recyclerViewState)
        }
    }


}
