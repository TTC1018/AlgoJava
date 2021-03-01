package DP;

import java.io.*;
import java.util.Arrays;

//격자상의 경로
public class p_10164 {

    static int n, m, k; //행 , 열, 무조건 지나야 하는 칸
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String temp[] = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        k = Integer.parseInt(temp[2]);

        dp = new int[n+1][m+1];
        for(int i=1; i<=n; i++) Arrays.fill(dp[i], -1);

        if(k == 0) bw.write(Integer.toString(solve(k, dp)));
        else{
            int newK = n*m - k + 1;
            int prevAnswer = solve(k, dp);
            int nextAnswer = solve(newK, dp);
            bw.write(Integer.toString(prevAnswer * nextAnswer));
        }
        bw.flush();
    }


    private static int solve(int k, int dp[][]){
        int target = k!=0 ? k : n*m; //k = 0이면, 경유지역 없음
        int newN = (target-1)/m + 1;
        int newM = (target-1)%m + 1;

        if(dp[newN][newM] != -1) return dp[newN][newM];
        if(target == 1){
            dp[newN][newM] = 1;
            return dp[newN][newM];
        }

        dp[newN][newM] = 0;
        if(newN-1 >= 1) dp[newN][newM] += solve(target-m, dp);
        if(newM-1 >= 1) dp[newN][newM] += solve(target-1, dp);


        return dp[newN][newM];
    }
}
