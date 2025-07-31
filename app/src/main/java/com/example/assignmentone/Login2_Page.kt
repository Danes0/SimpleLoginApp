package com.example.assignmentone

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.assignmentone.databinding.ActivityLogin2PageBinding

class Login2_Page : AppCompatActivity() {

    private lateinit var binding_5 : ActivityLogin2PageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding_5 = ActivityLogin2PageBinding.inflate(layoutInflater)

        setContentView(binding_5.root)

        // Get credentials saved from Sign Up 2
        val reach_storage: SharedPreferences = getSharedPreferences("user_credentials", MODE_PRIVATE)
        val saved_username: String? = reach_storage.getString("USERNAME", null)
        val saved_password: String? = reach_storage.getString("PASSWORD", null)

        //Button Login
        binding_5.buttonLog2.setOnClickListener {
            val entered_username = binding_5.editTextLog2.text.toString()
            val entered_password = binding_5.TextPasswordLog2.text.toString()

            //Check if fields are filled
            if (entered_username.isEmpty() || entered_password.isEmpty()) {
                Toast.makeText(this, "All fields must be filled", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validate email format
            if (!Patterns.EMAIL_ADDRESS.matcher(entered_username).matches()) {
                Toast.makeText(this, "Enter a valid email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Check if account exists in SharedPreferences
            if (saved_username == null || saved_password == null) {
                Toast.makeText(this, "No account found. Please sign up first.", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, Sign_Up2_Page::class.java))
                finish()
                return@setOnClickListener
            }

            //Compare credentials
            if (entered_username == saved_username && entered_password == saved_password) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/login"))
                startActivity(intent)
                finish()
            } else {
                // Display an error message
                Toast.makeText(this, "Username or password is incorrect. Try again!",
                    Toast.LENGTH_SHORT).show()
            }
        }

        //Back button
        binding_5.backButtonLog2.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}