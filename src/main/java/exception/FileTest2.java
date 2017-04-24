package exception;

import java.io.*;
import java.util.ArrayList;

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
    public static void main(String[] args) {
        int max = 0;
        int min = 0;
        int sum = 0;
        int avg = 0;
        int[] ints = new int[5000];
        ArrayList<Integer> integers = new ArrayList<>();
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/exception/a.txt"));
                BufferedReader reader = new BufferedReader(new FileReader("src/main/java/exception/a.txt"))
        ) {
            for (int i = 0; i < 5000; i++) {
                int rnum = (int) Math.random() * 99990;
                System.out.println(rnum);
                writer.write(rnum);
                int num=reader.read();
                integers.add(num);
            }

            for (int i = 0; i < integers.size(); i++) {
                for (int j = i+1; j < ints.length; j++) {
                    if (ints[i] > ints[j]) {
                        max = ints[i];
                        min = ints[j];
                    } else {
                        max = ints[j];
                        min = ints[i];
                    }
                    sum += ints[i];

                }


            }
            System.out.println(max);
            System.out.println(min);
            System.out.println(avg/5000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
