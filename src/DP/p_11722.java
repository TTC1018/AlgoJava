package DP;

import java.util.Scanner;

//감소수열
public class p_11722 {
    public static void main(String[] args) {

        int n, max;
        int arr[] = new int[1000];
        int dp[] = new int[1000];

        String temp;
        String temp2[];

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();

        temp = sc.nextLine();
        temp2 = temp.split(" ");
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(temp2[i]);


        dp[0] = 1;
        max = dp[0];

        for(int i=1; i<n; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[i]<arr[j] && dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1;
                }
            }
            if(max < dp[i]) max = dp[i];
        }

        System.out.println(max);
    }
}
