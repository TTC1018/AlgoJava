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

        int t = Integer.parseInt(br.readLine());

        temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]), k = Integer.parseInt(temp[1]);
        //건물 종류 수, 건설순서규칙 수

        int d[] = new int[n+1]; //건물당 건설에 걸리는 시간
        temp = br.readLine().split(" ");
        for(int i=0; i<n; i++) d[i+1] = Integer.parseInt(temp[i]);

        //ArrayList의 각 index에 Stack을 두고 Stack들이 가능한 건물 순서의 대상을 저장한다
        //예) index = 0에 존재하는 Stack은
        //1 -> x의, 건물순서의 대상 건물 'x'를 저장함
        ArrayList<Stack> map = new ArrayList<>();
        for(int i=0; i<n; i++) map.add(new Stack<Integer>());

        for(int i=0; i<k; i++){
            temp = br.readLine().split(" ");
            int prevB = Integer.parseInt(temp[0]);
            int nextB = Integer.parseInt(temp[1]);
            map.get(prevB-1).add(nextB);
        }

        int w = Integer.parseInt(br.readLine()); // 목표 건물 번호
        br.close();

        int dp[] = new int[n+1];
        for(int i=0; i<t; i++){



            bw.write(Integer.toString(dp[w]) + "\n");
            bw.flush();
        }
    }

}
