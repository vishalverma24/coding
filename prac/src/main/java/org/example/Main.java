package org.example;


import org.w3c.dom.Node;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello World");

        int[] nums = {1,7,11,15,2};
        int target = 9;
        int n = nums.length;

        List<Integer> res = new ArrayList<>();
        
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){

            int toFind = target - nums[i];

            if(map.containsKey(toFind)){
               res.add(map.get(toFind));
               res.add(i);
            } else{
                map.put(nums[i],i);
            }
        }

//        System.out.println(res);


        List<Integer> numArr = List.of(3,2,3);

        Map<Integer, Long> hashMap = numArr.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

//        System.out.println(numArr.stream().filter(e -> Collections.frequency(numArr,e) > 1).collect(Collectors.toSet()));

        int[] arr = {1, 2, 8, 10, 11, 12, 19};
        int k = 5;
        System.out.println(findFloor(arr,k));

    }

    static int findFloor(int[] arr, int k) {
        // write code here
        System.out.println("calculate");
        int i = 0;
        int j = arr.length-1;

        while(i<=j){
            int m = (i+j)/2;
            int mid = m;
            int count =0;
            while(k < arr[m]){
                count = 1;
                j = m - 1;
                m = (i+j)/2;
            }
            if(count==0){
                while(k > arr[mid]){
                    i = mid + 1;
                    mid = (i+j)/2;
                }
            }
            return count == 0 ? arr[j+1] : arr[i];
        }
        return -1;
    }
}