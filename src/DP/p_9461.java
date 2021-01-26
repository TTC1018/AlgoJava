package DP;

import java.util.Scanner;

//파도반 수열 (정삼각형 이어붙이기)
public class p_9461 {
    public static void main(String[] args) {
        int n, max;
        int input[];
        long dp[] = new long[101];

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        input = new int[n+1];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        max = 0;
        for(int i=1; i<=n; i++){
            input[i] = sc.nextInt();
            max = max < input[i] ? input[i] : max;
        }

        for(int i=6; i<=max; i++){
            dp[i] = dp[i-1] + dp[i-5];
        }

        for(int i=1; i<=n; i++){
            System.out.println(dp[input[i]]);
        }
    }
}
