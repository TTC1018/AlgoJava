package Sort;

import java.io.*;
import java.util.Arrays;

public class p_11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long arr[] = new long[n];

        int kindNum = 1; //숫자 가지수
        for(int i=0; i<n; i++) arr[i] = Long.parseLong(br.readLine());
        Arrays.sort(arr); //오름차순 정렬

        for(int i=1; i<n; i++){
            if(arr[i] != arr[i-1]) kindNum++;
        }

        if(n == 1){
            bw.write(Long.toString(arr[0]));
            bw.flush();
        }
        else{
            int idx = 1, idx2 = 2;
            int maxNum = 1, maxNow = 1;
            long nextNum = 0, nowNum = 0, result = arr[n-1];
            while(kindNum != 0){
                nextNum = arr[n-idx2];
                nowNum = arr[n-idx];
                if(nextNum != nowNum){
                    int temp = maxNum;
                    maxNow = (n-idx) - (n-idx2 + 1) + 1;
                    maxNum = Math.max(maxNow, maxNum);

                    if(temp <= maxNow) result = nowNum;
                    kindNum--;
                    idx += maxNow;
                    idx2++;
                }
                else idx2++;

                if(kindNum == 1){
                    maxNow = n - idx + 1;
                    if(maxNum <= maxNow) result = nextNum;
                    break;
                }
            }

            bw.write(Long.toString(result));
            bw.flush();
        }
    }
}