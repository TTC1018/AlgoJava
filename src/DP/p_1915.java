package DP;

import java.io.*;

public class p_1915 {

    static int n, m;
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String temp[] = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        arr = new int[n+1][m+1];
        dp = new int[n+1][m+1];

        for(int i=0; i<n; i++){
            temp = br.readLine().split("");
            for(int j=0; j<m; j++){
                arr[i+1][j+1] = Integer.parseInt(temp[j]);
                dp[i+1][j+1] = -1;
            }
        }


    }

    private static int solve(int x, int y){
        if(dp[x][y] != -1) return dp[x][y];
        else{
            if(x==1 || y==1){
                if(arr[x][y] == 1){
                    dp[x][y] = 1;
                    return dp[x][y];
                }
                else{
                    int max = 0;
                    if(x == 1){
                        for(int i=0; i<y; i++){
                            max = Math.max(max, dp[1][y]);
                        }
                    }
                    else if(y == 1){
                        for(int i=0; i<x; i++){
                            max = Math.max(max, dp[x][1]);
                        }
                    }
                    return max;
                }
            }
            else{

            }
        }
    }
}
