package DP;

import java.io.*;
import java.util.Arrays;

//팰린드롬
public class p_10942 {

    static int n, m, s ,e;
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        String temp[] = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(temp[i]);
        }

        m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            temp = br.readLine().split(" ");
            s = Integer.parseInt(temp[0]);
            e = Integer.parseInt(temp[1]);
            bw.write(Integer.toString(solve(Arrays.copyOfRange(arr, s-1, e))));
            bw.flush();
        }
    }

    private static int solve(int input_arr[]){
        int nums[] = input_arr;
        int len = nums.length;
        int dp[];

        if(len==1) return 1;
        else if(len==2){
            if(nums[0] == nums[1]) return 1;
            else return 0;
        }

        if(len%2 != 0){
            dp = new int[len/2+1];
            dp[0] = 1;
            for(int i=1; i<(len/2)+1; i++){
                if(nums[(len/2) - i] == nums[(len/2) + i] && dp[i-1] == 1) dp[i] = 1;
                else return 0;
            }
            return dp[len/2];
        }else{
            dp = new int[len/2];
            if(nums[len/2-1] == nums[len/2]) dp[0] = 1;
            else return 0;

            for(int i=1; i<len/2; i++){
                if(nums[len/2 - i] == nums[(len/2)+1 + i] && dp[i-1] == 1) dp[i] = 1;
                else return 0;
            }
            return dp[len/2 - 1];
        }
    }
}
