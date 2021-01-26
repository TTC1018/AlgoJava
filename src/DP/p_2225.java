package DP;

import java.util.Scanner;

//합분해
public class p_2225 {
    public static void main(String[] args) {
        int num[] = new int[2];
        long dp[][] = new long[201][201];
        long mod = 1000000000;

        Scanner sc = new Scanner(System.in);
        String temp;
        String temp2[];

        temp = sc.nextLine();
        temp2 = temp.split(" ");

        for(int i=0; i<temp2.length; i++) num[i] = Integer.parseInt(temp2[i]);
        //n[0] = N, n[1] = K
        int n = num[0], k = num[1];

        for(int i=0; i<=n; i++){
            dp[1][i] = 1;
        }

        //K=2 N=2 인 경우를 고려해보자
        //0+2, 1+1, 2+0의 경우가 있다. 이것은 다시 말해,
        //(K=1일 때, N=0) + (K=1일 때, N=2)
        //(K=1일 때, N=1) + (K=1일 때, N=1)
        //(K=1일 때, N=2) + (K=1일 때, N=0)
        //으로 나타낼 수 있다. 이것을 통한 점화식은
        //dp[k][n] = dp[k-1][0]+dp[k-1][1]+...+dp[1][k-1]+dp[0][k-1]
        for(int i=2; i<=k; i++){
            for(int j=0; j<=n; j++){
                for(int l=0; l<=j; l++){
                    dp[i][j] += dp[i-1][j-l];
                    dp[i][j] %= mod;
                }
            }
        }

        System.out.println(dp[k][n]);
    }
}
