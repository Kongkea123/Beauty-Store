package kh.edu.rupp.ite.beautystore

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.beautystore.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_login)
    }

    fun onLoginClick(View: View?) {
        startActivity(Intent(this, MainActivity2::class.java))
    }

    fun onRegisterClick(View: View?) {
        startActivity(Intent(this, RegisterActivity::class.java))
    }
}

