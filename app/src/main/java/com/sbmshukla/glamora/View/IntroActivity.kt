package com.sbmshukla.glamora.View

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sbmshukla.glamora.R
import com.sbmshukla.glamora.databinding.ActivityIntroBinding

class IntroActivity : BaseActivity() {
    private lateinit var binding: ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@IntroActivity, R.layout.activity_intro)

        binding.startButton.setOnClickListener {
            startActivity(Intent(this@IntroActivity, MainActivity::class.java))
        }
    }
}