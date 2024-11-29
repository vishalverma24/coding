package org.example.dp2d;

import java.util.Arrays;
import java.util.List;

public class NinjaTraining {

    public static void main(String args[]) {

        List<List<Integer>> points = List.of(List.of(1, 2, 3), List.of(11, 22, 13), List.of(1, 26, 3), List.of(10, 20, 30));

        int[][] pointsT = {{1, 2, 3},
                {11, 22, 13},
                {1, 26, 3},
                {10,20,30}};


        int days = points.size();
        int tasks = points.get(0).size();


        int dp[][] = new int[days][tasks+1];

        for(int i=0;i<days;i++){
            for(int j=0;j<tasks;j++){
                dp[i][j]=-1;
            }
        }
        
        int prev [] = new int[tasks+1];
        

        //recursion memo
        int maxPointsRec = funcRec(days - 1, tasks, points);
        System.out.println(maxPointsRec);

        //DP memo
        int maxPointsDpMemo = funcDpMemo(days - 1, tasks, points, dp);
        System.out.println(maxPointsRec);

        //DP tab
        int maxPointsDpTab = funcDpTab(days, pointsT, dp);
        System.out.println(maxPointsDpTab);

        //DP tab Space Opt
        //Possible whenever only -1 or -2 required
        int maxPointsDpTabOpt = funcDpTabOpt(days, pointsT, prev);
        System.out.println(maxPointsDpTabOpt);
    }

    private static int funcDpTabOpt(int n, int[][] pointsT, int[] prev) {

        prev[0] = Math.max(pointsT[0][1], pointsT[0][2]);
        prev[1] = Math.max(pointsT[0][0], pointsT[0][2]);
        prev[2] = Math.max(pointsT[0][0], pointsT[0][1]);
        prev[3] = Math.max(pointsT[0][0], Math.max(pointsT[0][1], pointsT[0][2]));

        for(int day = 1;day<n;day++){

            int [] temp = new int[prev.length];
            for(int i=0;i< prev.length;i++){
                temp[i]=0;
            }

            for(int last =0 ;last<4;last++){
                temp[last]=0;

                for(int task = 0; task<3;task++){
                    if(task!=last){
                        temp[last] = Math.max(temp[last], pointsT[day][task] + prev[task]);
                    }
                }
            }

            prev = temp;
        }

        return prev[3];
    }

    private static int funcDpTab(int n, int[][] pointsT, int[][] dp) {

        dp[0][0] = Math.max(pointsT[0][1], pointsT[0][2]);
        dp[0][1] = Math.max(pointsT[0][0], pointsT[0][2]);
        dp[0][2] = Math.max(pointsT[0][0], pointsT[0][1]);
        dp[0][3] = Math.max(pointsT[0][0], Math.max(pointsT[0][1], pointsT[0][2]));

        for(int day = 1;day<n;day++){
            for(int last =0 ;last<4;last++){
                dp[day][last]=0;

                for(int task = 0; task<3;task++){
                    if(task!=last){
                        int pointsTillDay = pointsT[day][task] + dp[day-1][task];
                        dp[day][last] = Math.max(dp[day][last], pointsTillDay);
                    }
                }
            }
        }

        return dp[n-1][3];
    }

    private static int funcDpMemo(int day, int last, List<List<Integer>> points, int[][] dp) {


        if (day == 0) {
            int maxi = 0;
            for (int task = 0; task < 3; task++) {
                if (last != task) {
                    maxi = Math.max(maxi, points.get(0).get(task));
                }
            }
            return maxi;
        }

        if(dp[day][last]!=-1) return dp[day][last];

        int maxiM = 0;

        for (int task = 0; task < 3; task++) {
            if (last != task) {
                int pointsTillDay = points.get(day).get(task) + funcRec(day - 1, task, points);
                maxiM = Math.max(maxiM, pointsTillDay);
            }
        }

        return dp[day][last] = maxiM;

    }

    private static int funcRec(int day, int last, List<List<Integer>> points) {

        if (day == 0) {
            int maxi = 0;
            for (int task = 0; task < 3; task++) {
                if (last != task) {
                    maxi = Math.max(maxi, points.get(0).get(task));
                }
            }
            return maxi;
        }

        int maxiM = 0;

        for (int task = 0; task < 3; task++) {
            if (last != task) {
                int pointsTillDay = points.get(day).get(task) + funcRec(day - 1, task, points);
                maxiM = Math.max(maxiM, pointsTillDay);
            }
        }

        return maxiM;

    }


}
