package util;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.*;

public class practice {
    public static void main(String[] args) {

        //find latest version number
        List<String> a = Lists.newArrayList(
                "Release-1.3", "Release-12.05.235", "Release-3.1", "Release-1.4", "Release-1.4.4", "Release-12.0.1", "Release-12.2.1", "Release-12.2.1"
                , "Release-12.05.235.1"

//               "Release-22.05","Release-12.2"
        );
        List<String> ab = Lists.newArrayList();
        for (int j = 0; j < a.size(); j++) {
            String version = a.get(j).split("Release-")[1];
            ab.add(version);
        }

//        System.out.println(getheadandsort(ab, 0));


        System.out.println(compareVersion("Release-12.2.15", "Release-12.2"));;
    }

    public static String getheadandsort(List<String> ab, int coun)  {
        List<Integer> notsortedversion = Lists.newArrayList();
        List<Integer> sortedversion = Lists.newArrayList();
        for (int k = 0; k < ab.size(); k++) {
            try{
                String buildnum = ab.get(k).split("\\.")[coun];
                notsortedversion.add(Integer.parseInt(buildnum));
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("because dont have num at this digit , set as 0 ");
                notsortedversion.add(0);
            }
        }

        sortedversion.addAll(notsortedversion);
//        notsortedversion.sort(Comparator.naturalOrder()); using inside utility to sort

        sortedversion = bubblesort(sortedversion);

//        loopint1.add(new BigDecimal("3.0"));

        List<Integer> index = Lists.newArrayList();
        for (int i = 0; i < sortedversion.size(); i++) {
            if (notsortedversion.get(i).equals(sortedversion.get(sortedversion.size()-1)) ) {
                index.add(i);
            }
        }


        if (index.size() == 1) {
            return ab.get(index.get(0));
        }

        coun++;
        List<String> bc = Lists.newArrayList();
        index.forEach(v -> {
            bc.add(ab.get(v));
        });

        return getheadandsort(bc, coun);


    }

    public static List<Integer> bubblesort(List<Integer> ab) {
        Integer[] a = ab.toArray(new Integer[0]);
        for (int i = 0; i < a.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j]>a[j+1]) {
                    Integer temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }

        }

//       this way of return cannot add/delete element from the list
        return Arrays.asList(a);

//        below way can add/delete
//        ab.clear();
//        Collections.addAll(ab,a);
//        return ab;
    }

    public static String compareVersion(String version1, String version2) {
        String[] v1 = version1.split("-")[1].split("\\.");
        String[] v2 = version2.split("-")[1].split("\\.");
        for (int i = 0; i < v1.length || i < v2.length; i++) {
            int x = 0, y = 0;
            if (i < v1.length) {
                x = Integer.parseInt(v1[i]);
            }
            if (i < v2.length) {
                y = Integer.parseInt(v2[i]);
            }
            if (x > y) {
                return version1;
            }
            if (x < y) {
                return version2;
            }
        }
        return "0";
    }


}
