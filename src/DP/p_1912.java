package DP;

import java.util.Scanner;

public class p_1912 {
    public static void main(String[] args) {
        int n, max;
        int dp[] = new int[100000];

        String temp;
        String temp2[];

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();

        temp = sc.nextLine();
        temp2 = temp.split(" ");
        for(int i=0; i<n; i++) dp[i] = Integer.parseInt(temp2[i]);

        //본인 풀이 (런타임 시간 초과)
//        dp[0] = arr[0];
//        max = dp[0];
//        int sum;
//        for(int i=1; i<n; i++){
//            dp[i] = arr[i];
//            sum = arr[i];
//            for(int j=i-1; j>=0; j--){
//                sum += arr[j];
//                if(max < sum){
//                    max = sum;
//                    dp[i] = max;
//                }else if(dp[i]<dp[i-1]){
//                    dp[i] = dp[i-1];
//                }
//            }
//

        //dp배열의 각 요소가 답을 의미할 필요는 없다
        //최대값만 출력하면 된다 (그것은 dp배열에서의 최대값이 된다)
        max = dp[0];
        for(int i=1; i<n; i++){
            if(dp[i-1]>0 && dp[i]+dp[i-1]>0){
                dp[i] += dp[i-1];
            }

            if(max < dp[i]) max = dp[i];
        }

        System.out.println(max);

    }
}
