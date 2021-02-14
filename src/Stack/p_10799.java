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

        Stack<String> stack2 = new Stack<>();
        int curLasers = 0;
        int maxLasers = 0;
        int cut = 0;

        //큰 ()가 유지되다가 중간에 새로운 ()가 유지될 때의 경우까지 고려하는 것이 필요
        while(stack.size() >= 2){
            String top = stack.peek();
            if(top.equals(")")){
                stack2.push(stack.pop());

                if(stack.peek().equals("(")){//레이저 생성되는 경우
                    if(stack2.size() == 1){ //바깥 괄호 없는 경우
                        curLasers = 0;
                        maxLasers = 0;
                        stack.pop();
                        stack2.pop();
                    }else{
                        curLasers++;
                        stack.pop();
                        stack2.pop();
                    }
                }
                else{ //또 ")"가 있을 때
                    maxLasers += curLasers;
                    curLasers = 0;
                }
            }
            else if(top.equals("(")){
                if(curLasers != 0){
                    if(stack2.size() != 1) maxLasers += curLasers;
                    cut += (curLasers+1);
                    curLasers = 0;
                    stack.pop();
                    stack2.pop();
                }
                else{
                    cut += (maxLasers+1);
                    stack.pop();
                    stack2.pop();
                }
            }
            System.out.println("curL : " + curLasers + ", maxL : " + maxLasers + ", cut : " + cut);
        }

        bw.write(Integer.toString(cut));
        bw.flush();
    }
}
