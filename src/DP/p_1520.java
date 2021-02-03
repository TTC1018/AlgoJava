package DP;

import java.util.Scanner;

public class p_1520 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String temp;
        String temp2[];

        temp = sc.nextLine();
        temp2 = temp.split(" ");
        int m = Integer.parseInt(temp2[0]) , n = Integer.parseInt(temp2[1]);
        int dp[][] = new int[m+2][n+2];
        int arr[][] = new int[m+2][n+2];

        for(int i=1; i<=m; i++){
            temp = sc.nextLine();
            temp2 = temp.split(" ");
            for(int j=1; j<=n; j++){
                arr[i][j] = Integer.parseInt(temp2[j-1]);
                dp[i][j] = 0;
            }
        }

        //padding
        for(int i=0; i<=n; i++){
            arr[0][i] = -1;
            arr[m+1][i] = -1;
            arr[i][0] = -1;
            arr[i][n+1] = -1;
            dp[0][i] = -1;
            dp[m+1][i] = -1;
            dp[i][0] = -1;
            dp[i][n+1] = -1;
        }
        dp[1][1] = 1;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(i == 1 && j == 1) continue;

                if(arr[i][j] < arr[i][j-1]){
                    if(dp[i][j-1] != -1) dp[i][j] += dp[i][j-1]; //좌
                }
                if(arr[i][j] < arr[i][j+1]){
                    if(dp[i][j+1] != -1) dp[i][j] += dp[i][j+1]; //우
                }
                if(arr[i][j] < arr[i-1][j]){
                    if(dp[i-1][j] != -1) dp[i][j] += dp[i-1][j]; //상
                }
                if(arr[i][j] < arr[i+1][j]){
                    if(dp[i+1][j] != -1) dp[i][j] += dp[i+1][j]; //하
                }
            }
       }

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println(dp[m][n]);
    }
}
