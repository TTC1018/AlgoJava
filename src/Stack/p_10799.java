package Stack;

import java.io.*;
import java.util.Stack;

//쇠막대기 절단
public class p_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String temp[] = br.readLine().split("");
        Stack<String> stack = new Stack<>();
        for(int i=0; i<temp.length; i++) stack.push(temp[i]);

        Stack<String> stack2 = new Stack<>(); //우괄호를 담는 stack
        Stack<Integer> stackL = new Stack<>(); //누적 laser 담는 stack

        int curLasers = 0;
        int stackedL = 0;
        int cut = 0;

        //큰 ()가 유지되다가 중간에 새로운 ()가 유지될 때의 경우까지 고려하는 것이 필요
        while(stack.size() != 0){
            String top = stack.peek();
            if(top.equals(")")){
                stack2.push(stack.pop());

                if(stack.peek().equals("(")){//레이저 생성되는 경우
                    if(stack2.size() == 1){ //바깥 괄호 없는 경우
                        curLasers = 0;
                        stack.pop();
                        stack2.pop();
                    }else{
                        curLasers++;
                        stack.pop();
                        stack2.pop();
                        if(stack.size() >= 3 && stack.peek().equals(")")){
                            stackL.push(stackL.pop() + curLasers);
                            curLasers = 0;
                        }
                    }
                }
                else{ //또 ")"가 있을 때
                    stackL.push(curLasers);
                }
            }
            else if(top.equals("(")){
                stackedL = stackL.pop() + curLasers;
                cut += (stackedL+1);

                if(stackL.size() != 0) stackL.push(stackL.pop() + stackedL);

                curLasers = 0;
                stack.pop();
                stack2.pop();
            }
        }
        bw.write(Integer.toString(cut));
        bw.flush();
    }
}
