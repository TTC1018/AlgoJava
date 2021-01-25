package DP;

import java.util.Scanner;

//계단 오르기
public class p_2579 {
    public static void main(String[] args) {
        int n;
        int arr[] = new int[301];
        int dp[] = new int[301];
        arr[0] = 0;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=1; i<=n; i++) arr[i] = sc.nextInt();

        //본인 풀이
//            int j=n-1, flag = 1;
//            while(j!=0) {
//                if (dp[j - 1] > dp[j] || flag == 2) {
//                    dp[n] += dp[j - 1];
//                    j -= 2;
//                    flag = 0;
//                } else if (dp[j - 1] <= dp[j] && flag != 2) {
//                    dp[n] += dp[j];
//                    j -= 1;
//                    flag += 1;
//                }
//                System.out.println("j = " + j + ", dp = " + dp[n]);
//            }
//        System.out.println(dp[n]);

        dp[0]=0;
        dp[1]=arr[1];
        dp[2]=arr[1]+arr[2];

        //DP는 문제를 쪼개서 생각하는 것을 잊지말자
        //일부의 해가 모여 전체의 해가 되는 것 (즉 작게 쪼개서 이해하자)
        for(int i=3; i<=n; i++){
            if(arr[i]+arr[i-1]+dp[i-3] > arr[i]+dp[i-2]){
                dp[i] = arr[i]+arr[i-1]+dp[i-3];
            }else{
                dp[i] = arr[i]+dp[i-2];
            }
        }

        System.out.println(dp[n]);
    }
}
