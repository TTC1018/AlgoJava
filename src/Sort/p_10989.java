package Sort;

import java.io.*;

//Scanner보다 reader, writer를 활용하자
public class p_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 0;

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        br.close();

        int[] count = new int[max+1];
        for(int i=1; i<=max; i++) count[i] = 0;

        for(int i=0; i<n; i++) count[arr[i]]++;
        for(int i=2; i<=max; i++) count[i] += count[i-1];

        int[] res = new int[n];
        for(int i=0; i<n; i++){
            res[count[arr[i]]-1] = arr[i];
            count[arr[i]]--;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<res.length; i++) bw.write(res[i] + "\n");
        bw.close();
    }
}
