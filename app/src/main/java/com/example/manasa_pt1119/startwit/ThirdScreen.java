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

public class ThirdScreen extends AppCompatActivity implements View.OnTouchListener {
    ImageView imageView3;
    int val[];
    RelativeLayout relativeLayout3;
    int x,y;
    BoundedRect boundedRect3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_page);
        imageView3=(ImageView)findViewById(R.id.image_page3);
        imageView3.setOnTouchListener(this);
        val=new int[2];
        Picasso.with(this).load(R.drawable.page3).fit().into(imageView3);
        imageView3.getLocationOnScreen(val);
        boundedRect3=new BoundedRect(this);
        boundedRect3.setRectangleCoords(257,233,854,233,257,433,854,433);
        relativeLayout3=(RelativeLayout)findViewById(R.id.rel3);
        relativeLayout3.setOnTouchListener(this);


    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(motionEvent.getAction()==MotionEvent.ACTION_UP)
        {
            relativeLayout3.setVisibility(View.INVISIBLE);
        }


        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){

            int touchX=(int)motionEvent.getX();
            int touchY=(int)motionEvent.getY();
            x=touchX-val[0];
            y=touchY-val[1];
          boundedRect3.showAllClickable(relativeLayout3);
            if(boundedRect3.checkConstraints(x,y)==true)
            {

                Intent intent=new Intent(ThirdScreen.this,FourthScreen.class);
                startActivity(intent);
            }

            Log.d("Main", x +" "+ y);
        }

        return true;
    }
}
