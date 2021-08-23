package com.example.myapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    lateinit var sharePreferences:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharePreferences=getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        val actionbar=supportActionBar
        actionbar?.title ="Register Menu"
        actionbar?.setDisplayHomeAsUpEnabled(true)

        binding.ItemButton.setOnClickListener {
            ConfirmPass()
        }
    }
    @SuppressLint("ResourceAsColor")
    fun ConfirmPass(){
        val username=binding.usernameEditText.text.toString()
        val password=binding.passEditText.text.toString()
        val confpass=binding.confirmPassEditText.text.toString()
        val editor:SharedPreferences.Editor=sharePreferences.edit()
        if(password.equals(confpass)){
            editor.putString("Username",username)
            editor.putString("Password",password)
            editor.apply()

            binding.wrongRight.text="Password accepted."
            binding.wrongRight.setTextColor(R.color.green)

            Toast.makeText(this,"Information saved",Toast.LENGTH_LONG).show()

            val intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        else {
            binding.wrongRight.text = "Confirm password isnt equal with password."
            binding.wrongRight.setTextColor(R.color.red)
        }

    }
}