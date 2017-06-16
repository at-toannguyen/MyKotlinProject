package com.example.asiantech.myprojectkotlin.fragments

import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.asiantech.myprojectkotlin.R
import com.example.asiantech.myprojectkotlin.adapters.HomeFragmentAdapter
import com.example.asiantech.myprojectkotlin.api.SOService
import com.example.asiantech.myprojectkotlin.listeners.OnClickItemListener
import com.example.asiantech.myprojectkotlin.models.CategoryResponse
import com.example.asiantech.myprojectkotlin.utils.MyAPIUtil
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * HomeFragment
 *
 * @author at-ToanNguyen
 */
class HomeFragment() : android.support.v4.app.Fragment(), OnClickItemListener {


    companion object {
        private const val SPAN_COUNT_GRIDLAYOUT_MANAGER = 2
        private const val SECOND_DELAY_TO_SHOW_DATA = 3000
    }

    val mService: SOService = MyAPIUtil.getSOService()
    val mHandler: Handler = Handler()

    var mCategories = ArrayList<CategoryResponse.Category>()
    var mAdapter: HomeFragmentAdapter? = null
    var mLayout: RecyclerView.LayoutManager? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        initList()
        loadData()
    }

    private fun initList() {
        mAdapter = HomeFragmentAdapter(context, mCategories, this)
        mLayout = GridLayoutManager(context, SPAN_COUNT_GRIDLAYOUT_MANAGER) as RecyclerView.LayoutManager?
        recyclerView.layoutManager = mLayout
        recyclerView.adapter = mAdapter
    }

    private fun loadData() {
        mService.getCategory().enqueue(object : Callback<CategoryResponse> {
            override fun onResponse(call: Call<CategoryResponse>?, response: Response<CategoryResponse>?) {
                Log.d("AAAAAA","AAAAAA")
                mCategories.addAll(response?.body()?.data!!)
                mAdapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<CategoryResponse>?, t: Throwable?) {
                Log.d("AAAA","AAAAAAA")
            }
        })
    }

    override fun onClickItem(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}