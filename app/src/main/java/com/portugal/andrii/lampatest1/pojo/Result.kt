package com.portugal.andrii.lampatest1.pojo

import com.portugal.andrii.lampatest1.pojo.Currency
import com.portugal.andrii.lampatest1.pojo.Image

data class Result(
    val category: Int,
    val currency: Currency,
    val email_count: Int,
    val favorite: Boolean,
    val id: Int,
    val image: Image,
    val name: String,
    val owner: Boolean,
    val phone_count: Int,
    val price: Int,
    val price_month: Int,
    val price_week: Int,
    val view_count: Int
)