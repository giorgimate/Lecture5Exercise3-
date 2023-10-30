package com.example.mythirdapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    private lateinit var etemail: EditText
    private lateinit var etuserName: EditText
    private lateinit var etfirstName: EditText
    private lateinit var etlastName: EditText
    private lateinit var etage: EditText
    private lateinit var clear: Button
    private lateinit var save: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clear = findViewById(R.id.clear)
        save = findViewById(R.id.save)
       var person = Person()
        etemail = findViewById(R.id.email)
        etuserName = findViewById(R.id.userName)
        etfirstName = findViewById(R.id.firstName)
        etlastName = findViewById(R.id.lastName)
        etage = findViewById(R.id.age)

        fun intent(){
            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("email",etemail.text.toString())
            intent.putExtra("username",etuserName.text.toString())
            intent.putExtra("firstname",etfirstName.text.toString())
            intent.putExtra("lastname",etlastName.text.toString())
            intent.putExtra("age",etage.text.toString())
            startActivity(intent)
        }
        fun takeInfo(){
            val email = intent.getStringExtra("email") ?: ""
            val userName = intent.getStringExtra("username") ?: ""
            val firstName = intent.getStringExtra("firstname") ?: ""
            val lastName = intent.getStringExtra("lastname") ?: ""
            val age = intent.getStringExtra("age") ?: ""
            etemail.setText(email)
            etuserName.setText(userName)
            etfirstName.setText(firstName)
            etlastName.setText(lastName)
            etage.setText(age)
        }
        takeInfo()
        save.setOnClickListener {
            val email = etemail.text.toString().trim()
            val userName = etuserName.text.toString().trim()
           val firstName = etfirstName.text.toString().trim()
            val lastName = etlastName.text.toString().trim()
            val age = etage.text.toString().toIntOrNull() ?: 0



            if (person.isValidEmail(email) != null) {
                etemail.error = person.isValidEmail(email)
                return@setOnClickListener
            }
            if (person.isValidUserName(userName) != null) {
                etuserName.error = person.isValidUserName(userName)
                return@setOnClickListener
            }
            if (person.isValidFirstName(firstName) != null) {
                etfirstName.error = person.isValidFirstName(firstName)
                return@setOnClickListener
            }
            if (person.isValidLastName(lastName) != null) {
                etlastName.error = person.isValidLastName(lastName)
                return@setOnClickListener
            }
            if (person.isValidAge(age) != null) {
                etage.error = person.isValidAge(age)
                return@setOnClickListener
            }
            intent()




        }


        clear.setOnLongClickListener{
            etemail.setText("")
            etuserName.setText("")
            etfirstName.setText("")
            etlastName.setText("")
            etage.setText("")
            true
        }

    }

}
