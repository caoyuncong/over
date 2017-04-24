package yue;

import java.util.Vector;

/**
 * Created by caoyuncong on
 * 2017/4/8 14:06
 * over.
 */
public class ArrayTest {
    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 0, 0, 6, 6, 0, 5, 4, 7, 6, 7, 0, 5};
        Vector<Integer> integers = new Vector<>();
        for (int i = 0; i < a.length; i++) {
            int i1 = a[i];
            if (i1 != 0) {
                integers.add(i1);
            }
        }

        System.out.println(integers);
    }
}
