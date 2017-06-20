package com.example.asiantech.myprojectkotlin.activities

import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.asiantech.myprojectkotlin.R
import com.example.asiantech.myprojectkotlin.api.SOService
import com.example.asiantech.myprojectkotlin.models.NewsDetailResponse
import com.example.asiantech.myprojectkotlin.models.StatusResponse
import com.example.asiantech.myprojectkotlin.utils.FormatDateUtil
import com.example.asiantech.myprojectkotlin.utils.MyAPIUtil
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_news_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.HttpURLConnection

class NewsDetailActivity : AppCompatActivity(), View.OnClickListener {


    val mService: SOService = MyAPIUtil.getSOService()
    var mIdUser: String? = null
    var mIdNew: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        mIdNew = intent.extras.getString("idNews")
        mService.getNewsDetail(mIdNew!!).enqueue(object : Callback<NewsDetailResponse> {
            override fun onResponse(call: Call<NewsDetailResponse>?, response: Response<NewsDetailResponse>?) {
                fillDataIntoView(response!!)
            }

            override fun onFailure(call: Call<NewsDetailResponse>?, t: Throwable?) {
                Toast.makeText(this@NewsDetailActivity, "Lỗi", Toast.LENGTH_SHORT).show()
            }
        })
        Log.d("AAAAA",mIdNew)
        onCLickViews()
    }

    internal fun fillDataIntoView(response: Response<NewsDetailResponse>) {
        if (!response.isSuccessful) {
            return;
        }
        val data: NewsDetailResponse.NewsDetail = response.body().data
        if (!TextUtils.isEmpty(data.srcImgNew)) {
            Picasso.with(this)
                    .load(data.srcImgNew)
                    .placeholder(R.drawable.img_default)
                    .into(imgNewDetail)
        }
        if (!TextUtils.isEmpty(data.srcImgUser)) {
            Picasso.with(this)
                    .load(data.srcImgUser)
                    .placeholder(R.drawable.ic_person)
                    .into(imgAvatarDetail)
        }
        tvDateTime.text = getString(R.string.string_text_date_sale
                , FormatDateUtil.formatDate(data.dayStart)
                , FormatDateUtil.formatDate(data.dayEnd))
        tvContentNewDetail.text = data.content
        tvTypeContent.text = data.nameCategory
        tvPlaceContent.text = data.nameDistricst
        tvAddressContent.text = data.address
        tvTitleNewDetail.text = data.title
        val userName = if (!TextUtils.isEmpty(data.nameUser)) data.nameUser else data.user
        tvNameUserDetail.text = userName
        mIdUser = data.idUser
    }

    override fun onClick(view: View?) {
        when (view) {
            imgFavorite -> {
                imgFavorite!!.isSelected = !view!!.isSelected
                if (view.isSelected) {
                    saveFavorite()
                } else {
                    deleteFavorite(view)
                }
            }
        }
    }

    internal fun saveFavorite() {
        mService.saveFavorite(mIdNew!!, "3").enqueue(object : Callback<StatusResponse> {
            override fun onResponse(call: Call<StatusResponse>?, response: Response<StatusResponse>?) {
                if (!response!!.isSuccessful || response.body().status != HttpURLConnection.HTTP_OK) {
                    Log.d("AAAAAA","LOGGGGG")
                    return;
                }
                Toast.makeText(this@NewsDetailActivity, R.string.toast_text_add_favorite_success
                        , Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<StatusResponse>?, t: Throwable?) {
                Toast.makeText(this@NewsDetailActivity, R.string.toast_text_add_favorite_fail
                        , Toast.LENGTH_SHORT).show()
            }
        })
    }

    internal fun deleteFavorite(view: View) {
        view.isSelected = true
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.dialogbuilder_text_title_builder)
        builder.setIcon(R.drawable.ic_sad)
        builder.setPositiveButton(R.string.button_text_ok, object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                mService.deleteFavorite(mIdNew!!, "3").enqueue(object : Callback<StatusResponse> {
                    override fun onResponse(call: Call<StatusResponse>?, response: Response<StatusResponse>?) {
                        if (!response!!.isSuccessful || response.body().status != HttpURLConnection.HTTP_OK) {
                            return;
                        }
                        view.isSelected = false
                        Toast.makeText(this@NewsDetailActivity, R.string.toast_text_delete_favorite_success
                                , Toast.LENGTH_SHORT).show()
                    }

                    override fun onFailure(call: Call<StatusResponse>?, t: Throwable?) {
                        Toast.makeText(this@NewsDetailActivity, R.string.toast_text_delete_favorite_fail
                                , Toast.LENGTH_SHORT).show()
                    }
                })
            }

        })
        builder.setNegativeButton(R.string.button_text_cancel, null)
        builder.create().show()
    }

    internal fun onCLickViews() {
        imgFavorite.setOnClickListener(this)
    }
}
