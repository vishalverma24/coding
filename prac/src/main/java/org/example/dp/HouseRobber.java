package org.example.dp;

import java.util.ArrayList;
import java.util.List;

public class HouseRobber {

    public static void main(String args[])
    {
        ArrayList<Integer> arr = new ArrayList<>(List.of(2,1,4,9));
        int n = arr.size();

        ArrayList<Integer> temp1  = new ArrayList<>(n-1);
        ArrayList<Integer> temp2  = new ArrayList<>(n-1);

        for(int i=0;i<n-1;i++){
            temp1.add(arr.get(i));
        }
        for(int i=1;i<n;i++){
            temp2.add(arr.get(i));
        }
        int ansStart = findSumOpt(temp1,n);
        int ansEnd = findSumOpt(temp2,n);

        System.out.println(Math.max(ansStart,ansEnd));
    }

    private static int findSumOpt(ArrayList<Integer> arr, int n) {

        int prev = arr.get(0);
        int prev2=0;

        for(int i=0;i<n-1;i++){

            int pick = arr.get(i);
            if(i>1){
                pick += prev2;
            }

            int noPick = prev;

            int curr = Math.max(pick,noPick);

            prev2 = prev;
            prev= curr;
        }

        return prev;
    }
}
