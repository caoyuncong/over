package cao;

import java.util.Scanner;

/**
 * Created by cao on
 * 2017/4/1 13:49
 * over.
 */
// 从键盘上输入一个字符串，利用字符串类的方法将大写字母转变为小写字母，
// 小写字母转变为大写字母，再将前后字符对换,然后输出最后结果。
public class E2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input String:");
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];

//            String s1 = aChar + "";
            String s1 = Character.toString(aChar);
            if (s1.toLowerCase().equals(s1)) {
                s1 = s1.toUpperCase();
                chars[i] = s1.toCharArray()[0];
            } else if (s1.toUpperCase().equals(s1)) {
                s1 = s1.toLowerCase();
                chars[i] = s1.toCharArray()[0];
            }

        }
            char temp = chars[0];
            chars[0] = chars[chars.length - 1];
            chars[chars.length - 1] = temp;

            System.out.println(String.valueOf(chars));
            System.out.println(new String(chars));
    }

}
