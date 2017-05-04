package string;

import java.util.Arrays;

/**
 * Created by caoyuncong on
 * 2017/4/15 9:10
 * over.
 */
// 拆分字符串，字符串中含有逗号和数字，对数字排序并输出
//例如：String s0=”123,45,25,85”;
//        输出：25 45 85 123
public class StringTest3 {
    public static void main(String[] args) {
        String s0 = "123,45,25,85";
        String[] s = s0.split("\\,");

        int[] num = new int[s.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(s[i]);
        }
        System.out.println(Arrays.toString(num));

        Arrays.sort(num);
        System.out.println(Arrays.toString(num));

    }
}
