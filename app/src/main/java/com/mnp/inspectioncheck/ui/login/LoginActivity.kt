package com.mnp.inspectioncheck.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.mnp.inspectioncheck.MainActivity
import com.mnp.inspectioncheck.databinding.ActivityLoginBinding
import com.mnp.inspectioncheck.ui.daftar.DaftarActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        binding.masuk.setOnClickListener {
            val email = binding.inputUsername.text.toString().trim()
            val password = binding.inputPassword.text.toString().trim()
            when {
                TextUtils.isEmpty(email) -> {
                    binding.inputUsername.error = "email tidak boleh kosong"
                    return@setOnClickListener
                }
                TextUtils.isEmpty(password) -> {
                    binding.inputPassword.error = "password tidak boleh kosong"
                    return@setOnClickListener
                }
                binding.inputPassword.length()<5 -> {
                    binding.inputPassword.error = "password minimal 5 karakter"
                }
                else -> {
                    binding.progressBar2.visibility = View.VISIBLE
                    auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
                        if(it.isSuccessful){
                            Log.d("TAG", "onCreate: $email,$password")
                            success()
                            Toast.makeText(this@LoginActivity, "Sukses Masuk", Toast.LENGTH_SHORT).show()
                        }
                        else {
                            binding.progressBar2.visibility = View.GONE
                            Toast.makeText(this@LoginActivity, "Gagal Masuk", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }

        }
        binding.daftar.setOnClickListener {
            startActivity(Intent(this,DaftarActivity::class.java))
            finish()
        }
    }

    private fun success() {
        binding.progressBar2.visibility = View.GONE
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}