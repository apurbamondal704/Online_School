package com.apurbamondal.onlineschool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class Login_activity : AppCompatActivity() {
    private var login_email:EditText? = null
    private var login_password:EditText?= null
    private var login_btn:Button? = null
    private var firebaseAuth:FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_activity)
        login_email = findViewById(R.id.user_login_email)
        login_password = findViewById(R.id.user_login_password)
        login_btn = findViewById(R.id.login)
        firebaseAuth = FirebaseAuth.getInstance()

        login_btn?.setOnClickListener {
            LoginUser()
        }
    }
    private fun LoginUser() {
        val email = login_email?.text.toString().trim()
        val password = login_password?.text.toString().trim()

        if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) {
            Toast.makeText(applicationContext, "The field can not be empty.", Toast.LENGTH_SHORT).show()
        } else {
            firebaseAuth?.signInWithEmailAndPassword(email, password)?.addOnCompleteListener(object : OnCompleteListener<AuthResult> {
                override fun onComplete(task: Task<AuthResult>) {
                    if (task.isSuccessful) {
                        Toast.makeText(applicationContext, "Login Successful", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@Login_activity, Dashboard_activity::class.java))
                    } else {
                        val error = task.exception?.message
                        Toast.makeText(applicationContext, "Error " + error, Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }
}