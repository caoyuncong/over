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
        try (RandomAccessFile raf = new RandomAccessFile("raf.txt", "rw")) {
            for (int i = 0; i < 20; i++) {
                raf.writeInt(get(i+1));
            }
            raf.seek(0);
            for (int i = 0; i < 10; i++) {
                raf.readInt();
                try (RandomAccessFile file = new RandomAccessFile("output.txt", "rw")) {
                    int r = raf.readInt();
                    System.out.println(r);
                    file.writeInt(r);
                }
            }
        }
    }
}
