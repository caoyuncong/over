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
        for (char aChar : chars) {
            if (aChar >= 'A' && aChar <= 'Z') {
                System.out.println(s.toLowerCase());
                return;
            } else if (aChar >= 'a' && aChar <= 'z') {
                System.out.println(s.toUpperCase());
                return;
            } else {
                System.out.println(aChar);
            }
        }
        chars[0] = chars[chars.length - 1];
        chars[chars.length - 1] = chars[0];
        System.out.println(s);
    }

}
