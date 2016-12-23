package com.example.manasa_pt1119.startwit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by manasa-pt1119 on 23/12/16.
 */

public class FourthScreen extends AppCompatActivity implements View.OnTouchListener {

    ImageView imageView4;
    int val[];
    int x,y;
    BoundedRect boundedRect4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_page);
        imageView4=(ImageView)findViewById(R.id.image_page4);
        imageView4.setOnTouchListener(this);
        val=new int[2];
        Picasso.with(this).load(R.drawable.page4).fit().into(imageView4);
        imageView4.getLocationOnScreen(val);
        boundedRect4=new BoundedRect(this);
        boundedRect4.setRectangleCoords(886,57,1070,57,886,161,1070,161);


    }
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){

            int touchX=(int)motionEvent.getX();
            int touchY=(int)motionEvent.getY();
            x=touchX-val[0];
            y=touchY-val[1];
           // boundedRect4.showAllClickable();
            if(boundedRect4.checkConstraints(x,y)==true)
            {
               // boundedRect4.showAllClickable();
                Intent intent=new Intent(FourthScreen.this,FifthScreen.class);
                startActivity(intent);
            }

            Log.d("Main", x +" "+ y);
        }

        return true;
    }

}
