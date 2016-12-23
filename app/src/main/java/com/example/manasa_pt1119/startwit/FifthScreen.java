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

public class FifthScreen extends AppCompatActivity implements View.OnTouchListener {


    ImageView imageView5;
    int val[];
    int x,y;
    BoundedRect boundedRect5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fifth_page);
        imageView5=(ImageView)findViewById(R.id.image_page5);
        imageView5.setOnTouchListener(this);
        val=new int[2];
        Picasso.with(this).load(R.drawable.page5).fit().into(imageView5);
        imageView5.getLocationOnScreen(val);
        boundedRect5=new BoundedRect(this);
        boundedRect5.setRectangleCoords(934,978,1070,978,934,1078,1070,1078);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){

            int touchX=(int)motionEvent.getX();
            int touchY=(int)motionEvent.getY();
            x=touchX-val[0];
            y=touchY-val[1];
          //  boundedRect5.showAllClickable();
            if(boundedRect5.checkConstraints(x,y)==true)
            {
             //   boundedRect5.showAllClickable();
                Intent intent=new Intent(FifthScreen.this,SixthScreen.class);
                startActivity(intent);
            }

            Log.d("Main", x +" "+ y);
        }

        return true;
    }
}
