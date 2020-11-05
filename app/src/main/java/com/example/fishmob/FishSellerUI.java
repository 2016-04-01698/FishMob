package com.example.fishmob;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FishSellerUI extends AppCompatActivity {
    Button btnProceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_seller_u_i);

        btnProceed = findViewById(R.id.btn_proceeded);
        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Set up an alert dialog
                AlertDialog.Builder alert = new AlertDialog.Builder(FishSellerUI.this);
                alert.setTitle("WELCOME TO THE FISHMOB!!!");
                alert.setMessage("Do you have an Account?");
                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(FishSellerUI.this,RegistrationActivity.class));
                    }
                });
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(FishSellerUI.this,LogInActivity.class));
                    }
                });
                alert.create().show();
            }
        });
    }
}