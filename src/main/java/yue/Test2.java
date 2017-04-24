package yue;

/**
 * Created by caoyuncong on
 * 2017/4/8 15:33
 * over.
 */
public class Test2 {
    public static void main(String[] args) {
        Bird bird = new Bird("HuangLi");
        bird.eat();
        bird.flying();
        Fish fish = new Fish("ShaYu");
        fish.eat();
        fish.swimming();
    }
}
