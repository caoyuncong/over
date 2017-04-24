package exception;

/**
 * Created by caoyuncong on
 * 2017/4/22 9:00
 * over.
 */
// 编写一个正确处理的产生空指针异常的程序
public class NullPointerTest {
    public static void main(String[] args) {
        try {
            String s = "hello";
            s = null;
            System.out.println(s.length());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
