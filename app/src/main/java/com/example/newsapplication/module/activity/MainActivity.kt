package com.example.newsapplication.module.activity


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
import android.widget.Toast
import com.example.newsapplication.R
import com.example.newsapplication.model.ArticlesItem
import com.example.newsapplication.module.fragment.PageNewsFragment
import com.example.newsapplication.module.fragment.PageNews
import com.example.newsapplication.module.fragment.myfavoriteFragment
import kotlinx.android.synthetic.main.fragment_page_news.*
import kotlinx.android.synthetic.main.fragment_page_news2.*

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    var recyclerViewState: Parcelable? = null
    private val TAG = "MainActivity"
    private var viewIsAtHome: Boolean = false

    var arrayList: ArrayList<ArticlesItem>?=null

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

    fun keepFavorite(itemAdd: ArrayList<ArticlesItem>) {
        arrayList = itemAdd
        Log.d("favorite","${itemAdd.size}")
    }

    fun settitlebar() {
        setSupportActionBar(my_toolbar)
//        supportActionBar!!.setDisplayHomeAsUpEnabled(true)  //arrow
        supportActionBar!!.setDisplayShowTitleEnabled(false)

    }

    fun setupTitleName(title: String?) {
        tv_toolbar.text = "$title"
    }

    fun setupTitle(title: String) {
        tv_toolbar.text = "$title"
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
//        drawer_layout.closeDrawer(GravityCompat.START)
        when (item.itemId) {

            R.id.menu_list_news ->{
//                ProfileNews()
                Toast.makeText(this@MainActivity, "Coming Soon!!", Toast.LENGTH_SHORT).show()
            }
            R.id.menu_my_favorite -> {
                myFavrite()
//                Log.d(TAG, "listCurrentSelect: $listCurrentSelect")
//                Myfavorite(listCurrentSelect)
                    Log.d(TAG, "onNavigationItemSelected: " + item.title)}
            R.id.menu_my_other -> {
                Toast.makeText(this@MainActivity, "Coming Soon!!", Toast.LENGTH_SHORT).show()
                    Log.d(TAG, "onNavigationItemSelected: " + item.title)}
            R.id.menu_my_setting -> {
                Toast.makeText(this@MainActivity, "Coming Soon!!", Toast.LENGTH_SHORT).show()
                    Log.d(TAG, "onNavigationItemSelected: " + item.title)
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


     private fun ProfileNews() {
        val fragment = PageNewsFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_page_news, fragment)
                .commitAllowingStateLoss()
    }

    private fun ProfileNewsTWO() {
        val fragment = PageNewsFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_page_news, fragment)
            .addToBackStack(null)
            .commitAllowingStateLoss()
    }

    private fun myFavrite() {
        val fragment = myfavoriteFragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_page_news, fragment.newInstance(arrayList))
            .addToBackStack(null)
            .commitAllowingStateLoss()
    }

    override fun onBackPressed() {

        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
            Log.d("AAAAA","mainA")
        }
        else{

            super.onBackPressed()
//            drawer_layout.closeDrawer(GravityCompat.START)
            Log.d("BBBBB","mainB")
        }
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
