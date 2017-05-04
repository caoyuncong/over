package string;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by caoyuncong on
 * 2017/4/28 10:24
 * over.
 */
public class String22 {
    public static void main(String[] args) {
        String s = "aabbbbccccccdeffffff";

        Hashtable<Character, Integer> hashtable = new Hashtable<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hashtable.put(c, hashtable.get(c) == null ? 1 : hashtable.get(c) + 1);
        }

        int max = Collections.max(hashtable.values());

        System.out.println(max);

        for (Map.Entry<Character, Integer> entry : hashtable.entrySet()) {
            if (max == entry.getValue()) {
                System.out.println(entry.getKey());
            }
        }

    }
}
