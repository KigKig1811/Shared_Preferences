package com.example.sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferences.databinding.ActivityAnotherAcivityBinding

class AnotherAcivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnotherAcivityBinding
    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another_acivity)

        binding = ActivityAnotherAcivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        val name = preferences.getString("NAME","")
        binding.tvName.text = name
        val age = preferences.getInt("AGE",0)
        binding.tvAge.text = age.toString()

        binding.btnLogout.setOnClickListener{

            val editor: SharedPreferences.Editor = preferences.edit()
            editor.clear()
            editor.apply()

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}