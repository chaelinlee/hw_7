package com.example.leechaelin.hw_9;

/**
 * Created by leechaelin on 2017. 4. 27..
 */

public class fruit {
    final static String fruitlist[]={"아보카도","바나나","체리","크랜베리","포도","키위","오렌지","수박"};
    final static int[] imagelist={R.drawable.abocado,R.drawable.banana,R.drawable.cherry,R.drawable.cranberry,
            R.drawable.grape,R.drawable.kiwi,R.drawable.orange,R.drawable.watermelon};

    String name,price;
    int imageno;

    fruit(String name,String price,int imageno){
        this.name = name;
        this.price = price;
        this.imageno = imageno;

    }


}
