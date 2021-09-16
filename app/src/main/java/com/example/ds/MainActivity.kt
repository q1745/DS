package com.example.ds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


import android.view.View
import com.example.Bbody
import com.example.net.RetrofitFactory
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

import kotlinx.android.synthetic.main.activity_main.*



import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.RequestBody

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                RetrofitFactory.retrofitFactory.retrofit.create(Api::class.java)
                    .getList(Bbody(0))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object : Observer<Bean>{
                        override fun onSubscribe(d: Disposable) {

                        }

                        override fun onNext(t: Bean) {
                            Log.i("TAG", "onNext: "+t.data.get(0).categoryName)
                        }

                        override fun onError(e: Throwable) {

                        }

                        override fun onComplete() {

                        }

                    })
            }
        })
    }
}