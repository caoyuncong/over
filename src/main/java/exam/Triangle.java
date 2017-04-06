package exam;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/18.
 */
public class Triangle {
    public double getC(double a, double b, double c) {
        return a + b + c;
    }

    public double getArea(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public static void main(String[] args) {
        Triangle trangle = new Triangle();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入边长：");
        double a = scanner.nextDouble();
        System.out.println("请输入边长：");
        double b = scanner.nextDouble();
        System.out.println("请输入边长：");
        double c = scanner.nextDouble();

        if (a + b > c || a + c > b || b + c > a) {
            System.out.println(trangle.getC(a, b, c));
            System.out.println(trangle.getArea(a, b, c));
        } else {
            System.out.println("不符合三角形规则！");
        }

    }
}
