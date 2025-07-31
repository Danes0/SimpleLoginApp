package com.example.assignmentone

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.example.assignmentone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding_1 : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding_1 = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding_1.root)

        //Sign Up pages
        binding_1.SignUp.setOnClickListener {
            //Create order to mover to the other page
            val move_to_Sign_up = Intent(this,Signup_Page::class.java)
            startActivity(move_to_Sign_up)
        }

        binding_1.SignUp2.setOnClickListener {
            val move_to_Sign_Up2 = Intent(this,Sign_Up2_Page::class.java)
            startActivity(move_to_Sign_Up2)
        }

        //Log in Pages
        binding_1.Login.setOnClickListener {
            val move_to_Login = Intent(this,Login_Page::class.java)
            startActivity(move_to_Login)
        }

        binding_1.Login2.setOnClickListener {
            val move_to_Login2 = Intent(this,Login2_Page::class.java)
            startActivity(move_to_Login2)
        }

        //Button Updates
        binding_1.Update.setOnClickListener {
            val Link ="https://github.blog/changelog/"
            val open_Link = Intent(Intent.ACTION_VIEW, Uri.parse(Link))
            startActivity(open_Link)
        }


    }
}