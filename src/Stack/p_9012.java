package Stack;

import java.io.*;
import java.util.Stack;

public class p_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        Stack<String> stack;
        Stack<String> rightStack;
        String temp[];
        boolean flag, answer;

        for(int i=0; i<t; i++){
            flag = true;
            answer = true;

            stack = new Stack<>();
            rightStack = new Stack<>();

            temp = br.readLine().split("");
            for(int j=0; j<temp.length; j++) stack.push(temp[j]);

            while(stack.size() != 0 && flag == true){
                String top = stack.peek();
                if(top.equals("(")) {
                    if(rightStack.size() == 0 || stack.size()<rightStack.size()){
                        answer = false;
                        flag = false;
                        break;
                    }
                    rightStack.pop();
                    stack.pop();
                }
                else{
                    if(stack.size() == 1){
                        answer = false;
                        flag = false;
                    }
                    rightStack.push(stack.pop());
                }
            }

            if(answer)
                bw.write("YES\n");
            else
                bw.write("NO\n");
            bw.flush();
        }
    }
}
