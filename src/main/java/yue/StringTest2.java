package yue;

/**
 * Created by caoyuncong on
 * 2017/4/8 14:19
 * over.
 */
public class StringTest2 {
    public static void main(String[] args) {
        String s = "Hello World";

        String[] strings = s.split("\\s", 2);
        for (String string : strings) {
            System.out.println(string);
        }

        System.out.println(strings[0].toUpperCase());
        System.out.println(strings[1].toLowerCase());


        String s2 = "20100110";
        System.out.println(s2.substring(0, 4) + "年" + s2.substring(5, 6) + "月" + s2.substring(6, 8) + "日");



    }
}
