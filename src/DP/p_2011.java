package DP;

import java.util.Scanner;

//암호코드
public class p_2011 {
    public static void main(String[] args) {

        //A~I : 1~9
        //J~S : 10~19
        //T~Z : 20~26
        long mod = 1000000;
        int num[] = new int[5001];
        int dp[] = new int[5001];

        String nums;
        String nums2[];
        Scanner sc = new Scanner(System.in);
        nums = sc.nextLine();
        nums2 = nums.split("");
        for(int i=0; i<nums2.length; i++) num[i+1] = Integer.parseInt(nums2[i]);
        num[0] = 0;


        int len = nums2.length;
        //예외처리
        if(len > 5000 || nums2[0].equals("0")){
            System.out.println(0);
        }
        //암호코드가 존재한다고 할 때, 두가지 케이스를 고려할 수 있다
        //하나는 마지막 한자리 숫자를 한 알파벳으로 인식하는 경우
        //하나는 마지막 두자리 숫자를 한 알파벳으로 인식하는 경우
        //우선 입력된 암호코드의 맨 앞부분에 0을 붙여준다
        //예를 들어 25114를 입력했다면 025114라고 생각한다
        //인덱스는 0이 아닌 1부터 시작하는데, 현재 인덱스와 한자리 이전 인덱스를 고려했을 때
        //두 수가 10이상 26이하이면 하나의 알파벳으로 판단할 수 있기 때문에
        //그 경우의 수 또한 현재의 경우의 수에 더해주어야 한다
        //그래서 결론적으로 마지막 수를 한자리 수라고 고려했을 때는
        //dp[i] = dp[i] + dp[i-1] 이고
        //마지막 수를 10~26을 암호로 갖는 알파벳이라고 고려했을 때는
        //dp[i] = dp[i] + dp[i-2] 이다
        //이 두가지 케이스를 함께 다 고려하고 더해주면 된다
        else{
            dp[0] = 1;
            for(int i=1; i<=len; i++) {
                if (num[i] >= 1 && num[i] <= 9) {
                    dp[i] += dp[i - 1];
                }

                int temp = num[i - 1] * 10 + num[i];
                if (temp >= 10 && temp <= 26) {
                    dp[i] += dp[i - 2];
                }
                dp[i] %= mod;
            }
            System.out.println(dp[len]);
        }
    }
}
