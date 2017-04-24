package yue;

/**
 * Created by caoyuncong on
 * 2017/4/8 15:04
 * over.
 */
public class Farmer extends Human{

    public Farmer(double basicSalry) {
        super(basicSalry);
    }

    @Override
    public double getSalry() {
        return getBasicSalry();
    }
}
