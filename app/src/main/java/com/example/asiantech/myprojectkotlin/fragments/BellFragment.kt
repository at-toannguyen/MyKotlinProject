package com.example.asiantech.myprojectkotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.asiantech.myprojectkotlin.R

/**
 * BellFragment
 *
 * @author at-ToanNguyen
 */
class BellFragment() : android.support.v4.app.Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        view != inflater?.inflate(R.layout.fragment_bell, container, false)
        return view
    }
}