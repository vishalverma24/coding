package org.example.binarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KokoBananas {

    public static void main(String args[])
    {
        ArrayList<Integer> piles = new ArrayList<>(List.of(30,11,23,4,20));

        int h = 6;

        //Binary search
        int minK = koko(piles,h);
        System.out.println(minK);

    }

    private static int koko(ArrayList<Integer> piles, int h) {

        int low = 1;
        int high = Collections.max(piles);

        while(low<=high){

            int mid = (high+low)/2;

            int totalH = func(piles,mid);

            if(totalH<=h){
                high = mid -1;
            } else{
                low = mid + 1;
            }

        }

        return low;
    }


    private static int func(ArrayList<Integer> piles, int ind) {

        int totalHours = 0;
        for(int i = 0;i<piles.size();i++){
            totalHours += (int) Math.ceil((double)piles.get(i)/ind);
        }

        return totalHours;
    }
}
