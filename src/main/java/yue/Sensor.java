package yue;

/**
 * Created by caoyuncong on
 * 2017/4/8 15:09
 * over.
 */
public class Sensor extends Human{
    private int yearEndSalry;

    public Sensor(double basicSalry, int yearEndSalry) {
        super(basicSalry);
        this.yearEndSalry = yearEndSalry;
    }

    @Override
    public double getSalry() {
        return getBasicSalry()+yearEndSalry;
    }

    public int getYearEndSalry() {
        return yearEndSalry;
    }
}
