package Stack;

import java.io.*;

public class p_10828 {

    private static int stack[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int cursor = -1;
        stack = new int[n];

        for(int i=0; i<n; i++){
            String temp[];
            temp = br.readLine().split(" ");
            //명령어 종류
            //push x : x를 스택에 삽입
            //pop : 스택의 최상단 정수를 꺼내서 출력. 없으면 -1 출력
            //size : 스택에 들어있는 정수의 개수를 출력
            //empty : 스택이 비어있으면 1, 아니면 0 출력
            //top : 스택의 최상단 정수를 출력, 없으면 -1 출력
            switch(temp[0]){
                case "push":
                    cursor++;
                    stack[cursor] = Integer.parseInt(temp[1]);
                    break;
                case "pop":
                    if(cursor == -1){
                        bw.write("-1"+"\n");
                        bw.flush();
                    }else{
                        int popped = stack[cursor];
                        bw.write(Integer.toString(popped)+"\n");
                        bw.flush();
                        cursor--;
                    }
                    break;
                case "size":
                    if(cursor == -1){
                        bw.write("0\n");
                        bw.flush();
                    }else{
                        bw.write(Integer.toString(cursor+1) + "\n");
                        bw.flush();
                    }
                    break;
                case "empty":
                    if(cursor == -1) bw.write("1\n");
                    else bw.write("0\n");
                    bw.flush();
                    break;
                case "top":
                    if(cursor == -1) bw.write("-1\n");
                    else bw.write(Integer.toString(stack[cursor])+"\n");
                    bw.flush();
                    break;
            }
        }
    }
}
