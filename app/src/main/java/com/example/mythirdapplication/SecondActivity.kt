package com.example.mythirdapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val viewUserName = findViewById<TextView>(R.id.viewUserName)
        val viewEmail = findViewById<TextView>(R.id.viewEmail)
        val viewFullName = findViewById<TextView>(R.id.viewFullName)
        val viewAge = findViewById<TextView>(R.id.viewAge)
        val again = findViewById<Button>(R.id.again)
        val email = intent.getStringExtra("email") ?: ""
        val userName = intent.getStringExtra("username") ?: ""
        val firstName = intent.getStringExtra("firstname") ?: ""
        val lastName = intent.getStringExtra("lastname") ?: ""
        val age = intent.getStringExtra("age") ?: ""
        fun intent(){
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("email",email)
            intent.putExtra("username",userName)
            intent.putExtra("firstname",firstName)
            intent.putExtra("lastname",lastName)
            intent.putExtra("age",age)
            startActivity(intent)

        }

        viewUserName.text = userName
        viewEmail.text = email
        viewFullName.text ="${firstName}   ${lastName}"
        viewAge.text = age
        again.setOnClickListener{
            intent()
        }

    }
}