package DP;

import java.util.Scanner;

//증가수열의 최대값
public class p_11055 {

    public static void main(String[] args) {

        int n, maximum;
        int arr[] = new int[1000];
        int max[] = new int[1000];
        String temp;
        String temp2[];

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();

        temp = sc.nextLine();
        temp2 = temp.split(" ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(temp2[i]);
        }

        max[0] = arr[0];
        maximum = max[0];

        for(int i=1; i<n; i++){
            max[i] = arr[i];
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j] && max[i]<max[j]+arr[i]){
                    max[i] = max[j] + arr[i];
                }
            }
            if(max[i] > maximum) maximum = max[i];
        }

        System.out.println(maximum);
    }
}
