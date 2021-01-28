package DP;

import java.util.Scanner;

public class p_10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //길이 (자리수)
        int mod = 1000000000;

        int dp[][] = new int[101][10];
        dp[1][0] = 0;
        for(int i=1; i<10; i++){
            dp[1][i] = 1;
        }

        for(int i=2; i<=n; i++){
            for(int j=0; j<=9; j++){
                if(j == 0){
                    dp[i][j] = dp[i-1][j+1] % mod;
                }else if(j == 9){
                    dp[i][j] = dp[i-1][j-1] % mod;
                }else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
                }
            }
        }

        long answer = 0;
        for(int i=0; i<=9; i++){
            answer += dp[n][i];
        }

        answer %= mod;
        System.out.println(answer);


        //답은 나오나 점화식의 모습은 아님
//        int dp[] = new int[n+1];

//        dp[1] = 9;
//        dp[2] = 17;
//        int arr[] = new int[(int)(Math.pow(10, n) - Math.pow(10, n-1))];
//        for(int i=0; i<arr.length; i++){
//            arr[i] = (int)Math.pow(10, n-1) + i;
//        }
//
//        int nums[] = new int[n+1];
//        for(int i=0; i<arr.length; i++){
//            for(int j=n; j>=1; j--){
//                nums[j] = arr[i]%10;
//                arr[i] /= 10;
//            }
//
//            for(int j=1; j<=n-1; j++){
//                int cond = nums[j+1] - nums[j];
//                if(nums[j] == 0){ //증가만 고려
//                    if(cond != 1) break;
//                }else{
//                    if(!(cond == -1 || cond == 1)) break;
//                }
//                if(j == n-1) dp[n] += 1;
//            }
//            dp[n] %= mod;
//        }
//        System.out.println(dp[n]);


    }
}
