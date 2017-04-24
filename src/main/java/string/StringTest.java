package string;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by caoyuncong on
 * 2017/4/15 8:44
 * over.
 */
//输入字符串长度len1，字符串s1，字符串长度len2，字符串s2。从后向前比较，以最短字符串为标准，输出不同的元素的个数。
//例如:
//        输入：s1=”1,3,5” len1=3 s2=”2,4,1,7,5” len2=5
//        输出：1
public class StringTest {

    public static void main(String[] args) {

        String s1 = "1,3,5";
        String s2 = "2,4,1,7,5";
        int len1 = 3;
        int len2 = 5;

        System.out.println(getDiffNum(len1, s1, len2, s2));

    }

    public static int getDiffNum(int len1, String s1, int len2, String s2) {
        int count = 0;
        int len = 0;
        String[] arr1 = s1.split(",");
        String[] arr2 = s2.split(",");
        if (len1 > len2) {
            len = len2;
        } else {
            len = len1;
        }
        for (int i = 0; i < len; i++) {
            if (!arr1[len1 - i - 1].equals(arr2[len2 - i - 1])) {
                count++;
            }
        }
        return count;
    }

}
