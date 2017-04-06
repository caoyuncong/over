package exam;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/18.
 */
public class Wen {
    public double getHua(double c) {
        return (9/5)*c+32;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入摄氏温度：");
        double c=scanner.nextDouble();
        Wen wen=new Wen();
        System.out.println(wen.getHua(c));

    }
}
