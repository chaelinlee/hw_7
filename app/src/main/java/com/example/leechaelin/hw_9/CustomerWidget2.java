package com.example.leechaelin.hw_9;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by leechaelin on 2017. 5. 1..
 */

public class CustomerWidget2 extends LinearLayout implements View.OnClickListener{
    AutoCompleteTextView at;
    int imgno = 0;
    EditText et;
    ImageView img;
    Button b1,b2;
    Boolean button = true;

    public CustomerWidget2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.below,this);

        at = (AutoCompleteTextView)findViewById(R.id.atv);
        et = (EditText)findViewById(R.id.editprice);
        img = (ImageView)findViewById(R.id.imageview);
        b1= (Button)findViewById(R.id.next_b);
        b2 = (Button)findViewById(R.id.add_b);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }


    interface OnAddListener{
        void onAdd(String name,String price,int imgno);
    }
    public  OnAddListener onAddListener;

    public void setOnAddListner(OnAddListener onAddListener){
        this.onAddListener = onAddListener;
    }
    interface ChangedOnAddListener{
        void Changed(String name,String price,int imagno);
    }
    public ChangedOnAddListener changeOnAddListener;

    public void setChangedOnAddListener(ChangedOnAddListener changeOnAddListener){
        this.changeOnAddListener = changeOnAddListener;
    }

    public void ButtonChange(){
        if(button==true){
            b2.setText("M");
            button = false;
        }else{
            b2.setText("ADD");
            button = true;
        }
    }

    @Override
    public void onClick(View v) {
        if(v==b2){
            if(button==true)
                onAddListener.onAdd(at.getText().toString(),et.getText().toString(),imgno);
            else
                changeOnAddListener.Changed(at.getText().toString(),et.getText().toString(),imgno);

        }else{
            if(imgno==fruit.imagelist.length-1)imgno = -1;
            img.setImageResource(fruit.imagelist[++imgno]);

        }

    }
}
