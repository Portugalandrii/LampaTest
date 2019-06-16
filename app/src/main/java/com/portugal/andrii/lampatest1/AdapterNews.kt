package com.portugal.andrii.lampatest1

import android.content.Context
import android.os.Handler
import android.support.v4.view.ViewPager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.portugal.andrii.lampatest1.pojo.Result
import com.viewpagerindicator.CirclePageIndicator
import kotlinx.android.synthetic.main.header_layout.view.*
import kotlinx.android.synthetic.main.item.view.*
import java.util.*

class AdapterNews(val results: List<Result>, val context: Context): RecyclerView.Adapter<AdapterNews.ViewHolder>() {
    var HEADER = 0
    var ITEM =1
    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int): ViewHolder {
       if (viewtype==0) return HeaderViewHolder(LayoutInflater.from(context).inflate(R.layout.header_layout, parent, false))
       else return ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
    }

    override fun getItemCount(): Int {
        return results.size
    }

    override fun onBindViewHolder(vh: ViewHolder, posit: Int) {
        if (posit!=0){
            val itemViewHolder = vh as ItemViewHolder
            Glide.with(context).load(results[posit].image.url).into(itemViewHolder?.image)
            itemViewHolder.name?.text = results.get(posit).name
            itemViewHolder.price?.text = results.get(posit).price.toString()
            itemViewHolder.id?.text = results.get(posit).id.toString()
        }else{
            val headerViewHolder = vh as HeaderViewHolder
            headerViewHolder.pager1!!.adapter = context?.let { SlidingAdapter(it, results!!) }
            headerViewHolder.indicator!!.setViewPager(headerViewHolder.pager1)
            val density = context.resources.displayMetrics.density

            //Set circle indicator radius
            headerViewHolder.indicator.setRadius(4 * density)
            var NUM_PAGES = results!!.size

            // Auto start of viewpager
            val handler = Handler()
            val Update = Runnable {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0
                }
                headerViewHolder.pager1!!.setCurrentItem(currentPage++, true)
            }
            val swipeTimer = Timer()
        swipeTimer.schedule(object : TimerTask() {
            override fun run() {
                handler.post(Update)
            }
        }, 3000, 3000)

            headerViewHolder.indicator.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {

                override fun onPageSelected(position: Int) {
                    currentPage = position

                }

                override fun onPageScrolled(pos: Int, arg1: Float, arg2: Int) {

                }

                override fun onPageScrollStateChanged(pos: Int) {

                }
            })
        }

        }

    override fun getItemViewType(position: Int): Int {
        if (position==0) return HEADER
        else return ITEM
    }
    open inner class ViewHolder(view: View): RecyclerView.ViewHolder(view)
    inner  class ItemViewHolder(view: View): ViewHolder(view){

        var name = view.text_name
        var image = view.image1
        var price = view.text_date
        var id = view.text_id
    }
    inner class HeaderViewHolder(view: View): ViewHolder(view){
        val indicator = view?.findViewById(R.id.indicator1) as CirclePageIndicator
        var pager1 = view.pager1
    }

    companion object {
        private var currentPage = 0
    }
}



