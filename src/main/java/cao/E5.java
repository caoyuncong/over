package cao;

import java.util.Vector;

/**
 * Created by cao on
 * 2017/4/1 14:15
 * over.
 */
// 定义一个方法，实现数组的转置输出
// 例如： 源数组，1 2 3 4 5 6 转置之后的数组，6 5 4 3 2 1
public class E5 {
    private static int[] ints = {1, 2, 3, 4, 5, 6};
    private static Vector<String> strings = new Vector<>();

    public static void main(String[] args) {

        for (int anInt : ints) {
            String s = String.valueOf(anInt);
//            System.out.println(s);
            strings.add(s);
        }

        Integer integer = Integer.valueOf(revrse());
        Vector<Integer> integers = new Vector<>();
        for (Integer integer1 : integers) {
            integers.addElement(integer);
        }


    }

    public static String revrse() {
        for (int i = ints.length - 1; i >= 0; i--) {
            System.out.println(strings.get(i));
        }
        return "";
    }

}
