package yue;

/**
 * Created by caoyuncong on
 * 2017/4/8 14:55
 * over.
 */
public abstract class Human {
    private double basicSalry;

    public Human(double basicSalry) {
        this.basicSalry = basicSalry;
    }

    public double getBasicSalry() {
        return basicSalry;
    }

    public abstract double getSalry();

}
