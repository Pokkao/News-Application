package com.example.newsapplication


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         ProfileNews()

//        querySlowDatabase { value ->  //update UI here
//            Log.d("Callback","Value of Callback func : $value")
//        }

    }

    private fun querySlowDatabase(callback: (value: Int) -> Unit) {
        val a =1
        callback.invoke(a)
    }


     private fun ProfileNews() {
        val fragment = PageNewsFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_page_news, fragment)
                .commit()
    }


    fun ProfileNews(position: Int) {
        val fragment = PageNews()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_profile_news, fragment, "findThisFragment")
            .addToBackStack(null)
            .commit()

        Log.i("c","Fragment $position")

    }

    //    public override fun onSaveInstanceState(savedInstanceState: Bundle) {
//        super.onSaveInstanceState(savedInstanceState)
//        // Save UI state changes to the savedInstanceState.
//        // This bundle will be passed to onCreate if the process is
//        // killed and restarted.
////        savedInstanceState.putBoolean("MyBoolean", true)
////        savedInstanceState.putDouble("myDouble", 1.9)
////        savedInstanceState.putInt("MyInt", 1)
////        savedInstanceState.putString("MyString", "Welcome back to Android")
////        savedInstanceState.putParcelable("ListState", recycler_view.layoutManager!!.onSaveInstanceState())
//
////        savedInstanceState.putParcelable(BUNDLE_RECYCLER_LAYOUT,
////            mRvLayoutManager!!.onSaveInstanceState())
//
//        savedRecyclerLayoutState = rv!!.layoutManager!!.onSaveInstanceState()
//    }
//
//    public override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        // Restore UI state from the savedInstanceState.
//        // This bundle has also been passed to onCreate.
////        val myBoolean = savedInstanceState.getBoolean("MyBoolean")
////        val myDouble = savedInstanceState.getDouble("myDouble")
////        val myInt = savedInstanceState.getInt("MyInt")
////        val myString = savedInstanceState.getString("MyString")
//
////        savedRecyclerLayoutState = savedInstanceState.getParcelable(BUNDLE_RECYCLER_LAYOUT)
//
//        rv!!.layoutManager!!.onRestoreInstanceState(savedRecyclerLayoutState)
//    }

}
