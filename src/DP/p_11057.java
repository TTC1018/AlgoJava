package DP;

import java.util.Scanner;

//오르막 수
public class p_11057 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int dp[][] = new int[1001][10];

        for(int i=0; i<=9; i++){
            dp[1][i] = 1;
        }

        //dp[i][j] = 길이가 i고, j로 끝나는 수에서 가능한 오르막수의 개수
        //dp[i][j] = dp[i-1][j] + dp[i-1][j+1] + ... + dp[i-1][9]
        for(int i=2; i<=n; i++){
            for(int j=0; j<=9; j++){
                for(int k=j; k<=9; k++){
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

        int answer = 0;
        for(int i=0; i<=9; i++){
            answer += dp[n][i];
        }
        answer %= 10007;
        System.out.println(answer);
    }
}
