package com.example.manasa_pt1119.startwit;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;



import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{
    ImageView imageView;
    BoundedRect boundedRect;

    RelativeLayout relativeLayout1;

    int x,y;

    int val[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.image_main);
        imageView.setOnTouchListener(this);
        val=new int[2];
        Picasso.with(this).load(R.drawable.page1).fit().into(imageView);
        imageView.getLocationOnScreen(val);
        boundedRect=new BoundedRect(this);
        boundedRect.setRectangleCoords(870,1426,1078,1426,870,1578,1078,1578);
        relativeLayout1=(RelativeLayout)findViewById(R.id.rel1);
        relativeLayout1.setOnTouchListener(this);




    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        if(motionEvent.getAction()==MotionEvent.ACTION_UP)
        {
            relativeLayout1.setVisibility(View.INVISIBLE);
        }
        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){

            int touchX=(int)motionEvent.getX();
            int touchY=(int)motionEvent.getY();
            x=touchX-val[0];
            y=touchY-val[1];
          boundedRect.showAllClickable(relativeLayout1);

            if(boundedRect.checkConstraints(x,y)==true)
            {

                Intent intent=new Intent(MainActivity.this,SecondScreen.class);
                startActivity(intent);
            }

            Log.d("Main", x +" "+ y);
        }
    return true;
    }


}


