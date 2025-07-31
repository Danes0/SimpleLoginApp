package com.example.assignmentone

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.assignmentone.databinding.ActivitySignupPageBinding

class Signup_Page : AppCompatActivity() {

    private lateinit var binding_2 : ActivitySignupPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding_2 = ActivitySignupPageBinding.inflate(layoutInflater)
        setContentView(binding_2.root)

        // Button Signup
        binding_2.btnSignup.setOnClickListener {
            val user = binding_2.etUsername.text.toString()
            val pass = binding_2.etPassword.text.toString()
            val confirmpass = binding_2.etConfirmPassword.text.toString()

            // Check if all fields are filled
            if (user.isEmpty() || pass.isEmpty() || confirmpass.isEmpty()) {
                Toast.makeText(this, "All fields must be filled", Toast.LENGTH_SHORT).show()

                // Check if passwords match
            } else if (pass != confirmpass) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()

            } else {
                //Save credentials in SharedPreferences
                val sharedPreferences : SharedPreferences = getSharedPreferences("my_storage", MODE_PRIVATE)
                val editor : SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("username", user)
                editor.putString("password", pass)
                editor.apply()

                Toast.makeText(this, "Account Created Successfully!", Toast.LENGTH_SHORT).show()

                //Return to Main Page after signup
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }

        //Back button
        binding_2.btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
