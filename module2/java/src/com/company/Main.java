package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
//           SinhVien sinhVien = new SinhVien("A",12,"001");
////        System.out.println(sinhVien);
        ArrayList<String> car = new ArrayList<String>();
        car.add("hi");
        car.add("híhi");
        car.add("a");
        car.add("ab");
        Collections.sort(car);
        for (int i=0;i<car.size();i++){
            System.out.println(car.get(i));
       }
//        ArrayList<Integer> numbers = new ArrayList<Integer>();
//        numbers.add(10);
//        numbers.add(9);
//        numbers.add(13);
//        numbers.add(12);
//        numbers.add(56);
//        Collections.sort(numbers);
//        for (int i=0;i<numbers.size();i++){
//            System.out.println(numbers.get(i));
//        }


    }
}



