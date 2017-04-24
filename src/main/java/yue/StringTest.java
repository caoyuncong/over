package yue;

import java.util.Scanner;


/**
 * Created by caoyuncong on
 * 2017/4/8 13:56
 * over.
 */
public class StringTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input:   ");
        String s = scanner.nextLine();
        byte[] bytes = s.getBytes();
        int sum = 0;
        for (byte aByte : bytes) {
            sum = sum + aByte;
        }
        System.out.println(sum);

    }
}
