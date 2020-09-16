package com.udacoding.newsapimvp.presenter

import com.udacoding.newsapimvp.model.ResponseServer
import com.udacoding.newsapimvp.network.ConfigRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


// todo 6
class NewsPresenter(val news : NewsView) {
    fun getNews(){
        ConfigRetrofit.getRetrofit().getData().enqueue(object : Callback<ResponseServer>{
            override fun onResponse(
                call: Call<ResponseServer>,
                response: Response<ResponseServer>
            ) {
                if(response.isSuccessful){
                    val dataNews = response.body()?.articles
                    if (dataNews?.size ?:  0 > 0){
                        // todo 7
                        news.onSucces(response.message(),dataNews)
                    }else{
                        // todo 8
                        news.onError("Data kosong")
                    }
                }
            }

            override fun onFailure(call: Call<ResponseServer>, t: Throwable) {
                // todo 9
                news.onError(t.localizedMessage)
            }
        })
    }
}