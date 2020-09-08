package com.apurbamondal.onlineschool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.common.data.BitmapTeleporter
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class Register_activity : AppCompatActivity() {
    private var register_email:EditText? = null
    private var register_password:EditText? = null
    private var register_btn:Button? = null
    private var firebaseAuth:FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_activity)
        register_email = findViewById(R.id.user_register_email)
        register_password = findViewById(R.id.user_register_password)
        register_btn = findViewById(R.id.register)
        firebaseAuth = FirebaseAuth.getInstance()

        register_btn?.setOnClickListener {
            RegusterUser()
        }
    }
    private fun RegusterUser() {
        val email = register_email?.text.toString().trim()
        val password = register_password?.text.toString().trim()
        if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) {
            Toast.makeText(applicationContext, "The Field Cannot be empty.", Toast.LENGTH_SHORT).show()
        } else {
            firebaseAuth?.createUserWithEmailAndPassword(email, password)?.addOnCompleteListener(object : OnCompleteListener<AuthResult> {
                override fun onComplete(task: Task<AuthResult>) {
                    if (task.isSuccessful) {
                        Toast.makeText(applicationContext, "Registration successful", Toast.LENGTH_SHORT).show()
                        val user:FirebaseUser = firebaseAuth!!.currentUser!!
                        user.sendEmailVerification().addOnCompleteListener(object : OnCompleteListener<Void> {
                            override fun onComplete(task: Task<Void>) {
                                if (task.isSuccessful) {
                                    Toast.makeText(applicationContext, "Please verify your account", Toast.LENGTH_SHORT).show()
                                    startActivity(Intent(this@Register_activity, Login_activity::class.java))
                                } else {
                                    val error = task.exception?.message
                                    Toast.makeText(applicationContext, "Error " + error, Toast.LENGTH_SHORT).show()
                                }
                            }
                        })
                    } else {
                        val error = task.exception?.message
                        Toast.makeText(applicationContext, "Error " + error, Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }
}