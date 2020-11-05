package com.example.fishmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dashboardActivity extends AppCompatActivity {
 Button btnCustomer, btnFishKeeper, btnFishSeller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
         btnCustomer = findViewById(R.id.btn_customer);
         btnFishKeeper=findViewById(R.id.btn_fish_keeper);
         btnFishSeller=findViewById(R.id.btn_fish_seller);


         btnCustomer.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(dashboardActivity.this, CustomerUI.class));
             }
         });

          btnFishKeeper.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                    ///HERE REQUIRED TO INSERT THE CODE THAT SHIFT TO ANOTHER PAGE FOR FISH KEEPER.
              }
          });

          btnFishSeller.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  startActivity(new Intent(dashboardActivity.this,FishSellerUI.class));
              }
          });

    }
}