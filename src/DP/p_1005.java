package DP;

import java.io.*;
import java.util.ArrayList;

public class p_1005 {
    private static int t;
    private static int n;
    private static int k;
    private static int d[];
    private static ArrayList map[];
    private static int w;
    private static int dp[];
    private static int answer[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String temp[];

        t = Integer.parseInt(br.readLine());
        answer = new int[t];
        for(int p=0; p<t; p++){
            //n = 건물 종류 수, k = 건설순서규칙 수
            temp = br.readLine().split(" ");
            n = Integer.parseInt(temp[0]);
            k = Integer.parseInt(temp[1]);

            //건물당 건설에 걸리는 시간
            d = new int[n+1];
            temp = br.readLine().split(" ");
            for(int i=0; i<n; i++) d[i+1] = Integer.parseInt(temp[i]);

            //ArrayList의 각 index에 ArrayList를 두고 그것들이 가능한 건물 순서를 저장
            //예) index = (3-1)에 존재하는 AL은
            //x -> 3의, 생성되기 이전의 건물 'x'를 저장함
            map = new ArrayList[n];
            for(int i=0; i<n; i++) map[i] = new ArrayList<Integer>();
            for(int i=0; i<k; i++){
                temp = br.readLine().split(" ");
                int prevB = Integer.parseInt(temp[0]);
                int nextB = Integer.parseInt(temp[1]);
                map[nextB-1].add(prevB);
            }

            // 목표 건물 번호
            w = Integer.parseInt(br.readLine());

            //알고리즘 시작
            dp = new int[n+1];
            for(int i=1; i<=n; i++) dp[i] = -1;
            answer[p] = solve(w);
        }

        for(int i=0; i<t; i++) bw.write(answer[i]+"\n");
        bw.flush();
    }

    private static int solve(int n){
        if(dp[n] == -1){
            ArrayList<Integer> prevNums = map[n-1];
            int listSize = prevNums.size();
            int prevMax = 0;
            for(int i=0; i<listSize; i++){
                prevMax = Math.max(prevMax, solve(prevNums.get(i)));
            }
            dp[n] = prevMax + d[n];

            return dp[n];
        }else{
            return dp[n];
        }
    }
}
