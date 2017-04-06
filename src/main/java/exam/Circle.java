package exam;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/18.
 */
public class Circle {
    public double getVoloun(int r) {
        return 4 / 3 * Math.PI * r * r * r;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入半径：");
        int r=sc.nextInt();
        Circle circle=new Circle();
        System.out.println(circle.getVoloun(r));
    }
}
