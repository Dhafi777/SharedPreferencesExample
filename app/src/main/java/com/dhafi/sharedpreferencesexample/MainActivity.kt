package com.dhafi.sharedpreferencesexample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.dhafi.sharedpreferencesexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val filename = "$packageName-SharedPrefsExample"
        val pref = getSharedPreferences("SharedPrefsExample", Context.MODE_PRIVATE)
        binding.btnSave.setOnClickListener {
            val editor = pref.edit()
            editor.putString("firstName",

                binding.etFirstName.text.toString())
            editor.putString("lastName",
                binding.etLastName.text.toString())
            editor.apply()
            Toast.makeText(this, "Saved Data!", Toast.LENGTH_LONG).show()
        }
        binding.btnLoad.setOnClickListener {
            val firstName = pref.getString("firstName", "")
            val lastName = pref.getString("lastName", "")
            val output = "$firstName $lastName"
            binding.etFirstName.setText(firstName)
            binding.etLastName.setText(lastName)
            binding.tvOutput.text = output
        }
        binding.btnSecondActivity.setOnClickListener{
            val intent = Intent(this@MainActivity,
                SecondActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onResume() {
        super.onResume()
        binding.etFirstName.setText("")
        binding.etLastName.setText("")
        binding.tvOutput.text = ""
    }
    companion object {
        const val SHARED_PREFS_FILENAME = "SharedPrefsExample"
    }
}