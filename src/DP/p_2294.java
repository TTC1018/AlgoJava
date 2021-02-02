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
        int dp[] = new int[10001];
        for(int i=0; i<=10000; i++) dp[i] = -1;

        int coin[] = new int[101];
        for(int i=1; i<=n; i++){
            coin[i] = sc.nextInt();
            dp[coin[i]] = 1;
        }

        int min = coin[1];
        if(n>=2){
            for(int i=2; i<=n; i++){
                min = Math.min(min, coin[i]);
            }
        }

        int min2 = 1;
        for(int i=min*2; i<=k; i++){
            for(int j=1; j<=n; j++){
                int num = i - coin[j];

                if(num <= 0) continue;
                else{
                    if(j == 1) min2 = dp[num] + 1;
                    else min2 = min2 > dp[num] ? dp[num] + 1 : min2;
                }
            }
            dp[i] = min2;
        }

        System.out.println(dp[k]);
    }
}
