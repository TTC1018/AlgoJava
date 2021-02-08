package DP;

import java.io.*;

//점프
public class p_1890 {

    static int n;
    static long dp[][];
    static int arr[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        dp = new long[n][n];
        arr = new int[n][n];
        String temp[];
        for(int i=0; i<n; i++){
            temp = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(temp[j]);
                dp[i][j] = -1;
            }
        }
        br.close();

        bw.write(Long.toString(solve(n-1, n-1)));
        bw.flush();

        //dp배열 출력
//        for(int i=0; i<n; i++){
//            for(int j=0; j<n; j++){
//                System.out.printf("%3d", dp[i][j]);
//            }
//            System.out.println();
//        }
    }

    private static long solve(int x, int y){
        if(dp[x][y] != -1) return dp[x][y];
        else{
            if(x == 0 && y == 0){
                dp[x][y] = 1;
                return 1;
            }
            else{
                dp[x][y] = 0;

                for(int i=1; i<=x; i++)
                    if(arr[x-i][y] == i) dp[x][y] += solve(x-i, y);

                for(int i=1; i<=y; i++)
                    if(arr[x][y-i] == i) dp[x][y] += solve(x, y-i);

                return dp[x][y];
            }
        }
    }
}
