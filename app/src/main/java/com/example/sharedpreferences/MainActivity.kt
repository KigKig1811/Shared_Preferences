
package com.example.sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    var isRemember = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        isRemember = sharedPreferences.getBoolean("CHECKBOX", false)

        if(isRemember){

            val intent = Intent(this,AnotherAcivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnLogin.setOnClickListener{

            val name: String = binding.tvName.text.toString()
            val age: Int = binding.tvAge.text.toString().toInt()
            val checkBox: Boolean = binding.checkBox.isChecked

            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("NAME", name)
            editor.putInt("AGE", age)
            editor.putBoolean("CHECKBOX", checkBox)
            editor.apply()

            Toast.makeText(this,"Information saved !",Toast.LENGTH_SHORT).show()

            val intent = Intent(this,AnotherAcivity::class.java)
            startActivity(intent)
            finish()
            
        }


    }
}