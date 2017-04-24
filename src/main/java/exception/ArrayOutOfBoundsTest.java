package exception;

/**
 * Created by caoyuncong on
 * 2017/4/22 8:55
 * over.
 */
// 编写一个没有处理的发生数组下标越界异常的程序
public class ArrayOutOfBoundsTest {
    public static void main(String[] args) {
        String[] s = {"he", "1", "2", "3"};
        System.out.println(Integer.valueOf(s[4]));
    }
}
