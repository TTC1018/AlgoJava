package DP;

import java.io.*;

public class p_1915 {

    static int n, m;
    static int[][] arr, dp;
    //2차원 dp행렬

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String temp[] = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        arr = new int[n+1][m+1];
        dp = new int[n+1][m+1];

        for(int i=0; i<n; i++){
            temp = br.readLine().split("");
            for(int j=0; j<m; j++){
                arr[i+1][j+1] = Integer.parseInt(temp[j]);
                dp[i+1][j+1] = -1;
            }
        }

        solve(n, m);
        bw.write(Integer.toString(dp[n][m]));
        bw.flush();
    }

    private static int solve(int x, int y){
        if(dp[x][y] != -1) return dp[x][y];
        else{
            if(x==1 || y==1){
                if(arr[x][y] != 1) dp[x][y] = 0;
                else dp[x][y] = 1;

                return dp[x][y]; // dp[x][y] = 1 or 0
            }
            else{
                dp[x][y] = 0;
                int max = dp[x][y];
                int limit = Math.min(x, y);
                //행,열 중 더 작은 수 저장
                //정사각형의 최대 크기는 더 작은 수가 결정하기 때문

                for(int i=x; i>=1; i--){ //자기보다 아래에 사각형 존재하는지 확인
                    for(int j=y; j>=1; j--){
                        max = Math.max(max, solve(i, j));
                    }
                    if(max >= Math.pow(limit, 2)){ //이미 가능한 최대치면 메소드 종료
                        dp[x][y] = max;
                        return dp[x][y];
                    }
                }
                dp[x][y] = max;

                if(max < Math.pow(limit, 2)){
                    for(int k=1; k<=limit; k++){
                        for(int i=x; i>x-k; i--){
                            for(int j=y; j>y-k; j--){
                                if(arr[i][j] != 1) return dp[x][y];
                            }
                        }
                        max = (int) Math.max(max, Math.pow(k, 2));
                        if(max > dp[x][y]) dp[x][y] = max;
                    }
                }
                return dp[x][y];
            }
        }
    }
}
