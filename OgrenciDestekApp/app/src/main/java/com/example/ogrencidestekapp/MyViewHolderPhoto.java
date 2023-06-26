package com.example.ogrencidestekapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolderPhoto extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView textView;
    View v;
    public MyViewHolderPhoto(@NonNull View itemView) {
        super(itemView);

        imageView=itemView.findViewById(R.id.image_single_view);
        textView=itemView.findViewById(R.id.text_photo_single);
        v=itemView;
    }
}
