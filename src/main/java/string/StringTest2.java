package string;

import java.util.*;

/**
 * Created by caoyuncong on
 * 2017/4/15 8:45
 * over.
 */
// 找出字符串中出现次数最多的字母和出现的次数
public class StringTest2 {

    public static void main(String[] args) {
        String s1 = "sheepmusheepmummmm";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            list.add(s1.charAt(i) + "");
        }

        System.out.println("排序前的list--->" + list);// 排序前的list--->[s, h, e, e, p, m, u, s, h, e, e, p, m, u, m, m, m, m]
        Collections.sort(list);
        System.out.println("排序后的list--->" + list);// 排序后的list--->[e, e, e, e, h, h, m, m, m, m, m, m, p, p, s, s, u, u]
        int[] count = new int[list.size()];
        for (int i = 0; i < count.length; i++) {
            count[i] = 1;
        }

        System.out.println("初始定义每个字母出现的次数count--->" + Arrays.toString(count));
        //list可以直接打印出来；但数组不行！打印数组的方法！！不然会[I@4a9a1ac

        for (int j = 0; j < list.size(); j++) {
            for (int k = j + 1; k < list.size(); k++) {
                if (list.get(j).equals(list.get(k))) {
                    count[j]++;
                    list.remove(k);
                    k--;
                }

            }
        }

        System.out.println("循环后的list---->" + list); //循环后的list--->[e, h, m, p, s, u]
        System.out.println("list变化后每个字母出现的次数count--->"+Arrays.toString(count));
        //因为数组长度这儿没有变化，所以后面还是保留了原本为每个字母定义的数量1

        int maxTimes = count[0]; //比较数组里面的最大值!
        String maxStr = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (maxTimes < count[i]) {
                maxTimes = count[i];
                maxStr = list.get(i);
            }
        }
        System.out.println("出现次数最多的字母：" + maxStr + "出现次数" + maxTimes);
    }
}
