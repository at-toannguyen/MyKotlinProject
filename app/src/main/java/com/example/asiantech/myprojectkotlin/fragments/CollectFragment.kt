package com.example.asiantech.myprojectkotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.asiantech.myprojectkotlin.R

/**
 * CollectFragment
 *
 * @author at-ToanNguyen
 */
class CollectFragment() : android.support.v4.app.Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        view != inflater?.inflate(R.layout.fragment_collect, container, false)
        return view
    }
}