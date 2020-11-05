package com.example.fishmob;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {
    Button btnSignIn, btnRegister;
    EditText  textFullNames, textPhoneNumber, textEmailAcc, textConfirmPwd, textPwd;

    //diolog declration if there is some one also is regestring.
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        textFullNames=findViewById(R.id.edtxt_fullnames);
        textPhoneNumber=findViewById(R.id.edtxt_phoneNumber);
        textEmailAcc=findViewById(R.id.edtxt_emailAcount);
        textPwd=findViewById(R.id.edtxt_Pwd);
        textConfirmPwd=findViewById(R.id.edtxt_Conpwd);

        btnSignIn=findViewById(R.id.btn_Sign_In);
        btnRegister=findViewById(R.id.btn_register);

        dialog=new ProgressDialog(this);
        dialog.setTitle("Regestiring");
        dialog.setMessage("Please Wait....");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this,LogInActivity.class));
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start receving data entered in the filled.
                String fullNames,phoneNumber, emailAccount, Password;
                fullNames=textFullNames.getText().toString();
                phoneNumber=textPhoneNumber.getText().toString();
                emailAccount=textEmailAcc.getText().toString();
                Password=textPwd.getText().toString();

                if (fullNames.isEmpty() && phoneNumber.isEmpty()){
                    textFullNames.setError("please enter your names");
                    textPhoneNumber.setError("enter your phone number");
                }
                else  if(phoneNumber.isEmpty()){
                    textPhoneNumber.setError("enter your phone number");
                }
                else if(emailAccount.isEmpty()){
                    textEmailAcc.setError("enter your email");
                }
                else if (Password.isEmpty()){
                    textPwd.setError("enter your password");
                }
                else {
                    // Database connect to firebase
                    long time= System.currentTimeMillis();
                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Fishseller/ " + time);
                    UserRegistration user =new UserRegistration(fullNames,phoneNumber, emailAccount, Password, String.valueOf(time));
                    dialog.show();
                    ref.setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                                dialog.dismiss();

                            if (task.isSuccessful()){
                                 message("Sucess!!!","Registering is succesful");
                            }
                            else {
                                message("Fail!!", "registering is failed, try again");
                            }
                        }
                    });
                }


            }
        });

    }

    // a method of toast a message if user successful registering.
    public   void  message(String title, String message){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(RegistrationActivity.this,FishSellerPage.class));
            }
        });
builder.create().show();
    }
    // a method to clear all filled in the textfilled.
    public  void  clear(){
        textFullNames.setText("");
        textEmailAcc.setText("");
        textPwd.setText("");
        textPhoneNumber.setText("");
        textConfirmPwd.setText("");
    }

}