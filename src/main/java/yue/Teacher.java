package yue;

/**
 * Created by caoyuncong on
 * 2017/4/8 15:07
 * over.
 */
public class Teacher extends Human {
    private int daySarly;

    public Teacher(double basicSalry, int daySarly) {
        super(basicSalry);
        this.daySarly = daySarly;
    }

    @Override
    public double getSalry() {
        return getBasicSalry()+daySarly*300;
    }

    public int getDaySarly() {
        return daySarly;
    }
}
