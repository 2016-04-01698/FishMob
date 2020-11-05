package com.example.fishmob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CustomerUI extends AppCompatActivity {
  Button btnStarted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_u_i);
        btnStarted=findViewById(R.id.btnGetStarted);
        btnStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(CustomerUI.this, RecyclerViewer.class));
            }
        });

    }

}