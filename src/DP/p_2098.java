package DP;

import java.io.*;

//외판원 순회
public class p_2098 {
    static int n;
    static int W[][];
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        W = new int[n+1][n+1];
        dp = new int[n+1][n+1];
        String temp[];
        for(int i=0; i<n; i++){
            temp = br.readLine().split(" ");
            for(int j=0; j<4; j++){
                W[i][j] = Integer.parseInt(temp[j]);
                dp[i][j] = W[i][j]; //초기화
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                dp[i][j] = Math.min(W[i][j], W[i][] + W[][j]);
                dp[i][j] = Math.min(dp[i][j], W[i][] + W[][j]);
            }
        }


    }
}
