package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p_2751_timsort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> list = new ArrayList();

        int n = sc.nextInt();
        for(int i=0; i<n; i++) list.add(sc.nextInt());

        Collections.sort(list); // timsort

        for(int value : list) sb.append(value).append('\n');

        System.out.print(sb);
    }
}
