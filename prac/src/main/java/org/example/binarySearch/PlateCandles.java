package org.example.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlateCandles {

    public static void main(String[] args){

        String s = "***|**|*****|**||**|*";
        int[][] q = {{1,17},{4,5},{14,17},{5,11},{15,16}};
        int[] output = platesBetweenCandles(s,q);
//        Arrays.stream(output).forEach(System.out::println);

        //Binary Search, upperBound, lowerBound
        int[] out = platesBetweenCandlesOpt(s,q);
//        Arrays.stream(out).forEach(System.out::println);

        int[] arr = {1,2,4,5,7,9,10,11};
        int k = 10;
        int n = arr.length;

        List<Integer> list = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            list.add(arr[i]);
        }
        System.out.println("LowerBound : " + lowerBound(list,n,k));
        System.out.println("UpperBound : " + upperBound(list,n,k));

    }

    private static int[] platesBetweenCandlesOpt(String s, int[][] q) {
        int n = s.length(),cnt = 0;
        int[] prec = new int[n];

        List<Integer> cp = new ArrayList<>(n);
        int[] ans = new int[q.length];
        for(int i = 0;i<n;i++) {
            if(s.charAt(i)=='*') cnt++;
            if(s.charAt(i)=='|') cp.add(i);
            prec[i] = cnt;
        }
        for(int i = 0;i<q.length;i++) {
            int l = lowerBound(cp,cp.size(),q[i][0]);
            int r = upperBound(cp,cp.size(),q[i][1]);
            if(l<0 || l>=cp.size() || r<=0 || r>cp.size() || prec[cp.get(r-1)]-prec[cp.get(l)]<0) ans[i]=0;
            else ans[i]=prec[cp.get(r-1)]-prec[cp.get(l)];
        }

        return ans;
    }

    private static int upperBound(List<Integer> arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr.get(mid) > x) {
                ans = mid;
                //look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }

    private static int lowerBound(List<Integer> arr, int n, int x) {

        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr.get(mid) >= x) {
                ans = mid;
                //look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }

    private static int[] platesBetweenCandles(String s, int[][] queries) {
        int[] answer = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int l = queries[i][0];
            int r = queries[i][1];

            String str = s.substring(l, r + 1);

            l=0;
            r=str.length()-1;

            char lc = str.charAt(0);
            char rc = str.charAt(r);

            int tempL = l;
            int tempR = r;

            while(rc!='|' && r>tempL){
                r--;
                rc = str.charAt(r);
            }
            while(lc!='|' && l<tempR){
                l++;
                lc = str.charAt(l);
            }

            if(l>=r){
                answer[i] = 0;
                continue;
            }
            String strNew = str.substring(l,r+1);

            int out = 0;
            out = findCandles(strNew,0,strNew.length());

            answer[i]=out;

        }
        return answer;
    }

    private static int findCandles(String strNew, int i, int n) {

        if(i==n) return 0;

        int pick = 0;
        int nonPick = 0;
        if(strNew.charAt(i)=='*'){
            pick = 1 + findCandles(strNew,i+1,n);
        } else {
            nonPick = findCandles(strNew,i+1,n);
        }

        return pick + nonPick;
    }
}
