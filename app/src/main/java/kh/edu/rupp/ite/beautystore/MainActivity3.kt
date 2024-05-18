package kh.edu.rupp.ite.beautystore

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {
    private lateinit var back: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        back = findViewById(R.id.back)
        back.setOnClickListener {
            Intent(this, MainActivity2::class.java).also { a->
                startActivity(a)
            }
        }
    }
}