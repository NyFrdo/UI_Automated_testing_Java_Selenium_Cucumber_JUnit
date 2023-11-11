package util;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.*;

public class practice {
    public static void main(String[] args)  {

        //find latest version number
        List<String> a = Lists.newArrayList(
                "Release-1.3", "Release-12.05.1", "Release-3.1", "Release-1.4.3", "Release-1.4.4", "Release-2.0.1", "Release-2.1.1", "Release-12.05.0788"

//               "Release-1.3","Release-3.3","Release-12.05","Release-12.2"


        );
        List<String> ab = Lists.newArrayList();
        for (int j = 0; j < a.size(); j++) {
            String version = a.get(j).split("Release-")[1];
            ab.add(version);
        }

        System.out.println(getheadandsort(ab, 0));


    }

    public static String getheadandsort(List<String> ab, int coun) {
        List<BigDecimal> loopint1 = Lists.newArrayList();
        List<BigDecimal> loopint2 = Lists.newArrayList();
        for (int k = 0; k < ab.size(); k++) {
            String buildnum = ab.get(k).split("\\.")[coun];
            if (buildnum.startsWith("0")) {
                loopint1.add(new BigDecimal("0." + buildnum));
            } else loopint1.add(new BigDecimal(buildnum));

        }
        loopint2.addAll(loopint1);
//        loopint1.sort(Comparator.naturalOrder()); using inside utility to sort
        loopint1 = bubblesort(loopint1);

//        loopint1.add(new BigDecimal("3.0"));

        List<Integer> index = Lists.newArrayList();
        for (int i = 0; i < loopint2.size(); i++) {
            if (loopint2.get(i).compareTo(loopint1.get(loopint1.size() - 1)) == 0) {
                index.add(i);
            }
        }


        coun++;

        if (index.size() == 1) {
            return ab.get(index.get(0));
        }

        List<String> bc = Lists.newArrayList();
        index.forEach(v -> {
            bc.add(ab.get(v));
        });

        return getheadandsort(bc, coun);


    }

    public static List<BigDecimal> bubblesort(List<BigDecimal> ab) {
        BigDecimal[] a = ab.toArray(new BigDecimal[0]);
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length - 1; j++) {
                if (a[i].compareTo(a[j]) == 1) {
                    BigDecimal temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }

        }

//       this way of return cannot add/delete element from the list
        return Arrays.asList(a);

//        below way can add/delete
//        ab.clear();
//        Collections.addAll(ab,a);
//        return ab;
    }
}
