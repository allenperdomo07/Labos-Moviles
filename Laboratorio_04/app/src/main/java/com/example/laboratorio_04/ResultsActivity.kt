package com.example.laboratorio_04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ResultsActivity : AppCompatActivity() {

    //key variables
    private val keyName = "NAME";
    private val keyEmail = "EMAIL";
    private val keyPhone = "PHONE";


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        supportActionBar!!.hide()

        //ui
        var editTextName = findViewById <TextView>(R.id.text_view_name);
        var editTextEmail = findViewById <TextView>(R.id.text_view_email);
        var editTextPhone = findViewById <TextView>(R.id.text_view_phone);
        var btnShare = findViewById<Button>(R.id.btn_share)

        //logical
        val name = intent.getStringExtra(keyName).toString() ?: ""
        val email = intent.getStringExtra(keyEmail).toString() ?: ""
        val phone = intent.getStringExtra(keyPhone).toString() ?: ""

        editTextName.text = name;
        editTextEmail.text = email;
        editTextPhone.text = phone;

        listeners(btnShare, name, email, phone);

    }


    private fun listeners(btnShare:Button, name: String, email: String, phone : String){
        btnShare.setOnClickListener(){
            val publicIntent : Intent = Intent().apply {
                action = Intent.ACTION_SEND;
                putExtra(Intent.EXTRA_TEXT, getString(R.string.share_data, name, email, phone));

                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(publicIntent, "This is my personal information");
            startActivity(shareIntent);
        }
    }
}