package com.example.manasa_pt1119.startwit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by manasa-pt1119 on 23/12/16.
 */

public class SixthScreen extends AppCompatActivity implements View.OnTouchListener {

    ImageView imageView6;
    int val[];
    int x,y;
    BoundedRect boundedRect6;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sixth_page);
        imageView6=(ImageView)findViewById(R.id.image_page6);
        imageView6.setOnTouchListener(this);
        val=new int[2];
        Picasso.with(this).load(R.drawable.page6).fit().into(imageView6);
        imageView6.getLocationOnScreen(val);
        boundedRect6=new BoundedRect(this);


    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
