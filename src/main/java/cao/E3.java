package cao;

import java.util.Scanner;

/**
 * Created by cao on
 * 2017/4/1 13:55
 * over.
 */
// 使用键盘录入一个字符串，获取字符串中每一个字符出现的次数，
// 要求统计结果格式为：a(5),b(4),c(3),d(2),e(1)
public class E3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input String:");
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();

        int english = 0;
        int number = 0;
        int special = 0;
        int space = 0;

        for (char aChar : chars) {
            if ((aChar >= 65 && aChar <= 91) || (aChar >= 97 && aChar <= 123)) {
                english++;
            } else if (aChar >= 0 && aChar <= 9) {
                number++;
            } else if (aChar == ' ') {
                space++;
            } else {
                special++;
            }
        }
        System.out.println("english: " + english);
        System.out.println("number: " + number);
        System.out.println("space: " + space);
        System.out.println("special: " + special);
    }
}
