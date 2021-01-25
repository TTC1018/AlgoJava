package DP;

import java.util.Scanner;

//타일 채우기
public class p_2133 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int dp[] = new int[1001];
        dp[0] = 1;
        dp[2] = 3;

        //각 단계에서 조합 불가능한 특수 케이스는 2개만 존재
        //dp[i] = dp[2]*dp[i-2] + 2*dp[i-4] + 2*dp[i-6] + ... + 2
        if(n>=1 && n%2 != 0) dp[n] = 0;
        else{
            for(int i=4; i<=n; i+=2){
                for(int j=2; j<=i; j+=2){
                    int std;
                    if(j == 2) std = 3;
                    else std = 2;

                    dp[i] += std*dp[i-j];
                }
            }
        }
        System.out.println(dp[n]);
    }
}
