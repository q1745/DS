package com.example.ds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stockpile.DaoUser
import com.example.stockpile.SPUtils
import com.example.stockpile.User

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn.setOnClickListener {
            val user = User()
            user.setName("你好吼吼")
            DaoUser.getdaouser(this)?.getinsert(user)
        }
    }
}