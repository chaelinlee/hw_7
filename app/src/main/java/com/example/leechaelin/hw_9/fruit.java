package com.example.leechaelin.hw_9;

/**
 * Created by leechaelin on 2017. 4. 27..
 */

public class fruit {
    final static String fruitlist[]={"아보카도","바나나","체리","크랜베리","포도"};
    final static int[] imagelist={R.drawable.abocado,R.drawable.banana,R.drawable.cherry,R.drawable.cranberry,
            R.drawable.grape};

    String name,price;
    int imgno;

    fruit(String name,String price,int imgno){
        this.name = name;
        this.price = price;
        this.imgno = imgno;

    }

}
