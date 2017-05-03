package com.example.leechaelin.hw_9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<fruit> fruit = new ArrayList<fruit>();
    ArrayAdapter<String> fruit_name;
    final static String fruitlist[]={"아보카도","바나나","체리","크랜베리","포도","키위","오렌지","수박"};
    final static int[] imagelist={R.drawable.abocado,R.drawable.banana,R.drawable.cherry,R.drawable.cranberry,
            R.drawable.grape,R.drawable.kiwi,R.drawable.orange,R.drawable.watermelon};
    GridViewAdapter adapter;
    GridView gridview;
    CustomerWidget2 cw;
    AutoCompleteTextView atv;
    int p=0;
    CheckBox c1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    public void init(){
        gridview = (GridView)findViewById(R.id.gridview);
        adapter = new GridViewAdapter(this,fruit);
        cw = (CustomerWidget2)findViewById(R.id.cw2);
        fruit.add(new fruit("아보카도","2000원",imagelist[0]));
        fruit.add(new fruit("바나나","3000원",imagelist[1]));
        fruit.add(new fruit("체리","5000원",imagelist[2]));

        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cw.ButtonChange();
                p = position;
                fruit f = (fruit)adapter.getItem(position);
                AutoCompleteTextView at = (AutoCompleteTextView)findViewById(R.id.atv);
                EditText e = (EditText)findViewById(R.id.editprice);
                ImageView img = (ImageView)findViewById(R.id.imageview);
                at.setText(f.name);
                e.setText(f.price);
                img.setImageResource(imagelist[f.imageno]);


            }
        });
        fruit_name = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,fruitlist);
        atv = (AutoCompleteTextView)findViewById(R.id.atv);
        atv.setAdapter(fruit_name);

        c1 = (CheckBox)findViewById(R.id.checkbox);
        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                adapter.Checkingprice();
                adapter.notifyDataSetChanged();
            }
        });


        cw.setOnAddListner(new CustomerWidget2.OnAddListener() {
            @Override
            public void onAdd(String name, String price, int imgno) {
                fruit.add(new fruit(name,price,imagelist[imgno]));
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(),"추가되었습니다 ",Toast.LENGTH_SHORT).show();
            }
        });

        cw.setChangedOnAddListener(new CustomerWidget2.ChangedOnAddListener(){

            @Override
            public void Changed(String name, String price, int imagno) {
                fruit.set(p,new fruit(name,price,imagelist[imagno]));
                cw.ButtonChange();
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(),"수정이 되었습니다. ",Toast.LENGTH_SHORT).show();
            }
        });




    }


}
