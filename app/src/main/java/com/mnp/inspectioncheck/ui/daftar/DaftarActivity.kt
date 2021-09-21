package com.mnp.inspectioncheck.ui.daftar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.mnp.inspectioncheck.databinding.ActivityDaftarBinding
import com.mnp.inspectioncheck.ui.login.LoginActivity

class DaftarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDaftarBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        binding.masuk.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
        binding.apply {
            daftar.setOnClickListener {
                val email = inputEmail.text.toString().trim()
                val password = inputPassword.text.toString().trim()
                when {
                    TextUtils.isEmpty(email) -> {
                        inputEmail.error = "email tidak boleh kosong"
                        return@setOnClickListener
                    }
                    TextUtils.isEmpty(password) -> {
                        inputPassword.error = "password tidak boleh kosong"
                        return@setOnClickListener
                    }
                    inputPassword.length()<5 -> {
                        inputPassword.error = "password minimal 5 karakter"
                    }
                    else -> {
                        progressBar.visibility = View.VISIBLE
                        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
                            if(it.isSuccessful){
                                success()
                                Toast.makeText(this@DaftarActivity, "Sukses Daftar", Toast.LENGTH_SHORT).show()
                            }
                            else {
                                Toast.makeText(this@DaftarActivity, "Gagal Daftar", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
            }
        }
    }

    private fun success() {
        binding.progressBar.visibility = View.GONE
        startActivity(Intent(this,LoginActivity::class.java))
        finish()
    }
}