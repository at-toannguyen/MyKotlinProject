package com.example.asiantech.myprojectkotlin.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.asiantech.myprojectkotlin.R
import com.example.asiantech.myprojectkotlin.listeners.OnClickItemListener
import com.example.asiantech.myprojectkotlin.models.CategoryResponse
import com.example.asiantech.myprojectkotlin.utils.ScreenUtil
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_item_fragment_home.view.*

/**
 * HomeFragmentAdapter
 *
 * @author at-ToanNguyen
 */
class HomeFragmentAdapter(private val mConText: Context
                          , private val mCategories: List<CategoryResponse.Category>
                          , private val mListener: OnClickItemListener)
    : RecyclerView.Adapter<HomeFragmentAdapter.HomeHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HomeHolder {
        val view: View = LayoutInflater.from(mConText).inflate(R.layout.layout_item_fragment_home, parent, false)
        return HomeHolder(view)
    }

    override fun onBindViewHolder(holder: HomeHolder?, position: Int) {
        val item: CategoryResponse.Category = mCategories[position]
        holder?.itemView?.tvNameCategory?.text = item.nameCategory
        Picasso.with(mConText)
                .load(item.imgCategory)
                .resize(ScreenUtil.getScreenWidth(mConText) / 2, ScreenUtil.getScreenHeight(mConText) / 3)
                .into(holder?.itemView?.imgCategory)

    }

    override fun getItemCount(): Int {
        return mCategories.size
    }

    inner class HomeHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView?.setOnClickListener {
                mListener.onClickItem(adapterPosition)
            }
        }
    }
}