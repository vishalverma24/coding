package org.example.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickSort {


    static void printArray(List<Integer> arr)
    {
        int n = arr.size();
        for (int i = 0; i < n; ++i)
            System.out.print(arr.get(i) + " ");
        System.out.println();
    }


    public static void main(String[] args)
    {
        ArrayList<Integer> arr = new ArrayList<>(List.of(12, 11, 13, 5, 6, 7));

        System.out.println("Given array is");
        printArray(arr);

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, arr.size() - 1);

        System.out.println("\nSorted array is");
        printArray(arr);
    }

    private void sort(ArrayList<Integer> arr, int low, int high) {

        if(low < high){
            int partitionIndex = qs(arr,low,high);
            sort(arr,low,partitionIndex-1);
            sort(arr,partitionIndex+1,high);
        }


    }

    private int qs(ArrayList<Integer> arr, int low, int high) {

        int pivot = arr.get(0);
        int i=low;
        int j=high;

        while(i<j){
            while(i<=high-1 && arr.get(i)<=pivot){
                i++;
            }
            while(j>=low+1 && arr.get(j)>=pivot){
                j--;
            }

            if(i<j) Collections.swap(arr,i,j);
        }

        Collections.swap(arr,low,j);
        return j;
    }
}
