package yue;

/**
 * Created by caoyuncong on
 * 2017/4/8 15:02
 * over.
 */
public class Worker extends Human{

    public Worker(double basicSalry) {
        super(basicSalry);
    }

    @Override
    public double getSalry() {
        return getBasicSalry();
    }
}
