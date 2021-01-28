package DP;

import java.util.Scanner;

//1,2,3 더하기
public class p_9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t, max;
        t = sc.nextInt();
        int arr[] = new int[t+1];
        int dp[];

        max = 1;
        for(int i=1; i<=t; i++){
            arr[i] = sc.nextInt();
            max = max < arr[i] ? arr[i] : max;
        }
        dp = new int[max+1];

        //dp[n] = dp[n-1] + dp[n-2] + dp[n-3]
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4; i<=max; i++){
            dp[i] = 0;
            for(int j=i-1; j>=i-3; j--){
                dp[i] += dp[j];
            }
        }

        for(int i=1; i<arr.length; i++){
            System.out.println(dp[arr[i]]);
        }
    }
}
