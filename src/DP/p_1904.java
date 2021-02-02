package DP;

import java.util.Scanner;

// 01타일
public class p_1904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp[] = new int[1000001];

        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 15746;
        }

        System.out.println(dp[n]);
    }
}
