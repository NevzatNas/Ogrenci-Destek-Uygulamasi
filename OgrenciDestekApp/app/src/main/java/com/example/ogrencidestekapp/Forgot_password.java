package com.example.ogrencidestekapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forgot_password extends AppCompatActivity {
    ImageView forgotBtn;
    TextView back;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    EditText mail;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        forgotBtn = (ImageView) findViewById(R.id.forgotImage);
        back = findViewById(R.id.backSign);
        mail = findViewById(R.id.forgotText);
        progressBar = findViewById(R.id.progressBarforgot);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Login_Screen.class);
                startActivity(i);
                finish();

            }
        });

        forgotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userMail = mail.getText().toString();
                resetPassword(userMail);


            }
        });
    }

    public  void resetPassword(String userMail){
        progressBar.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(userMail)
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Forgot_password.this, "Sıfırlama linkini e-mailine gönderdik!", Toast.LENGTH_SHORT).show();
                            forgotBtn.setClickable(false);
                            progressBar.setVisibility(View.INVISIBLE);
                            finish();
                        }else{
                            Toast.makeText(Forgot_password.this, "Bir hata ile karşılaştık daha sonra deneyiniz ...", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }

}