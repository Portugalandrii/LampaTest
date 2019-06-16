package com.portugal.andrii.lampatest1

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.portugal.andrii.lampatest1.pojo.News
import com.portugal.andrii.lampatest1.pojo.Result
import kotlinx.android.synthetic.main.fragment_fragment_stories.*
import retrofit2.Response
import java.util.*

class FragmentStories : Fragment() {
    var list: List<Result>? = ArrayList<Result>()
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        var news = Allcom.createAPI().getNews()

        news.enqueue(object : retrofit2.Callback<News> {
            override fun onFailure(call: retrofit2.Call<News>, t: Throwable) {
                Toast.makeText(context, "ERROR", Toast.LENGTH_LONG).show()

            }

            override fun onResponse(call: retrofit2.Call<News>, response: Response<News>) {

                list = response.body()!!.results
                stories.layoutManager = LinearLayoutManager(context)

                var adapter: AdapterNews? = context?.let { AdapterNews(list!!, it) }
                stories.adapter = adapter
                //  android:scaleType="fitEnd"
                //  android:adjustViewBounds="true"
                //  эти строки (для элемента image в item.xml) для одинакового отображения изображений
                //  с разным разширением

            }

        })
        return inflater.inflate(R.layout.fragment_fragment_stories, container, false)
    }

}