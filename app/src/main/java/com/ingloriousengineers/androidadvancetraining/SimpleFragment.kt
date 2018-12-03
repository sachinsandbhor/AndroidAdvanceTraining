package com.ingloriousengineers.androidadvancetraining


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*


class SimpleFragment : Fragment() {

    private val YES: Int = 0
    private val NO: Int = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View =  inflater.inflate(R.layout.fragment_simple, container, false)
        val radioGroup: RadioGroup = view.findViewById(R.id.radio_group)
        val ratingBar: RatingBar = view.findViewById(R.id.ratingBar)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton: RadioButton = radioGroup.findViewById(checkedId)
            val index: Int = radioGroup.indexOfChild(radioButton)
            val textView: TextView = view.findViewById(R.id.fragment_header)

            when(index) {
                YES -> textView.text = getString(R.string.yes_message)
                NO -> textView.text = getString(R.string.no_message)
            }
        }

        ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            val myRating = getString(R.string.my_rating) + ratingBar.rating.toString()
            Toast.makeText(context, myRating, Toast.LENGTH_LONG).show()
        }
        return view;
    }
    companion object {
        fun newInstance(): SimpleFragment {
            return SimpleFragment()
        }
    }





}
