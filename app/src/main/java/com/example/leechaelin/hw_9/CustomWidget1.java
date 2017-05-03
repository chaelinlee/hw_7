package com.example.leechaelin.hw_9;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by leechaelin on 2017. 5. 1..
 */

public class CustomWidget1 extends LinearLayout{
    TextView t1,t2;
    ImageView img;

    public CustomWidget1(Context context) {
        super(context);
        init(context);
    }

    void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.gridlayout,this);

        t1=(TextView)findViewById(R.id.name);
        t2=(TextView)findViewById(R.id.price_1);
        img=(ImageView)findViewById(R.id.fruit_img);
    }

    public void setData(fruit one){
        t1.setText(one.name);
        t2.setText(one.price+"원");
        img.setImageResource(one.imageno);
    }
}
