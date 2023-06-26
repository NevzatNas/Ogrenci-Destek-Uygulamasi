package com.example.ogrencidestekapp;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class Login_Screen extends AppCompatActivity {
    EditText mail;
    EditText password;
    ImageView signIn;
    Button signInGoogle;
    TextView signUp;
    TextView forgotPassword;

    ProgressBar progressBarSignIn;

    FirebaseAuth auth = FirebaseAuth.getInstance();

    GoogleSignInClient googleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        mail = (EditText) findViewById(R.id.editTextMail);
        password = findViewById(R.id.editTextTextPassword);
        signIn = findViewById(R.id.signInBtn);
        signInGoogle = findViewById(R.id.signInGoogle);
        signUp = findViewById(R.id.register);
        forgotPassword = findViewById(R.id.fpassword);
        progressBarSignIn = findViewById(R.id.progressBarSignIN);
        progressBarSignIn.setVisibility(View.INVISIBLE);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userMail = mail.getText().toString();
                String userPassword = password.getText().toString();
                signInWithFirebase(userMail,userPassword);

            }
        });

        signInGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInGoogle();

            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent signUp = new Intent(getApplicationContext(),Signup_Screen.class);
                startActivity(signUp);

            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgot = new Intent(getApplicationContext(),Forgot_password.class);
                startActivity(forgot);

            }
        });

    }
    public  void signInWithFirebase(String userMail,String userPassword){
        progressBarSignIn.setVisibility(View.VISIBLE);
        //signIn.setClickable(false);
        auth.signInWithEmailAndPassword(userMail,userPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(i);
                            finish();
                            progressBarSignIn.setVisibility(View.INVISIBLE);
                            Toast.makeText(Login_Screen.this, "Giriş başarılı", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(Login_Screen.this, "Giriş yapılamadı", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    public void signInGoogle(){
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail().build();

        googleSignInClient = GoogleSignIn.getClient(this,gso);
        signIn();
    }
    //
    private static final int REQUEST_CODE_GOOGLE_SIGN_IN = 1;

    public void signIn(){
        Intent signInIntent = googleSignInClient.getSignInIntent();
        activityResultLauncher.launch(signInIntent);
        // startActivityForResult(signInIntent, REQUEST_CODE_GOOGLE_SIGN_IN);

    }
    //
    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if(result.getResultCode() == Activity.RESULT_OK){
            Intent data = result.getData();
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            firebaseSignInWithGoogle(task);
        }
    });

    //
   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_GOOGLE_SIGN_IN){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            firebaseSignInWithGoogle(task);
        }
    }*/

    private  void firebaseSignInWithGoogle(Task<GoogleSignInAccount> task ){

        try {
            GoogleSignInAccount account = task.getResult(ApiException.class);
            Toast.makeText(this, "Giriş başarılı", Toast.LENGTH_SHORT).show();
            Intent lgn = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(lgn);
            finish();
            firebaseGoogleAccount(account);
        } catch (ApiException e) {
            throw new RuntimeException(e);


        }

    }

    private void firebaseGoogleAccount(GoogleSignInAccount account){
        AuthCredential authCredential = GoogleAuthProvider.getCredential(account.getIdToken(),null);
        auth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
              if(task.isSuccessful()){
                  FirebaseUser user = auth.getCurrentUser();

              }  else{
                  Toast.makeText(Login_Screen.this, "Hata", Toast.LENGTH_SHORT).show();

              }
            }
        });

    }
}