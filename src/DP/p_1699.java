package DP;

import java.util.Scanner;

//제곱수의 합
public class p_1699 {
    public static void main(String[] args) {
        int n;
        int dp[] = new int[100001];

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

    //본인 풀이 (틀린 건 아님)
//        int npow, nsqrt = (int)Math.sqrt(n);
//        for(int i=2; i<=nsqrt; i++){
//            npow = (int)Math.pow(i, 2);
//            dp[npow] = 1;
//            for(int j=1; j<=npow; j++){
//                dp[npow+j] = dp[npow] + dp[j];
//            }
//        }

        dp[0] = 0;
        for(int i=1; i<=n; i++){
            dp[i] = i;
            for(int j=1; j*j<=i; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        System.out.println(dp[n]);
    }
}
