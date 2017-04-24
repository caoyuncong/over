package string;

import java.util.Scanner;

/**
 * Created by caoyuncong on
 * 2017/4/15 9:26
 * over.
 */
// 写出一个程序，接受一个浮点数值，输出该数值的近似整数值。
// 如果小数点后数值大于等于5,向上取整；小于5，则向下取整
//例如：
//        -4.5 四舍五入的结果是-4
//        4.4 四舍五入的结果是4
public class StringTest5 {
    public static void main(String[] args) {
        double d = -23.234;
        System.out.println(getValue(d));
    }

    public static int getValue(double d) {
        if (!String.valueOf(d).contains(".")) {
            return (int)d;
        }
        String[] ss = String.valueOf(d).split("\\.");
        if (Integer.valueOf(ss[1].substring(0, 1)).intValue() < 5) {
            return (int) Math.floor(d);
        } else {
            return (int) Math.ceil(d);
        }
    }

}
