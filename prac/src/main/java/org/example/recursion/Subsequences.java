package org.example.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsequences {

    public static void main(String[] args) {


        /**
         * subsequences(positions maintained, not contigous) -> subaaray(only contigous)
         */
        //Print all Subsequences

        List<Integer> arr = List.of(3,1,2,4,5);
        List<List<Integer>> answer = new ArrayList<>();

        Integer n = arr.size();

        List<Integer> ans = new ArrayList<>();

//        printSubsequences(0, ans, arr,n);


        Integer sum = 9;
        Integer currSum = 0;

        //Print all subsequences with target sum
        printSubsequencesWithSum(0, ans, arr, currSum, sum, n,answer);
        System.out.println(answer);
        //Print one subsequence with target sum
//        Boolean yoyo = printOneSubsequenceWithSum(0, ans, arr, currSum, sum, n);

        //Print count of subsequences with target sum
        //Print one subsequence with target sum
//        Integer yoyoA = countSubsequenceWithSum(0, arr, currSum, sum, n);
//        System.out.println("Count of subSequences : " + yoyoA);


    }

    private static Integer countSubsequenceWithSum(int i, List<Integer> arr, Integer currSum, Integer sum, Integer n) {

        //if non negative numbers
        if(currSum>sum){
            return 0;
        }

        if(i == n){
            if(currSum == sum) {
                return 1;
            } else {
                return 0;
            }
        }

        //if index element is picked
        currSum = currSum + arr.get(i);
        int l = countSubsequenceWithSum(i+1,arr,currSum,sum,n);


        //if element not picked
        currSum = currSum - arr.get(i);
        int r = countSubsequenceWithSum(i+1,arr,currSum,sum,n);

        return l + r;

    }

    private static Boolean printOneSubsequenceWithSum(int i, List<Integer> ans, List<Integer> arr, Integer currSum, Integer sum, Integer n) {

        if(i == n){
            if(currSum == sum) {
                for (Integer x : ans){
                    System.out.print(x+",");
                }

                System.out.println();
                return true;
            } else {
                return false;
            }

        }


        //if index element is picked
        ans.add(arr.get(i));
        currSum = currSum + arr.get(i);
        if(printOneSubsequenceWithSum(i+1,ans,arr,currSum,sum,n)){
            return true;
        }
        ans.removeLast();


        //if element not picked
        currSum = currSum - arr.get(i);
        if(printOneSubsequenceWithSum(i+1,ans,arr,currSum,sum,n)){
            return true;
        }

        return false;
    }

    private static void printSubsequencesWithSum(int i, List<Integer> ds, List<Integer> arr, Integer currSum, Integer sum, Integer n, List<List<Integer>> answer) {

        if(i == n){
            if(currSum <= sum) {
                answer.add(new ArrayList<>(ds));
            }
            return;
        }

        //if index element is picked
        ds.add(arr.get(i));
        currSum = currSum + arr.get(i);
        printSubsequencesWithSum(i+1,ds,arr,currSum,sum,n, answer);
        ds.removeLast();


        //if element not picked
        currSum = currSum - arr.get(i);
        printSubsequencesWithSum(i+1,ds,arr,currSum,sum,n, answer);

    }

    private static void printSubsequences(int i, List<Integer> ans, List<Integer> arr, Integer n) {

        //base cases

        if(i == n){
            for(Integer x : ans){
                System.out.print(x);
            }

            //all not picked
            if(ans.size()==0){
                System.out.println("{}");
            }


            System.out.println();

            return;
        }



        //if index element is picked
        ans.add(arr.get(i));
        printSubsequences(i+1,ans,arr,n);
        ans.removeLast();


        //if element not picked
        printSubsequences(i+1,ans,arr,n);


    }
}
