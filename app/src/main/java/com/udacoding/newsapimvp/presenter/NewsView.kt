package com.udacoding.newsapimvp.presenter

import android.app.LauncherActivity
import com.udacoding.newsapimvp.model.ArticlesItem

interface NewsView {
    fun onSucces(msg : String, article : List<ArticlesItem?>?)
    fun onError(msg : String  )
}