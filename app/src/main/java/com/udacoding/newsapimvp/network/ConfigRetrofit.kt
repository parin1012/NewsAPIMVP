package com.udacoding.newsapimvp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigRetrofit {
    companion object{
        fun getRetrofit():NewsService{
            val retrofit = Retrofit.Builder()
                .baseUrl("http://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service =retrofit.create(NewsService::class.java)
            return service
        }
    }
}