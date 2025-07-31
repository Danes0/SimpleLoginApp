package com.example.assignmentone

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.assignmentone.databinding.ActivitySignUp2PageBinding

class Sign_Up2_Page : AppCompatActivity() {

    private lateinit var binding_4 : ActivitySignUp2PageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding_4 = ActivitySignUp2PageBinding.inflate(layoutInflater)

        setContentView(binding_4.root)

        // Handle user input and sign-up process
        binding_4.btnSignup2.setOnClickListener {
            val email = binding_4.etUsername2.text.toString()
            val password = binding_4.etPassword2.text.toString()
            val confirmPassword = binding_4.etConfirmPassword2.text.toString()

            // Validations for email, password ando confirm password with rules
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Enter a valid email", Toast.LENGTH_SHORT).show()

            } else if (password.length !in 8..15) {
                Toast.makeText(this, "Password must be between 8-15 characters", Toast.LENGTH_SHORT).show()

            } else if (!password.any { it.isUpperCase() }) {
                Toast.makeText(this, "Password must have at least one uppercase letter", Toast.LENGTH_SHORT).show()

            } else if (!password.any { it in ".!@#$%^&*" }) {
                Toast.makeText(this, "Password must have at least one special character (.!@#$%^&*)", Toast.LENGTH_SHORT).show()

            } else if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()

            } else {
                //Save password and username SharedPreferences
                val save_credentials: SharedPreferences = getSharedPreferences("user_credentials", MODE_PRIVATE)
                val editor = save_credentials.edit()
                editor.putString("USERNAME", email)
                editor.putString("PASSWORD", password)
                editor.apply()


                // Register Succesfull
                Toast.makeText(this, "User Registered Successfully!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, Login2_Page::class.java))
                finish()
            }

        }
        binding_4.btnBack2.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}