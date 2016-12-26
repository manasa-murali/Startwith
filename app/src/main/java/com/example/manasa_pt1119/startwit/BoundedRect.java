package com.example.manasa_pt1119.startwit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.view.View;
import android.widget.RelativeLayout;

import java.math.*;

/**
 * Created by manasa-pt1119 on 22/12/16.
 */

public class BoundedRect extends View {

    ShapeDrawable shapeDrawable;
Paint paint;
    RelativeLayout relativeLayout;

    int ulx,uly,urx,ury,dlx,dly,drx,dry;
   public  BoundedRect(Context context)
    {
        super(context);
    }


    public void showAllClickable(RelativeLayout relativeLayout)
    {
        this.relativeLayout=relativeLayout;
        relativeLayout.setBackgroundColor(Color.BLUE);
        relativeLayout.setVisibility(View.VISIBLE);


    }
    public void setRectangleCoords(int ulx,int uly,int urx,int ury,int dlx,int dly,int drx,int dry)
    {

        this.ulx=ulx;
        this.uly=uly;
        this.urx=urx;
        this.ury=ury;
        this.dlx=dlx;
        this.dly=dly;
        this.drx=drx;
        this.dry=dry;


    }
    public boolean checkConstraints(int touchx,int touchy)
    {
        if((touchx>=ulx && touchy>=uly)&& (touchx<=urx && touchy>=ury)&&(touchx>=dlx && touchy<=dly)&&(touchx<=drx &&touchy<=dry))
            return true;
        else return false;
    }
}
