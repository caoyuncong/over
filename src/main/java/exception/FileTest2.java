package exception;

import java.io.*;
import java.util.*;

/**
 * Created by caoyuncong on
 * 2017/4/22 9:18
 * over.
 */
//编写一个程序实现以下功能:
//        (1)产生5000个1~9999之间的随机整数,将其存入文本文件a.txt中
//        (2)从文件中读取这5000个整数,并计算其最大值、最小值和平均值并输出结果。
//        （25 分）
public class FileTest2 {
    private static final int N = 5000;

    public static void main(String[] args) {
        int sum = 0;
        int min = 9998;
        int max = 2;
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new TreeSet<>();
        try (
                RandomAccessFile raf = new RandomAccessFile("a.txt", "rw")
        ) {
            for (int i = 0; i < N; i++) {
                int r = (int) (Math.random() * 9997) + 2;
                raf.writeInt(r);
            }
            raf.seek(0);
            for (int i = 0; i < N; i++) {
                int r = raf.readInt();
                list.add(r);
                set.add(r);
                if (r < min) {
                    min = r;
                }
                if (r > max) {
                    max = r;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(min + ":" + max);

        System.out.println(Collections.min(list) + ":" + Collections.max(list));
        System.out.println(sum / N);
        List<Integer> integers = new ArrayList<>(set);
        System.out.println(integers.get(0) + ":" + integers.add(integers.size() - 1));
    }
}
