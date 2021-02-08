package Sort;

import java.io.*;
import java.util.Arrays;

public class p_11004 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String temp[];
        temp = br.readLine().split(" ");
        int n = Integer.parseInt((temp[0])), k = Integer.parseInt((temp[1]));

        temp = br.readLine().split(" ");
        int arr[] = new int[n];
        for(int i=0; i<n; i++)arr[i] = Integer.parseInt(temp[i]);

        Arrays.sort(arr);

        bw.write(Integer.toString(arr[k-1]));
        bw.flush();
    }
}
