package DP;

import java.util.Scanner;

public class p_2294 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[2];
        String temp;
        String temp2[];
        temp = sc.nextLine();
        temp2 = temp.split(" ");
        for(int i=0; i<temp2.length; i++) arr[i] = Integer.parseInt(temp2[i]);

        int n = arr[0], k = arr[1];
        int dp[] = new int[100001];
        for(int i=1; i<=100000; i++) dp[i] = 100001;
        dp[0] = 0;

        int coin[] = new int[101]; // n가지 종료의 동전이 담긴 배열
        for(int i=1; i<=n; i++){
            coin[i] = sc.nextInt();
        }

        for(int i=1; i<=n; i++){
            for(int j=coin[i]; j<=k; j++){
                dp[j] = Math.min(dp[j], dp[j-coin[i]] + 1);
            }
        }

        if(dp[k] == 100001) dp[k] = -1;
        System.out.println(dp[k]);
    }
}
