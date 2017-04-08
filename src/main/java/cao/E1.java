package cao;

import java.util.Arrays;
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
        int[][] ints = new int[4][4];
        int sum = 0;
        int mul = 1;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.println("input:");
                ints[i][j] = scanner.nextInt();
                if (i == j) {
                    sum += ints[i][j];
                }
                if (i + j == ints.length - 1) {
                    mul *= ints[i][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(ints));
        System.out.println(sum);
        System.out.println(mul);
        }
    }

