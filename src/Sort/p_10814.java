package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p_10814 {
    private static class Member implements Comparable<Member>{

        private int age;
        private String name;

        public Member(){
            this.age = 0;
            name = null;
        }

        public Member(int age, String name){
            this.age = age;
            this.name = name;
        }

        public int getAge(){
            return this.age;
        }

        public String getName(){
            return this.name;
        }

        public void showInf(){
            System.out.print(age + " " + name);
            System.out.println();
        }

        @Override
        public int compareTo(Member member) {
            if(this.age < member.age){
                return -1;
            }else if(this.age == member.age){
                return 0;
            }else return 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<Member> list = new ArrayList<Member>();

        String temp;
        String temp2[];

        for(int i=0; i<n; i++){
            temp = sc.nextLine();
            temp2 = temp.split(" ");
            list.add(new Member(Integer.parseInt(temp2[0]), temp2[1]));
        }

        Collections.sort(list);
        for(int i=0; i<list.size(); i++) list.get(i).showInf();
    }
}
