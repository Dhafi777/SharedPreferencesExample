package com.dhafi.sharedpreferencesexample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Context
import com.dhafi.sharedpreferencesexample.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLoad.setOnClickListener {
            val filename = MainActivity.SHARED_PREFS_FILENAME  // Menggunakan nama file dari MainActivity
            val pref = getSharedPreferences(filename, Context.MODE_PRIVATE)
            val firstName = pref.getString("firstName", "")
            val lastName = pref.getString("lastName", "")
            binding.tvOutput.text = "$firstName $lastName"
        }

    }
    override fun onResume() {
        super.onResume()
        binding.tvOutput.text = "Click Button Load Data"
    }
}