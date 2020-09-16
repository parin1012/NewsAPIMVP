package com.udacoding.newsapimvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.udacoding.newsapimvp.R
import com.udacoding.newsapimvp.adapter.BeritaAdapter
import com.udacoding.newsapimvp.model.ArticlesItem
import com.udacoding.newsapimvp.presenter.NewsPresenter
import com.udacoding.newsapimvp.presenter.NewsView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NewsView {
    // todo 10 deklarasi variabel presenter
    private var presenter : NewsPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // todo 11 init presenter
        presenter = NewsPresenter(this)
        presenter?.getNews()

    }

    override fun onSucces(msg: String, article: List<ArticlesItem?>?) {
        // todo 12 bind data ke recycler view
        //for (i in article?.indices ?: 0..1){
            //Log.d("data news", article?.get(i)?.title)
            listBerita.adapter = BeritaAdapter(article)
        //}
    }

    override fun onError(msg: String) {
        Toast.makeText(this, msg,Toast.LENGTH_SHORT).show()
    }
}