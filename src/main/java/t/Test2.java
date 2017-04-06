package t;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/2/20.
 */

// 编写程序，接收用户输入的两个数据为上、下限，
// 然后输出上、下限之间的所有素数
// 素数是除了 1 和它本身外，不能被其他任何整数整除的自然数 （15 分）
public class Test2 {
    /**
     * 数据的下限
     */
    private static int min;

    /**
     * 数据的上限
     */
    private static int max;

    /**
     * 初始化数据shan上下限
     */
    private static void initMinMax() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入数据下限：");
        min = scanner.nextInt();

        System.out.println("请输入数据上限：");
        max = scanner.nextInt();
    }

    /**
     * 判断参数 i 是否是一个素数
     * @param i 要判断的数
     * @return @{code true} 是素数，否则@{code false}
     */
    private static boolean isPrime(int i) {
        for (int j = 2; j < i / 2 + 1; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 输出上下限之间的所有素数
     */
    private static void getPrimes() {
        for (int i = min + 1; i < max; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        initMinMax();
        getPrimes();
    }
}
