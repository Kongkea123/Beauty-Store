package kh.edu.rupp.ite.beautystore

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.beautystore.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_register)
    }

    fun onLoginClick(View: View?) {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    fun onRegisterClick(View: View?) {
        startActivity(Intent(this, LoginActivity::class.java))
    }
}

