package DP;

import java.util.Scanner;

//1로 만들기 (최소 연산횟수 구하기)
public class p_1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        n = sc.nextInt();
        int dp[] = new int[1000001];

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        //3으로 나누어졌을 때, 2로 나누어 졌을 때, 1을 뺐을 때의 값을 비교
        //단순히 3이나 2로 나누는 게 최선이 아닐 수도 있기 때문에
        //세가지 경우의 값을 비교해봐야 한다
        for(int i=4; i<=n; i++){
            dp[i] = dp[i-1] + 1;
            if(i%3 == 0) dp[i] = dp[i] > dp[i/3] + 1 ? dp[i/3]+1 : dp[i];
            if(i%2 == 0) dp[i] = dp[i] > dp[i/2] + 1 ? dp[i/2]+1 : dp[i];
        }

        System.out.println(dp[n]);
    }
}
