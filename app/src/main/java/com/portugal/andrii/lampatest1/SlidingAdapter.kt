package com.portugal.andrii.lampatest1

import android.content.Context
import android.os.Parcelable
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.portugal.andrii.lampatest1.pojo.Result

class SlidingAdapter(private val context: Context, private val list: List<Result>) : PagerAdapter() {
    private val inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return list!!.size
    }
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageLayout = inflater.inflate(R.layout.sliding,container,false!!)
        val imageView = imageLayout.findViewById(R.id.sliding_image) as ImageView

        val sliding_name = imageLayout.findViewById(R.id.sliding_name) as TextView
        var text = list.get(position).name
        sliding_name.setText(text)

        Glide.with(context).load(list[position].image.url).into(imageView)
        container.addView(imageLayout)
        return imageLayout
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(container)
        //super.destroyItem(container, position, `object`)
    }

    override fun restoreState(state: Parcelable?, loader: ClassLoader?) {
      // super.restoreState(state, loader)
    }

    override fun saveState(): Parcelable? {
        //return super.saveState()
        return null
    }
}