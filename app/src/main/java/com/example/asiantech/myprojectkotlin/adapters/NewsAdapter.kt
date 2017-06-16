package com.example.asiantech.myprojectkotlin.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.asiantech.myprojectkotlin.R
import com.example.asiantech.myprojectkotlin.listeners.OnClickItemListener
import com.example.asiantech.myprojectkotlin.models.NewsResponse
import com.example.asiantech.myprojectkotlin.utils.FormatDateUtil
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_item_activity_news.view.*

/**
 * NewsAdapter
 *
 * @author at-ToanNguyen
 */
class NewsAdapter(var mContext: Context
                  , var mNewses: List<NewsResponse.News>
                  , var mListener: OnClickItemListener) : RecyclerView.Adapter<NewsAdapter.NewsHolder>() {
    override fun onBindViewHolder(holder: NewsHolder?, position: Int) {
        val item: NewsResponse.News = mNewses[position]
        Picasso.with(mContext).load(item.srcImage).into(holder?.itemView?.imgNews)
        holder?.itemView?.tvTitle?.text = item.titleNews
        holder?.itemView?.tvContent?.text = item.contentNews
        holder?.itemView?.tvDate?.text = mContext.resources.getString(R.string.string_text_date_sale
                , FormatDateUtil.formatDate(item.dayStart)
                , FormatDateUtil.formatDate(item.dayEnd))
    }

    override fun getItemCount(): Int {
        return mNewses.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NewsHolder? {
        val view: View = LayoutInflater.from(parent?.context)
                .inflate(R.layout.layout_item_activity_news, parent, false)
        return NewsHolder(view)
    }

    inner class NewsHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView?.setOnClickListener {
                mListener.onClickItem(adapterPosition)
            }
        }
    }


}