package c;

import c.circle.Circle;
import c.cylinder.Cylinder;

/**
 * Created by Administrator on 2017/2/18.
 */
// exam.Test.java 文件，在该文件中定义主类 exam.Test，该类在 c 包中，其中包含主方法 main
// 在主方法中创建两个圆类对象 circle1 和 circle2，初始化参数值自行确定，输出圆的面积和周长
// 在主方法中创建两个圆柱体类的对象 cylinder1 和 cylinder2，初始化参数值自行确定，
// 分别输出圆柱体的底圆的面积和周长以及各自的体积和表面积
public class Test {
    public static void main(String[] args) {
        Circle circle1 = new Circle(1.2);
        Circle circle2 = new Circle(2.3);

        System.out.println("circle1 周长：" + circle1.perimeter());
        System.out.println("circle1 面积：" + circle1.area());

        System.out.println("circle2 周长：" + circle2.perimeter());
        System.out.println("circle2 面积：" + circle2.area());

        Cylinder cylinder1 = new Cylinder(1.1, 1.5);
        Cylinder cylinder2 = new Cylinder(1.5, 2.5);

        Circle circle3 = new Circle(1.2);
        System.out.println("cylinder1 底圆面积：" + circle3.area());
        System.out.println("cylinder1 底圆周长：" + cylinder1.perimeter());
        System.out.println("cylinder1 表面积：" + cylinder1.area());
        System.out.println("cylinder1 体积：" + cylinder1.volume());

        Circle circle4 = new Circle(5.6);
        System.out.println("cylinder2 底圆面积：" + circle4.area());
        System.out.println("cylinder2 底圆周长：" + cylinder2.perimeter());
        System.out.println("cylinder2 表面积：" + cylinder2.area());
        System.out.println("cylinder2 体积：" + cylinder2.volume());
    }
}
