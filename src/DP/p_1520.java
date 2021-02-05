package DP;

import java.util.Scanner;

//내리막 길
public class p_1520 {
    static int[][] dp, arr;
    static int m, n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String temp;
        String temp2[];

        temp = sc.nextLine();
        temp2 = temp.split(" ");
        m = Integer.parseInt(temp2[0]);
        n = Integer.parseInt(temp2[1]);
        dp = new int[m+1][n+1];
        arr = new int[m+1][n+1];

        for(int i=1; i<=m; i++){
            temp = sc.nextLine();
            temp2 = temp.split(" ");
            for(int j=1; j<=n; j++){
                arr[i][j] = Integer.parseInt(temp2[j-1]);
                dp[i][j] = -1;
            }
        }

        if(m == 1 && n == 1) System.out.println(1);
        else System.out.println(solve_method(1, 1));

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                System.out.printf("%3d", dp[i][j]);
            }
            System.out.println();
        }
    }

    //메소드로 배열의 반복된 합을 표현한다
    private static int solve_method(int x, int y){
        if(x == m && y == n){
            dp[x][y] = 1;
            return 1;
        }
        if(dp[x][y] == -1){
            dp[x][y] = 0;

            if(x > 1 && arr[x][y] > arr[x-1][y]){
                dp[x][y] += solve_method(x-1, y);
            }

            if(x < m && arr[x][y] > arr[x+1][y]){
                dp[x][y] += solve_method(x+1, y);
            }

            if(y > 1 && arr[x][y] > arr[x][y-1]){
                dp[x][y] += solve_method(x, y-1);
            }

            if(y < n && arr[x][y] > arr[x][y+1]){
                dp[x][y] += solve_method(x, y+1);
            }
        }
        return dp[x][y];
    }
}
