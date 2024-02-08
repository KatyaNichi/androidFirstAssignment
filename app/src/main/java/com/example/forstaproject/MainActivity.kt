 package com.example.forstaproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.forstaproject.FirstFragment

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import android.widget.Button
import android.widget.TextView



 class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, FirstFragment.newInstance("param1", "param2"))
                .commit()
        }
        val clickButton: Button = findViewById(R.id.clickButton)

        clickButton.setOnClickListener {
            // Find the TextView from the fragment
            val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)
            if (fragment is FirstFragment) {
                val welcomeText = fragment.requireView().findViewById<TextView>(R.id.welcomeText)
                welcomeText.text = "Goodbye"
            }
        }

        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        val firstFragment = FirstFragment.newInstance("param1", "param2")
        fragmentTransaction.replace(R.id.fragmentContainer, firstFragment)


        fragmentTransaction.commit()
    }
}