package OfferSlution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution32 {
    public String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });
        StringBuilder result = new StringBuilder();
        for(int j: list){
            result.append(j);
        }
        return result.toString();
    }
}
