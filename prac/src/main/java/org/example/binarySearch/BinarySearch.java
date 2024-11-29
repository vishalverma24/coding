package org.example.binarySearch;

public class BinarySearch {

    public static void main(String[] args){

        int[] nums = {1,3,5,7,8,9,10};
        int target = 8;

        int output = searchBinary(nums,target);
        System.out.println(output);

        int out = searchBinaryRec(nums,target,0,nums.length-1);
        System.out.println(out);



    }

    private static int searchBinary(int[] nums, int target) {
        int n = nums.length; //size of the array.
        int low = 0, high = n - 1;

        while (low <= high){
            int mid = (low + high)/2;

            if(nums[mid]==target){
                return mid;
            } else if(target>nums[mid]){
                low = mid +1;
            } else{
                high = mid -1;
            }

        }

        return -1;
    }

    private static int searchBinaryRec(int[] nums, int target, int l, int r) {

        if(l>r) return -1;

        int m = (r+l)/2;

        if(nums[m]==target) return m;

        if(nums[m]<target){
            return searchBinaryRec(nums,target,m+1,r);
        } else{
            return searchBinaryRec(nums,target,l,m-1);
        }
    }
}
