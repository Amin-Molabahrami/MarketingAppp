package com.example.myapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences=getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        val actionbar=supportActionBar
        actionbar?.title ="Login Menu"
        actionbar?.setDisplayHomeAsUpEnabled(true)

        binding.ItemButton.setOnClickListener {
            OK()
        }
    }
    fun OK(){
        val username=binding.usernameEditText.text.toString()
        val password=binding.passEditText.text.toString()
        if(username.equals(preferences.getString("Username",""))){
            if(password.equals(preferences.getString("Password",""))){
                val intent= Intent(this,Welcome::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Wrong Password", Toast.LENGTH_LONG).show()
            }
        }
        else{
            Toast.makeText(this,"Wrong Username",Toast.LENGTH_LONG).show()
        }
    }
}