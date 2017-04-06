package c.shape;

/**
 * Created by Administrator on 2017/2/18.
 */
// Shape.java文件，在该文件中定义接口 Shape，该接口在 c.shape 包中
// 域：PI
// 方法：求面积的方法 area
public interface Shape {
    /**
     * 圆周率 PI
     */
    public static final double PI=Math.PI;
    /**
     * 求面积的方法
     * @return 面积
     */
    public double area();
}
