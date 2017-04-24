package exception;

import java.io.*;

/**
 * Created by caoyuncong on
 * 2017/4/22 9:06
 * over.
 */
//编写一个程序,其功能是将两个文件的内容合并到一个文件中
//        例如：1.txt 内容为 abc；2.txt 内容为 def；生成新文件3.txt 内容为 abcdef
//        （20 分
public class FileTest {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader("src/main/java/exception/1.txt"));
                BufferedReader reader1 = new BufferedReader(new FileReader("src/main/java/exception/2.txt"));
                BufferedWriter writer=new BufferedWriter(new FileWriter("src/main/java/exception/3.txt"))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.print(line);
                writer.write(line);
            }
            String line1;
            while ((line1 = reader1.readLine()) != null) {
                System.out.print(line1);
                writer.write(line1);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
