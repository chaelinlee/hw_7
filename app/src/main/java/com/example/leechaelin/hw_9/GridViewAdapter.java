package com.example.leechaelin.hw_9;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by leechaelin on 2017. 5. 1..
 */

public class GridViewAdapter extends BaseAdapter{
    Context context;
    ArrayList<fruit> fruit;
    TextView tv;
    int checked=0;

    public GridViewAdapter(Context context,ArrayList<fruit> fruit){
        this.context = context;
        this.fruit = fruit;
    }
    @Override
    public int getCount() {
        return fruit.size();
    }

    @Override
    public Object getItem(int position) {
        return fruit.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView=new CustomWidget1(context);
        ((CustomWidget1)convertView).setData(fruit.get(position));

        tv = (TextView)convertView.findViewById(R.id.price_1);
        if(checked==0){
            tv.setVisibility(View.INVISIBLE);
        }else{
            tv.setVisibility(View.VISIBLE);
        }
        return convertView;
    }

    public void Checkingprice(){
        if(checked==0)
            checked = 1;
        else
            checked = 0;
    }
}
