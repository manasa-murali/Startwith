package com.example.manasa_pt1119.startwit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

/**
 * Created by manasa-pt1119 on 23/12/16.
 */

public class SecondScreen extends AppCompatActivity implements View.OnTouchListener{

    RelativeLayout relativeLayout2;
    ImageView imageView2;
    int val[];
    int x,y;
    BoundedRect boundedRect2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page);
        imageView2=(ImageView)findViewById(R.id.image_page2);
        imageView2.setOnTouchListener(this);
        val=new int[2];
        Picasso.with(this).load(R.drawable.page2).fit().into(imageView2);
        imageView2.getLocationOnScreen(val);
        boundedRect2=new BoundedRect(this);
        boundedRect2.setRectangleCoords(0,970,121,970,0,1082,121,1082);
        relativeLayout2=new RelativeLayout(getApplicationContext());
        relativeLayout2.setId(R.id.rel1);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {


        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){

            int touchX=(int)motionEvent.getX();
            int touchY=(int)motionEvent.getY();
            x=touchX-val[0];
            y=touchY-val[1];
           // boundedRect2.showAllClickable();
            if(boundedRect2.checkConstraints(x,y)==true)
            {
               // boundedRect2.showAllClickable();
                Intent intent=new Intent(SecondScreen.this,ThirdScreen.class);
                startActivity(intent);
            }

            Log.d("Main", x +" "+ y);
        }

        return true;
    }


}
