package com.example.bookshystory

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CreditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit)

        val username = intent.getStringExtra("username")
        val textViewInfo = findViewById<TextView>(R.id.textViewInfo)
        textViewInfo.text = "Usuario, estás usando la versión 1 de $username"

        val btnContact = findViewById<Button>(R.id.btnContact)
        btnContact.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO)
            emailIntent.data = Uri.parse("mailto:")
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Consulta de la app BooksHystory")
            emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("tucorreo@example.com"))
            if (emailIntent.resolveActivity(packageManager) != null) {
                startActivity(emailIntent)
            }
        }
    }
}
