package org.example.recursion;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(ArrayList<Integer> arr, int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        List<Integer> L = new ArrayList<>();
        List<Integer> R = new ArrayList<>();

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i){
            L.add(arr.get(l+i));
        }

        for (int j = 0; j < n2; ++j){
            R.add(arr.get(m + 1 + j));
        }


        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L.get(i) <= R.get(j)) {
                arr.set(k,L.get(i));
                i++;
            }
            else {
                arr.set(k,R.get(j));
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr.set(k,L.get(i));
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr.set(k,R.get(j));
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(ArrayList<Integer> arr, int l, int r)
    {
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    // A utility function to print array of size n
    static void printArray(List<Integer> arr)
    {
        int n = arr.size();
        for (int i = 0; i < n; ++i)
            System.out.print(arr.get(i) + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String args[])
    {
        ArrayList<Integer> arr = new ArrayList<>(List.of(12, 11, 13, 5, 6, 7));

        System.out.println("Given array is");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.size() - 1);

        System.out.println("\nSorted array is");
        printArray(arr);
    }
}
