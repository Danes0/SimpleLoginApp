package com.example.assignmentone

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.assignmentone.databinding.ActivityLoginPageBinding

class Login_Page : AppCompatActivity() {

    private lateinit var binding_3 : ActivityLoginPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding_3 = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding_3.root)

        //Get credentials saved
        val reach_storage : SharedPreferences = getSharedPreferences("my_storage", MODE_PRIVATE)
        val saved_username : String? = reach_storage.getString("username", null)
        val saved_password : String? = reach_storage.getString("password", null)

        //Button Login
        binding_3.buttonLog1.setOnClickListener {
            val entered_username = binding_3.editTextLog1.text.toString()
            val entered_password = binding_3.TextPasswordLog1.text.toString()

            //Check if fields are filled
            if (entered_username.isEmpty() || entered_password.isEmpty()) {
                Toast.makeText(this, "All fields must be filled", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Check saved credentials
            if (saved_username == null || saved_password == null) {
                Toast.makeText(this, "No account found. Please sign up first.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //Compare credentials
            if (entered_username == saved_username && entered_password == saved_password) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/$entered_username"))
                startActivity(intent)
                finish()
            } else {
                // Display an error message
                Toast.makeText(this, "Username or password is incorrect. Try again!", Toast.LENGTH_SHORT).show()
            }
        }
        //Button Back
        binding_3.backButtonLog2.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}