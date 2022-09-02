package com.example.shoppingcartapp

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.shoppingcartapp.ui.CartFragment
import com.example.shoppingcartapp.ui.HomeFragment
import com.example.shoppingcartapp.ui.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView.menu.getItem(1).isEnabled = false
        replaceFragment(HomeFragment())
        bottomNavigationView.setOnItemSelectedListener() {
            fab.imageTintList = ColorStateList.valueOf(Color.rgb(255,255,255))
            when(it.itemId){
                R.id.home -> replaceFragment(HomeFragment())
                R.id.profile -> replaceFragment(ProfileFragment())
            }
            true
        }
        fab.setOnClickListener{
            fab.imageTintList = ColorStateList.valueOf(Color.rgb(77,208,225))
            replaceFragment(CartFragment())
        }

    }
    private fun replaceFragment(fragment: Fragment){
        if (fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }
    }
}