package DP;

import java.io.*;

//가장 큰 정사각형 만들기
public class p_1915_solution {

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
                if(arr[i+1][j+1] == 1) dp[i+1][j+1] = 1;
                else dp[i+1][j+1] = 0;
            }
        }

        int answer = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(arr[i-1][j]==1 && arr[i-1][j-1]==1 && arr[i][j-1]==1){
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-1]) + 1;
                }
                answer = Math.max(dp[i][j], answer);
            }
        }

        bw.write(Integer.toString((int)Math.pow(answer, 2)));
        bw.flush();
    }
}
