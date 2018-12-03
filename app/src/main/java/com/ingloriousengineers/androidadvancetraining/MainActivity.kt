package com.ingloriousengineers.androidadvancetraining

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var isFragmentDisplayed: Boolean = false
    lateinit var btn: Button

    val STATE_FRAGMENT = "state_of_fragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.open_button)

        if (savedInstanceState != null) {
            isFragmentDisplayed = savedInstanceState.getBoolean(STATE_FRAGMENT)
            if (isFragmentDisplayed) {
                btn.text = getString(R.string.close)
            }
        }

        btn.setOnClickListener {
            if (!isFragmentDisplayed) {
                displayFragment()
            } else {
                closeFragment()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState!!.putBoolean(STATE_FRAGMENT, isFragmentDisplayed)
        super.onSaveInstanceState(outState)
    }

    private fun closeFragment() {
        val fragmentManager = supportFragmentManager
        val simpleFragment = fragmentManager.findFragmentById(R.id.fragment_container)
        if(simpleFragment != null) {
            val fragmentTransaction =fragmentManager.beginTransaction()
            fragmentTransaction.remove(simpleFragment).commit()
        }

        btn.text = getString(R.string.open)
        isFragmentDisplayed = false
    }

    private fun displayFragment() {
        val simpleFragment = SimpleFragment.newInstance()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragment_container, simpleFragment).addToBackStack(null).commit()

        btn.text = getString(R.string.close)
        isFragmentDisplayed = true

    }
}
