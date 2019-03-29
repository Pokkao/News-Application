package com.example.newsapplication.module.activity


import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.support.annotation.NonNull
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import android.view.MenuItem
import android.view.View
import com.example.newsapplication.R
import com.example.newsapplication.module.fragment.PageNewsFragment
import com.example.newsapplication.module.fragment.PageNews
import kotlinx.android.synthetic.main.fragment_page_news.*
import kotlinx.android.synthetic.main.fragment_page_news2.*


class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    var recyclerViewState: Parcelable? = null
    private val TAG = "MainActivity"
    var a = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        settitlebar()
        setNavigation()
        ProfileNews()
        clickoptionBar()


    }

    private fun setNavigation() {
        nav_view!!.setNavigationItemSelectedListener(this@MainActivity)
        nav_view.setBackgroundResource(R.color.line_color_university)
    }

    private fun clickoptionBar() {
        bt_option_menu.setOnClickListener {
            drawer_layout.openDrawer(GravityCompat.START)
        }
    }


    fun settitlebar() {
        setSupportActionBar(my_toolbar)
//        supportActionBar!!.setDisplayHomeAsUpEnabled(true)  //arrow
        supportActionBar!!.setDisplayShowTitleEnabled(false)

    }

    fun setupTitleName(title: String?) {
        tv_toolbar.text = "$title"
    }

    fun setupTitle() {
        tv_toolbar.text = "News Application"
    }

    fun ModeOption(b: Boolean) {
        if(b){
            bt_option_night_mode.visibility = View.VISIBLE
        }else{
            bt_option_night_mode.visibility = View.INVISIBLE
        }
    }

    fun ChangeMode() {

                bt_option_night_mode.setOnClickListener {
                    if(!bt_option_night_mode.isSelected){
                        layout_page_news.setBackgroundResource(R.color.black_opacity50)
                        im_page_topic.alpha = 0.5F
//                        tv_content.setTextColor(Color.parseColor("#72000000"));
                        bt_option_night_mode.isSelected = true
                    }else {
                        layout_page_news.setBackgroundResource(R.color.tab_selected_dialog)
                        im_page_topic.alpha = 1F
//                        tv_content.setTextColor(Color.parseColor("#CC000000"));
                        bt_option_night_mode.isSelected = false
                    }

        }
    }


//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        this.menu = menu
//        menuInflater.inflate(R.menu.menu_main, menu)
//        nav_view.setBackgroundResource(R.color.line_color_university)
//
//
//
//        return true
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        val id = item.itemId
//        if (id == R.id.action_favorite) {
//
////            **drawer_layout.openDrawer(GravityCompat.START)
////            Toast.makeText(this@MainActivity, "Thank you for Click! :)", Toast.LENGTH_LONG).show()
//            return true
//        }
//
//        return super.onOptionsItemSelected(item)
//    }


    override fun onNavigationItemSelected(@NonNull item: MenuItem): Boolean {
        item.isChecked = true

        when (item.itemId) {
            R.id.menu_my_favorite -> Log.d(TAG, "onNavigationItemSelected: " + item.title)
            R.id.menu_my_other -> Log.d(TAG, "onNavigationItemSelected: " + item.title)
            R.id.menu_my_setting -> Log.d(TAG, "onNavigationItemSelected: " + item.title)

        }
        drawer_layout.closeDrawers()
        return true
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
