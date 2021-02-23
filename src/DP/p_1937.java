package DP;

import java.io.*;

public class p_1937 {

    static int n;
    static int arr[][];
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n+2][n+2];
        for(int i=0; i<=n+1; i++){
            for(int j=0; j<=n+1; j++){
                arr[i][j] = -1;
            }
        }
        dp = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                dp[i][j] = -1;
            }
        }

        for(int i=1; i<=n; i++){
            String temp[] = br.readLine().split(" ");
            for(int j=1; j<=n; j++){
                arr[i][j] = Integer.parseInt(temp[j-1]);
            }
        }

        for(int i=n; i>=1; i--){
            for(int j=n; j>=1; j--){
                solve(i, j);
            }
        }

        int answer = 1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                answer = Math.max(answer, dp[i][j]);
            }
        }
        bw.write(Integer.toString(answer));
        bw.flush();
    }

    private static int solve(int x, int y){
        if(x<1 || x>n || y<1 || y>n) return -1;
        if(dp[x][y] != -1) return dp[x][y];
        else{
            dp[x][y] = 1;
            int max = 0;

            if(x>=1 && arr[x][y] > arr[x-1][y]) max = Math.max(max, solve(x-1, y)); //좌
            if(x<=n && arr[x][y] > arr[x+1][y]) max = Math.max(max, solve(x+1, y)); //우
            if(y>=1 && arr[x][y] > arr[x][y-1]) max = Math.max(max, solve(x, y-1)); //상
            if(y<=n && arr[x][y] > arr[x][y+1]) max = Math.max(max, solve(x, y+1)); //하

            dp[x][y] = max + 1;

            return dp[x][y];
        }
    }
}
