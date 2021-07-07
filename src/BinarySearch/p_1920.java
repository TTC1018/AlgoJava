package BinarySearch;

import java.io.*;
import java.util.Arrays;

public class p_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        String[] temp = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            A[i] = Integer.parseInt(temp[i]);
        }
        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        temp = br.readLine().split(" ");
        for(int i=0; i<m; i++){
            B[i] = Integer.parseInt(temp[i]);
        }

        Arrays.sort(A);
        int min = 0;
        int max = A.length;
        int midValue = (min+max)/2;
        int mid = A[midValue];

        for(int i=0; i<m; i++){
            min = 0;
            max = A.length;

            if(A[A.length-1] < B[i]){
                bw.write("0");
                bw.flush();
                continue;
            }

            while(min <= max){

                midValue = (min+max)/2;
                mid = A[midValue];

                if(mid == B[i]){
                    bw.write("1");
                    bw.flush();
                    break;
                }
                else if(mid > B[i]){
                    max = midValue - 1;
                }
                else{
                    min = midValue + 1;
                }

                if(min == max){
                    bw.write("0");
                    bw.flush();
                    break;
                }
            }

            if(i != m-1)
                bw.write("\n");
        }
    }
}
