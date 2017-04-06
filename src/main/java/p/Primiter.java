package p;

import java.lang.reflect.Member;

/**
 * Created by cao on
 * 2017/3/25 9:25
 * over.
 */
public class Primiter {
    public static void method(int x) {
        System.out.println(x);
        x++;
        System.out.println(x);
    }

    public static void main(String[] args) {
        int i=0;
        System.out.println(i);
        method(i);
        System.out.println(i);
    }
}
