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

public class FifthScreen extends AppCompatActivity implements View.OnTouchListener {


    ImageView imageView5;
    int val[];
    int x,y;
    BoundedRect boundedRect5;
    RelativeLayout relativeLayout5;

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
        relativeLayout5=(RelativeLayout)findViewById(R.id.rel5);
        relativeLayout5.setOnTouchListener(this);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(motionEvent.getAction()==MotionEvent.ACTION_UP)
        {
            relativeLayout5.setVisibility(View.INVISIBLE);
        }

        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){

            int touchX=(int)motionEvent.getX();
            int touchY=(int)motionEvent.getY();
            x=touchX-val[0];
            y=touchY-val[1];
            boundedRect5.showAllClickable(relativeLayout5);
            if(boundedRect5.checkConstraints(x,y)==true)
            {

                Intent intent=new Intent(FifthScreen.this,SixthScreen.class);
                startActivity(intent);
            }

            Log.d("Main", x +" "+ y);
        }

        return true;
    }
}
