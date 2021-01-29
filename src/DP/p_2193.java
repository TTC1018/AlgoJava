package DP;

import java.util.Scanner;

//이친수
public class p_2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //dp[N][j] = 길이가 N이고 j로 끝나는 경우의 이친수 개수
        long dp[][] = new long[91][2];

        dp[1][0] = 0;
        dp[1][1] = 1;

        //끝자리수가 0이거나 1일 경우를 생각해본다
        //0이라면 이어진 이전의 수는 0, 1이 가능
        //1이라면 이어진 이전의 수는 0만 가능
        //이것을 점화식으로 표현한다.
        for(int i=2; i<=n; i++){
            for(int j=0; j<=1; j++){
                if(j == 0) dp[i][j] = dp[i-1][j] + dp[i-1][j+1];
                else if(j == 1) dp[i][j] = dp[i-1][j-1];
            }
        }

        long answer = 0;
        for(int i=0; i<=1; i++){
            answer += dp[n][i];
        }
        System.out.println(answer);
    }
}
