package com.demo.synsoft.parsedemo;

import java.util.ArrayList;

/**
 * Created by synsoft on 21/03/16.
 */
public class Main {

    public static void main(String [] args)
    {
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("Strnig 1");
        arrayList.add("Strnig 2");
        arrayList.add("Strnig 3");
        arrayList.add("Strnig 4");

//        arrayList.forEach(n -> {
//            return System.out.println(n);
//        });



    }


    interface Test
    {
        public  int sum(int a,int b);
    }
}
