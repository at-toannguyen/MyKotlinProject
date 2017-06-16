package com.example.asiantech.myprojectkotlin.activities

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.example.asiantech.myprojectkotlin.R
import com.example.asiantech.myprojectkotlin.adapters.NewsAdapter
import com.example.asiantech.myprojectkotlin.api.SOService
import com.example.asiantech.myprojectkotlin.listeners.OnClickItemListener
import com.example.asiantech.myprojectkotlin.models.NewsResponse
import com.example.asiantech.myprojectkotlin.utils.MyAPIUtil
import kotlinx.android.synthetic.main.activity_news.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class NewsActivity : AppCompatActivity(), OnClickItemListener {
    // Const
    companion object {
        private val SECOND_DELAY_LOAD_MORE_DATA = 1000
    }

    private val mService: SOService = MyAPIUtil.getSOService()
    private val mNewsList = ArrayList<NewsResponse.News>()
    private val mHandler: Handler = Handler()
    private var mNameCategory: String? = null
    private var mID: String? = null
    private var mLayoutManager = LinearLayoutManager(this)
    private var mAdapter = NewsAdapter(this, mNewsList, this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        mID = intent.extras.getString("idCategory")
        mNameCategory = intent.extras.getString("nameCategory")
        initView()
        loadData(false)
        onClickViews()
        initLoadMore()
    }

    /**
     * This method load data on screen
     */
    private fun loadData(isLoadMore: Boolean) {
        when (TextUtils.equals(mID.toString(), "1")) {
            true -> getNewsAllCategories(isLoadMore)
            false -> getNewsCategories(isLoadMore)
        }
    }

    private fun initView() {
        recyclerView.layoutManager = mLayoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = mAdapter
        tvCategoryName.text = mNameCategory.toString()
    }

    /**
     * This method use to get news from all categories
     */
    private fun getNewsAllCategories(isLoadMore: Boolean) {
        mService.getAllNews().enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>?, response: Response<NewsResponse>?) {
                fillDataToList(isLoadMore, response!!)
            }

            override fun onFailure(call: Call<NewsResponse>?, t: Throwable?) {
                progressBarNew.visibility = View.GONE
                Toast.makeText(this@NewsActivity, R.string.toast_text_error_load_data, Toast.LENGTH_SHORT).show()
            }
        })
    }

    /**
     *
     */
    private fun getNewsCategories(isLoadMore: Boolean) {
        mService.getNews(mID.toString()).enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>?, response: Response<NewsResponse>?) {
                fillDataToList(isLoadMore, response!!)
            }

            override fun onFailure(call: Call<NewsResponse>?, t: Throwable?) {
                progressBarNew.visibility = View.GONE
                Toast.makeText(this@NewsActivity, R.string.toast_text_error_load_data, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun fillDataToList(isLoadMore: Boolean, response: Response<NewsResponse>) {
        if (!response.isSuccessful) {
            return
        }
        if (!isLoadMore) {
            mNewsList.clear()
        }
        mNewsList.addAll(response.body().data)
        mAdapter.notifyDataSetChanged()
        progressBarNew.visibility = View.GONE
    }

    private fun initLoadMore() {
        recyclerView.addOnScrollListener(object :RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val lastVisibleItem=mLayoutManager.findLastCompletelyVisibleItemPosition()
                if (lastVisibleItem==mNewsList.size-1){
                    progressBarNew.visibility=View.VISIBLE
                    mHandler.postDelayed(object :TimerTask(){
                        override fun run() {
                            loadData(true)
                        }

                    }, SECOND_DELAY_LOAD_MORE_DATA.toLong())
                }
            }
        })

    }

    private fun onClickViews() {
        imgBack.setOnClickListener {
            finish()
        }
    }

    override fun onClickItem(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
