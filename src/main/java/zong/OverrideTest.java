package zong;

import yue.Bird;

/**
 * Created by caoyuncong on
 * 2017/5/6 14:34
 * over.
 */
// 编写一个实现方法重载的程序
public class OverrideTest {
    private String name;
    public OverrideTest() {
    }

    public OverrideTest(String name) {
        this.name = name;
    }

    public void fly(String name) {
        System.out.println(name+" is flying.");

    }

    public void swim(int i,String name) {
        System.out.println(i +name+" are swimming.");
    }

    public static void main(String[] args) {
        OverrideTest overrideTest = new OverrideTest();
        overrideTest.swim(4,"ducks");

        OverrideTest overrideTest1 = new OverrideTest("bird");
        overrideTest.fly("Bird");
    }
}
