package zong;

import java.io.*;
import java.util.Scanner;

/**
 * Created by caoyuncong on
 * 2017/5/6 15:21
 * over.
 */
// 用输入/输出写一个程序,让用户输入一些姓名和电话号码。
// 每一个姓名和号码将加在文件 里。
// 用户通过点”Done”按钮来告诉系统整个列表已输入完毕。
// 如果用户输入完整个列表, 程序将创建一个输出文件并显示或打印出来。格式如:
//Tom
//        123-456-7890
//        Jerry
//        987-654-3210
public class IOTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入姓名，电话：");
        String s = scanner.nextLine();
//        try (
//                BufferedReader reader = new BufferedReader(new FileReader(IMAGE_ADDRESS));
//                BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/zong/test.txt"))
//        ) {
//            while ((s == reader.read()) != null) {
//                writer.write(s);
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
}
