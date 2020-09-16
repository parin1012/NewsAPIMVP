package com.udacoding.newsapimvp.network

import com.udacoding.newsapimvp.model.ResponseServer
import retrofit2.Call
import retrofit2.http.GET

interface NewsService {
    @GET("everything?q=bitcoin&from=2020-09-14&sortBy=publishedAt&apiKey=265eb491c55845caac93312688e598d5")
    fun getData():Call<ResponseServer>
}