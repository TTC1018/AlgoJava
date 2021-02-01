package DP;

import java.util.Scanner;

//스티커
public class p_9465 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t, n; // t = 테스트 케이스 개수, n = 열의 개수
        t = sc.nextInt();

        int arr[][] = new int[3][100001];
        int dp[][] = new int[3][100001];
        int answer[] = new int[t+1];

        String temp;
        String temp2[];

        dp[1][0] = 0;
        dp[2][0] = 0;
        for(int i=1; i<=t; i++){
            n = sc.nextInt();
            sc.nextLine();

            for(int j=1; j<=2; j++){
                temp = sc.nextLine();
                temp2 = temp.split(" ");
                for(int k=1; k<=n; k++){
                    arr[j][k] = Integer.parseInt(temp2[k-1]);
                }
            }

            //떼려는 스티커를 기준으로 생각한다
            //현재 떼려는 스티커를 떼려면 경우의 수가 2가지 존재한다
            //하나는 한칸 대각선 전에서 현재 스티커로 오는 경우
            //다른 하나는 두칸 대각선 전에서 현재 스티커로 오는 경우
            //세칸 대각선 전은 한칸대각선->한칸대각선을 두번 반복한 경우니 제외
            //위 두가지 경우를 비교하여 더 큰 값을 최적의 값으로 생각한다
            dp[1][1] = arr[1][1];
            dp[2][1] = arr[2][1];
            for(int j=2; j<=n; j++){
                for(int k=1; k<=2; k++){
                    if(k == 1) dp[k][j] = dp[k+1][j-2] + arr[k][j] < dp[k+1][j-1] + arr[k][j] ? dp[k+1][j-1] + arr[k][j] : dp[k+1][j-2] + arr[k][j];
                    else if(k == 2) dp[k][j] = dp[k-1][j-2] + arr[k][j] < dp[k-1][j-1] + arr[k][j] ? dp[k-1][j-1] + arr[k][j] : dp[k-1][j-2] + arr[k][j];
                }
            }
            answer[i] = dp[1][n] < dp[2][n] ? dp[2][n] : dp[1][n];
        }

        for(int i=1; i<=t; i++){
            System.out.println(answer[i]);
        }
    }
}
