package com.mnp.inspectioncheck.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.google.firebase.auth.FirebaseAuth
import com.mnp.inspectioncheck.MainActivity
import com.mnp.inspectioncheck.databinding.ActivitySplashScreenBinding
import com.mnp.inspectioncheck.ui.login.LoginActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        actionBar?.hide()
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        CoroutineScope(Dispatchers.Main).launch {
            delay(3000)
            val currentUser = auth.currentUser
            if (currentUser != null) {
                updateUI()
            } else {
                startActivity(Intent(this@SplashScreen, LoginActivity::class.java))
                finish()
            }
        }
    }

    private fun updateUI() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}