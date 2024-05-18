package kh.edu.rupp.ite.beautystore

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.beautystore.databinding.SplashScreenBinding

class SplashScreen : AppCompatActivity() {
    private lateinit var binding :SplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        splashScreen()
        text()
    }

    private fun splashScreen(){
        Handler().postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        },1500)

    }
    private fun text(){
        binding.tvSplash.text = "Beauty Store"
    }
}