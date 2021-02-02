package Sort;

import java.util.Scanner;

//오름차순 정렬
public class p_2751 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int arr[] = new int[1000000];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        //쉘 정렬
        //시간 초과
        int gap = (n/2)%2==0 ? (n/2)+1 : n/2;

        int temp;
        while(gap > 0){
            for(int i=0; i<n/2; i++){
                for(int j=i+gap; j<n; j+=gap){
                    for(int k=j; k>=i+gap; k-=gap){
                        if(arr[k] < arr[k-gap]){
                            temp = arr[k];
                            arr[k] = arr[k-gap];
                            arr[k-gap] = temp;
                        }
                        else break;
                    }
                }
            }

            if(gap == 1) break;
            gap = (gap/2) % 2 == 0 ? (gap/2 + 1) : gap/2;
        }

        for(int i=0; i<n; i++) sb.append(arr[i]).append('\n');
        System.out.print(sb);
    }
}
