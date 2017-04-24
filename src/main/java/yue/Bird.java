package yue;

/**
 * Created by caoyuncong on
 * 2017/4/8 15:30
 * over.
 */
public class Bird implements Animal {
    private String name;

    public Bird(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void eat() {
        System.out.println(name + "is eating.");
    }

    public void flying() {
        System.out.println(name + "is flying.");
    }
}
