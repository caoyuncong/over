package yue;

/**
 * Created by caoyuncong on
 * 2017/4/8 15:09
 * over.
 */
public class Clerk extends Human{
    public Clerk(double basicSalry) {
        super(basicSalry);
    }

    @Override
    public double getSalry() {
        return getBasicSalry();
    }
}
