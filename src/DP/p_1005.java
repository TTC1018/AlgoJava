package DP;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class p_1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String temp[];
        int answer[];

        int t = Integer.parseInt(br.readLine());
        answer = new int[t];
        for(int p=0; p<t; p++){
            //n = 건물 종류 수, k = 건설순서규칙 수
            temp = br.readLine().split(" ");
            int n = Integer.parseInt(temp[0]), k = Integer.parseInt(temp[1]);

            //건물당 건설에 걸리는 시간
            int d[] = new int[n+1];
            temp = br.readLine().split(" ");
            for(int i=0; i<n; i++) d[i+1] = Integer.parseInt(temp[i]);

            //ArrayList의 각 index에 Stack을 두고 Stack들이 가능한 건물 순서를 저장
            //예) index = (3-1)에 존재하는 Stack은
            //x -> 3의, 생성되기 이전의 건물 'x'를 저장함
            ArrayList<Stack> map = new ArrayList<>();
            for(int i=0; i<n; i++) map.add(new Stack<Integer>());
            for(int i=0; i<k; i++){
                temp = br.readLine().split(" ");
                int prevB = Integer.parseInt(temp[0]);
                int nextB = Integer.parseInt(temp[1]);
                map.get(nextB-1).add(prevB);
            }

            // 목표 건물 번호
            int w = Integer.parseInt(br.readLine());

            //알고리즘 시작
            //걸리는 시간이 0인 경우는 어떻게 할 것인지??
            int dp[] = new int[n+1];
            dp[0] = 0;
            dp[1] = d[1];
            for(int i=2; i<=w; i++){
                Stack<Integer> prevNums = map.get(i-1);
                int target = dp[prevNums.peek()];
                int size = prevNums.size();
                for(int j=0; j<size; j++){
                    target = Math.max(target, dp[prevNums.pop()]);
                }
                dp[i] = target + d[i];
            }
            answer[p] = dp[w];
        }

        br.close();
        for(int i=0; i<t; i++) bw.write(answer[i]+"\n");
        bw.close();
    }

}
