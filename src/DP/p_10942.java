package DP;

import java.io.*;
import java.util.Arrays;

//팰린드롬
public class p_10942 {

    static int n, m, s ,e;
    static int arr[];
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new int[n+1][n+1];

        String temp[] = br.readLine().split(" ");
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(temp[i-1]);
        }

        //길이 1인 케이스
        for(int i=1; i<=n; i++) dp[i][i] = 1;
        //길이 2인 케이스
        for(int i=1; i<=n-1; i++){
            if(arr[i]==arr[i+1]) dp[i][i+1] = 1;
            else dp[i][i+1] = 0;
        }
        //길이 3이상인 케이스
        for(int i=n-2; i>=1; i--){
            for(int j=n; j>=i+2; j--){
                if(arr[i] == arr[j] && dp[i+1][j-1] == 1) dp[i][j] = 1;
                else dp[i][j] = 0;
            }
        }

        m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            temp = br.readLine().split(" ");
            s = Integer.parseInt(temp[0]);
            e = Integer.parseInt(temp[1]);
            bw.write(dp[s][e] + "\n");
        }
        bw.flush();
    }
}
