package cao;

import java.util.Scanner;

/**
 * Created by cao on
 * 2017/4/1 13:46
 * over.
 */
// 从键盘上输入 4 行 4 列的一个实数矩阵到一个二维数组中,
// 然后求出主对角线（从左上角到右下角）上元素之和以及副对角线上元素之乘积
public class E1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input:");
        int n = scanner.nextInt();

        int[] m = new int[4];
        int[] j = new int[4];

        for (int i = 0; i < m.length; i++) {
            for (int k = 0; k < j.length; k++) {
                System.out.print(n);
            }
            System.out.println();
        }


    }
}
