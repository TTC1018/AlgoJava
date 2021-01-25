package DP;

import java.util.Scanner;

//바이토닉 수열
public class p_11054 {
    public static void main(String[] args) {

        int n, max;
        int arr[] = new int[1000];
        int dp[] = new int[1000]; //증가함수 저장
        int dp2[] = new int[1000]; //감소함수 저장
        int dp3[] = new int[1000]; //바이토닉 함수

        String temp;
        String temp2[];
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();

        temp = sc.nextLine();
        temp2 = temp.split(" ");
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(temp2[i]);

        dp[0] = 1;
        for(int i=1; i<n; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j] && dp[i]<dp[j]+1) dp[i] = dp[j]+1;
            }
        }

        dp2[n-1] = 1;
        for(int i=n-2; i>=0; i--){
            dp2[i] = 1;
            for(int j=n-1; j>=i+1; j--){
                if(arr[i]>arr[j] && dp2[i]<dp2[j]+1) dp2[i] = dp2[j]+1;
            }
        }

        dp3[0] = dp[0] + dp2[0] - 1;
        max = dp3[0];
        for(int i=0; i<n; i++){
            dp3[i] = dp[i]+dp2[i]-1; //중복제거를 위해 -1
            if(max < dp3[i]) max = dp3[i];
        }

        System.out.println(max);
    }
}
