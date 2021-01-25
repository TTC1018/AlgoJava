package DP;

import java.util.Scanner;


//증가수열
public class p_11053 {
    public static void main(String[] args) {
        int n, max;
        int arr[] = new int[1000];
        int dp[] = new int[1000];
        String temp1;
        String temp2[];
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine(); //개행문자 제거

        temp1 = sc.nextLine();
        temp2 = temp1.split(" ");
        for(int i=0; i<temp2.length; i++){
            arr[i] = Integer.parseInt(temp2[i]);
        }
        dp[0] = 1;
        max = 1;

        //정확한 dp 계산 필요
//        for(int i=1; i<n; i++){
//            if(arr[i] > max){
//                max = arr[i];
//                dp[i] = dp[i-1] + 1;
//            }else{
//                dp[i] = dp[i-1];
//            }
//        }

        for(int i=1; i<n; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j] && dp[i]<dp[j]+1){
                    dp[i]+=1;
                }
            }
            if(dp[i] > max) max = dp[i];
        }

        System.out.println(max);
    }
}
