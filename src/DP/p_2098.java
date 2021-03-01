package DP;

import java.io.*;
import java.util.Arrays;

//외판원 순회
public class p_2098 {
    static final int MAX = 1000000*16 + 1;
    static int n;
    static int W[][];
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        W = new int[n][n];
        dp = new int[n][1<<n];
        String temp[];
        for(int i=0; i<n; i++){
            temp = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                W[i][j] = Integer.parseInt(temp[j]);
            }
            Arrays.fill(dp[i], MAX);
        }
        bw.write(Integer.toString(tsp(0, 1)));
        bw.flush();
    }

    //비트를 사용하여 방문한 경로를 기록한다
    //0001 -> A는 다녀온 것
   private static int tsp(int cur, int visited){
        if(visited == ((1<<n) - 1)){
            if(W[cur][0] == 0) return MAX;
            return W[cur][0];
        }
        if(dp[cur][visited] != MAX) return dp[cur][visited];

        for(int i=0; i<n; i++){
            if((visited & (1 << i))==0 && W[cur][i] != 0){ //도착 대상이 본인이 아니고, 갈 수 있는 경로일 때
                dp[cur][visited] = Math.min(dp[cur][visited], tsp(i, visited|(1 << i)) + W[cur][i]);
            }
        }
        return dp[cur][visited];
    }
}
