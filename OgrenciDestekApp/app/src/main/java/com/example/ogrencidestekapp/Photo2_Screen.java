package com.example.ogrencidestekapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.ogrencidestekapp.Adapter.ToDoAdapter;
import com.example.ogrencidestekapp.Model.Sorular;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

public class Photo2_Screen extends AppCompatActivity {
    EditText inputSearch;
    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;
    FirebaseRecyclerOptions<Sorular> options;
    FirebaseRecyclerAdapter<Sorular, MyViewHolderPhoto>adapter;
    DatabaseReference dataRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo2_screen);

        dataRef = FirebaseDatabase.getInstance("https://ogrencidestekapp-default-rtdb.europe-west1.firebasedatabase.app").getReference().child("Sorular");
        floatingActionButton=findViewById(R.id.floatingbtn);
        inputSearch=findViewById(R.id.inputSearchPhoto);
        recyclerView=findViewById(R.id.photoRecyler);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Photo_Screen.class));
            }
        });

        LoadData("");

        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString()!=null)
                {
                    LoadData(s.toString());
                }
                else
                {
                    LoadData("");
                }
            }
        });


    }

    private void LoadData(String data) {
        Query query = dataRef.orderByChild("SorununKonusu").startAt(data).endAt(data+"\uf8ff");

        options = new FirebaseRecyclerOptions.Builder<Sorular>().setQuery(query,Sorular.class).build();
        adapter = new FirebaseRecyclerAdapter<Sorular, MyViewHolderPhoto>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolderPhoto holder,final int position, @NonNull Sorular model) {
                holder.textView.setText(model.getSorununKonusu());
                Picasso.get().load(model.getImageUrl()).into(holder.imageView);
                holder.v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Photo2_Screen.this, PhotoViewActivity.class);
                        intent.putExtra("SoruKey",getRef(position).getKey());
                        startActivity(intent);
                    }
                });

            }

            @NonNull
            @Override
            public MyViewHolderPhoto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_photoview,parent,false);

                return new MyViewHolderPhoto(v);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
}