package exception;


import java.io.*;

/**
 * Created by caoyuncong on
 * 2017/4/22 9:29
 * over.
 */
//编写一个程序,将Fibonacii数列的前20项写入一个随机访问文件raf.txt
//        然后从该文件中读出第2、4、6等偶数位置上的项并将它们依次写入另一个文件output.txt
//        （30 分）
public class FileTest3 {
    public static int get(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return get(n - 1) + get(n - 2);
        }
    }

    public static void main(String[] args) throws IOException {

        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/exception/raf.txt"));
                BufferedReader reader=new BufferedReader(new FileReader("src/main/java/exception/raf.txt"));
                BufferedWriter writer1 = new BufferedWriter(new FileWriter("src/main/java/exception/output.txt"));

        ) {
            for (int i = 1; i < 21; i++) {
                writer.write(get(i));
            }

            for (int i = 2; i < 21; i+=2) {
                writer1.write(reader.read());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
