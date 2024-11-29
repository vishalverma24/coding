package org.example.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubSetSum {

    public static void main(String args[])
    {
        List<Integer> arr = new ArrayList<>(List.of(5,2,1));
        List<Integer> answer = new ArrayList<>();


        Integer sum = 0;
        subSetSumList(0,arr,answer,sum);

        Collections.sort(answer);
        System.out.println(answer);
    }

    private static void subSetSumList(int i, List<Integer> arr, List<Integer> answer, Integer sum) {
        if(i==arr.size()){
            answer.add(sum);
            return;
        }

        subSetSumList(i+1,arr,answer,sum + arr.get(i));

        subSetSumList(i+1,arr,answer,sum);
    }

}
