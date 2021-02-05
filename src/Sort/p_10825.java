package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//국영수 점수 정렬
public class p_10825 {
    private static class Student implements Comparable<Student>{
        private String name;
        private int kor;
        private int eng;
        private int math;

        Student(String name, int kor, int eng, int math){
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Student student) {
            if(this.kor > student.kor) return -1;
            else if(this.kor == student.kor){
                if(this.eng < student.eng) return -1;
                else if(this.eng == student.eng){
                    if(this.math > student.math) return -1;
                    else if(this.math == student.math) {
                        char[] thisName = this.name.toCharArray();
                        char[] comName = student.getName().toCharArray();
                        int maxLen = Math.min(thisName.length, comName.length);
                        for(int i=0; i<maxLen; i++){
                            if(thisName[i] < comName[i]) return -1;
                            else if(thisName[i] == comName[i]) continue;
                            else return 1;
                        }
                        if(thisName.length == maxLen) return -1;
                        else return 1;
                    }
                    else return 1;
                }
                else return 1;
            }
            else return 1;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<Student> list = new ArrayList<Student>();
        String temp;
        String temp2[];
        int kor, eng, math;

        for(int i=0; i<n; i++){
            temp = sc.nextLine();
            temp2 = temp.split(" ");
            kor = Integer.parseInt(temp2[1]);
            eng = Integer.parseInt(temp2[2]);
            math = Integer.parseInt(temp2[3]);
            list.add(new Student(temp2[0], kor, eng, math));
        }

        Collections.sort(list);
        for(int i=0; i<list.size(); i++) System.out.println(list.get(i).getName());
    }
}
