package com.codrax.digitalqanoon

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.codrax.digitalqanoon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitRecoverBtn.setOnClickListener {
            finish()
        }

        binding.rate.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://play.google.com/store/apps/details?id=xyz.appmaker.robcpj")
            )
            startActivity(intent)
        }

        binding.policy.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://docs.google.com/document/d/1IDvrg5kWnbPLCnKxD4a15dZA1pvw0exR050JbnODrgY/edit?usp=sharing")
            )
            startActivity(intent)
        }

        binding.support.setOnClickListener {
            val supportEmail = "infetechs@gmail.com" // Replace with your support email address

            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:") // Specify that this is a mailto URI
                putExtra(Intent.EXTRA_EMAIL, arrayOf(supportEmail)) // Set the recipient email address
                putExtra(Intent.EXTRA_SUBJECT, "Support Request") // Set the email subject
                // You can also include additional data, such as CC, BCC, or email body, if needed
                putExtra(Intent.EXTRA_TEXT, "Enter Your Query here ... ")
            }

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                // Handle the case where no email client is available to handle the intent
                Toast.makeText(this, "No email client found", Toast.LENGTH_SHORT).show()
            }
        }
    }
}