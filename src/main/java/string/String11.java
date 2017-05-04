package string;

/**
 * Created by caoyuncong on
 * 2017/4/28 9:13
 * over.
 */
public class String11 {
    private static int counter;

    public static void main(String[] args) {
        String s1 = "1,3,5,6,7,8";
        String s2 = "2,4,1,7,5";
        if (s1.length() > s2.length()) {
            String temp = s2;
            s2 = s1;
            s1 = temp;
        }
        String[] strings1 = s1.split(",");
        String[] strings2 = s2.split(",");
        for (String s : strings1) {
            for (String s3 : strings2) {
                if (!s.equals(s3)) {
                    counter++;
                    break;
                }
            }
        }
        System.out.println(counter);
    }
}
