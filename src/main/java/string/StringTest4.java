package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by caoyuncong on
 * 2017/4/15 9:24
 * over.
 */

// 输入一段字符串，字符串中只包含大小写字母。
// 要求完成函数删除给定字符串中出现次数最少的字符。
// 输出删除完的字符串。如果有多个出现次数一样的字符，都为最少时，一并删除。
//例如：输入:abbccd，输出为bbcc

public class StringTest4 {
    public static void main(String[] args) {
        System.out.println(getMinString("abbccd"));
    }

    public static String getMinString(String input) {
        System.out.println("原字符串--->" + input);
        char[] c = input.toCharArray();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < c.length; i++) {
            list.add(c[i] + "");
        }
        // 求出字母出现的最小次数（不能对list排序，会影响最后输出结果）
        int minTime = 0;
        int[] count = new int[list.size()];
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    count[i]++;
                }
            }
            minTime = count[1]; // 把第一个字母出现的次数初始为最小次数
            System.out.println("====="+minTime);
            if (minTime >= count[i]) {
                minTime = count[i];
            }

        }
        System.out.println("每个下标的字母对应的出现次数--->" + Arrays.toString(count));
        System.out.println("字母出现的最小次数--->" + minTime);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < count.length; i++) {
            if (count[i] > minTime) {
                sb.append(list.get(i));
            }
        }
        return sb.toString();
    }
}
