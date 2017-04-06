package cao;

import java.util.Vector;

/**
 * Created by cao on
 * 2017/4/1 14:15
 * over.
 */
// 将如下两个数组中重复的元素存入一个新的数组（20 分）
//[89,90,77,87,66,54,328,890,99]
//        [65,72,12,77,2,96,54,27,89]

public class E4 {
    public static void main(String[] args) {
        int[] ints = {89, 90, 77, 87, 66, 54, 328, 890, 99};
        int[] ints1 = {65, 72, 12, 77, 2, 96, 54, 27, 89};
        Vector<String> strings = new Vector<>();
        Vector<String> strings1 = new Vector<>();
        Vector<Integer> integer = new Vector<>();

        for (int anInt : ints) {
            String s = String.valueOf(anInt);
            strings.add(s);
        }

        for (int i : ints1) {
            String s1 = String.valueOf(i);
            strings1.add(s1);
        }

        System.out.println();
        for (int i = 0; i < ints1.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                if (strings.get(j).equals(strings1.get(i))) {
                    String s = strings.get(j);
                    integer.add(Integer.valueOf(s));
                }
            }
        }
        System.out.println(integer);


    }
}
