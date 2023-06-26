package com.example.ogrencidestekapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class PhotoViewActivity extends AppCompatActivity {

    private ImageView imageView;
    TextView textView;
    Button delete;
    DatabaseReference ref,dataRef;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);

        imageView=findViewById(R.id.image_single_view_activity);
        textView=findViewById(R.id.text_photo_single_activity);
        delete=findViewById(R.id.singleDeleteBtn);
        ref= FirebaseDatabase.getInstance("https://ogrencidestekapp-default-rtdb.europe-west1.firebasedatabase.app").getReference().child("Sorular");



        String SoruKey=getIntent().getStringExtra("SoruKey");
        dataRef=FirebaseDatabase.getInstance("https://ogrencidestekapp-default-rtdb.europe-west1.firebasedatabase.app").getReference().child("Sorular").child(SoruKey);
        storageReference= FirebaseStorage.getInstance().getReference().child("SoruImage").child(SoruKey+".jpg");
        ref.child(SoruKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    String SorununKonusu=snapshot.child("SorununKonusu").getValue().toString();
                    String ImageUrl=snapshot.child("ImageUrl").getValue().toString();

                    Picasso.get().load(ImageUrl).into(imageView);
                    textView.setText(SorununKonusu);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataRef.removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        storageReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                startActivity(new Intent(getApplicationContext(),Photo2_Screen.class));
                            }
                        });
                    }
                });
            }
        });

    }
}