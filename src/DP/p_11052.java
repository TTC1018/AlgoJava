package DP;

import java.util.Scanner;

//카드 구매하기
public class p_11052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n; //카드의 개수
        int arr[] = new int[1001];
        int dp[] = new int[1001];
        String temp;
        String temp2[];

        n = sc.nextInt();
        sc.nextLine();

        temp = sc.nextLine();
        temp2 = temp.split(" ");
        for(int i=0; i<temp2.length; i++) arr[i+1] = Integer.parseInt(temp2[i]);

        dp[0] = 0;
        dp[1] = arr[1];
        for(int i=2; i<=n; i++){
            dp[i] = arr[i];
            for(int j=1; j<i; j++){
                dp[i] = dp[i] < dp[i-j] + arr[j] ? dp[i-j] + arr[j] : dp[i];
            }
        }
        System.out.println(dp[n]);
    }
}
