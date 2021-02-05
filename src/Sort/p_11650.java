package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//좌표 정렬하기
//Comparable의 compareTo 활용
public class p_11650 {
    private static class Point implements Comparable<Point>{
        private int x;
        private int y;

        Point(){
            this.x = 0;
            this.y = 0;
        }

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return this.x;
        }

        public int getY(){
            return this.y;
        }

        @Override
        public int compareTo(Point point) {
            //작다면 음수, 같으면 0, 클 경우 양수 리턴
            if(this.x - point.getX() < 0){
                return -1;
            }else if(this.x == point.getX()){
                if(this.y == point.getY()){
                    return 0;
                }else if(this.y - point.getY() < 0){
                    return -1;
                }else return 1;
            }else return 1;
        }

        public void showLoc(){
            System.out.print(x + " " + y);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 점의 개수
        sc.nextLine();

        String temp;
        String temp2[];
        ArrayList<Point> list = new ArrayList();

        for(int i=1; i<=n; i++){
            temp = sc.nextLine();
            temp2 = temp.split(" ");
            list.add(new Point(Integer.parseInt(temp2[0]), Integer.parseInt(temp2[1])));
        }

        Collections.sort(list);
        for(int i=0; i<list.size(); i++) list.get(i).showLoc();
    }
}
