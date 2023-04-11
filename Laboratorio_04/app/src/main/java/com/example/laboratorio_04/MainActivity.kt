package com.example.laboratorio_04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.ActionBar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    //key variables
    private val keyName = "NAME";
    private val keyEmail = "EMAIL";
    private val keyPhone = "PHONE";

    //ui
    private lateinit var editTextName: TextInputEditText
    private lateinit var editTextEmail: TextInputEditText
    private lateinit var editTextPhone:TextInputEditText
    private lateinit var btnSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide();

        bind()
        listeners()
    }

    private fun bind(){
        editTextName = findViewById(R.id.edit_text_name);
        editTextEmail = findViewById(R.id.edit_text_email);
        editTextPhone = findViewById(R.id.edit_text_phone);
        btnSend = findViewById(R.id.btn_send);
    }

    //TODO: change keypad to be numbers only
    private fun listeners(){
        btnSend.setOnClickListener(){
            val intent = Intent(this, ResultsActivity::class.java);
            intent.putExtra(keyName, editTextName.text.toString());
            intent.putExtra(keyEmail, editTextEmail.text.toString());
            intent.putExtra(keyPhone, editTextPhone.text.toString());

            startActivity(intent);
        }
    }
}