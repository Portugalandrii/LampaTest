package com.portugal.andrii.lampatest1

import com.portugal.andrii.lampatest1.pojo.News
import com.portugal.andrii.lampatest1.pojo.Result
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Allcom {
    @GET("api/v1.0/products")
    fun getNews(): Call<News>
    companion object {
        var BASE_URL: String = "http://allcom.lampawork.com/"

        fun createAPI(): Allcom {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            //реализация интерфейса Allcom с помощью библиотеки Retrofit
            //реализация интефейса - написание тела для абстрактных функций
            val allcom:Allcom = retrofit.create(Allcom::class.java)
            return allcom
        }
    }
}
