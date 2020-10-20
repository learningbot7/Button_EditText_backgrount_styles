package com.example.transferdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Second_Activity extends AppCompatActivity {
    ImageView imageView;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);
        imageView=(ImageView)findViewById(R.id.image2);
        name=(TextView)findViewById(R.id.textview_name);

        //for image
        Bundle bundle=getIntent().getExtras();
        if (bundle!=null){
            int imageId=bundle.getInt("resId");
            imageView.setImageResource(imageId);
            //for text
            Intent intent=getIntent();
            String string=intent.getStringExtra("text");
            name.setText(string);
        }

    }
}