package com.aca.collection;

import com.aca.collection.SuperCollection.SuperCollection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SuperCollection <Integer> array=new SuperCollection<>();
        Scanner sc=new Scanner(System.in);
        Integer j;

        for (int i=0;i<6;++i)
        {
            array.add(j=sc.nextInt());

        }
        array.toString();

    }
}
