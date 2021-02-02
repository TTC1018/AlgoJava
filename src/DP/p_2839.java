package DP;

import java.util.Scanner;

public class p_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp[] = new int[5001];

        for(int i=0; i<=5; i++){
            if(i==3 || i==5) dp[i] = 1;
            else dp[i] = -1;
        }

        for(int i=6; i<=n; i++){
            int temp1 = dp[i-3];
            int temp2 = dp[i-5];

            if(temp1 > 0 || temp2 > 0){
                if(temp1 == -1) dp[i] = temp2 + 1;
                else if(temp2 == -1) dp[i] = temp1 + 1;
                else dp[i] = temp1 < temp2 ? temp1 + 1 : temp2 + 1;
            }
            else dp[i] = -1;
        }

        System.out.println(dp[n]);
    }
}
