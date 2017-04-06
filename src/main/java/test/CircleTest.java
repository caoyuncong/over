package test;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/2/18.
 */
// 已知圆球的体积公式为 4/3*π*r^3 编写程序，接收用户输入的圆球半径，
// 计算并输出球的体积 （5 分）
public class CircleTest {
    private static double getBallVolume(double radius) {
        return (4 / 3) * Math.PI * Math.pow(radius, 3);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入圆球的半径： ");
        double radius = scanner.nextDouble();
        System.out.println("圆球的体积为："+getBallVolume(radius));
    }
}
