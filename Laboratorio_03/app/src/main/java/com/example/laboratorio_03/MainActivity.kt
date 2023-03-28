package com.example.laboratorio_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //UI variables
    private lateinit var totalAmountTextView: TextView;
    private lateinit var fiveCentsView : LinearLayout;
    private lateinit var tenCentsView : LinearLayout;
    private lateinit var quaterCentsView: LinearLayout;
    private lateinit var dollarView : LinearLayout;

    //Logical variables
    private var totalAmount = 0.00;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide();

        bind()
        addListeners()
    }

    private fun bind(){
        totalAmountTextView = findViewById(R.id.amount_text_view);
        fiveCentsView = findViewById(R.id.five_cents_view);
        tenCentsView = findViewById(R.id.ten_cents_view);
        quaterCentsView = findViewById(R.id.quater_view);
        dollarView = findViewById(R.id.dollar_view);

    }

    private fun addListeners(){
        fiveCentsView.setOnClickListener{
            totalAmount += 0.05;
            setTextValue();
        }
        tenCentsView.setOnClickListener{
            totalAmount += 0.10;
            setTextValue();
        }
        quaterCentsView.setOnClickListener{
            totalAmount += 0.25;
            setTextValue();
        }
        dollarView.setOnClickListener{
            totalAmount += 1.00;
            setTextValue();
        }
    }

    private fun setTextValue(){
        totalAmountTextView.text = getString(R.string.total_amount, String.format("%.2f", totalAmount));
    }
}