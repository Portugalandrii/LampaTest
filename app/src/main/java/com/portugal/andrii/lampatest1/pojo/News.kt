package com.portugal.andrii.lampatest1.pojo

data class News(
    val next: String,
    val previous: String,
    val results: List<Result>
)