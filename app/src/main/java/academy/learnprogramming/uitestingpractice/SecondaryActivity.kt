package academy.learnprogramming.uitestingpractice

import academy.learnprogramming.uitestingpractice.databinding.ActivitySecondaryBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SecondaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondaryBinding.inflate(layoutInflater)
        binding.buttonBack.setOnClickListener {
                onBackPressed()
            }
        setContentView(binding.root)
    }
}
