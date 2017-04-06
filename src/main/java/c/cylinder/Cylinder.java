package c.cylinder;

import c.circle.Circle;

/**
 * Created by Administrator on 2017/2/18.
 */
// Cylinder.java 文件，在该文件中定义圆柱体类 Cylinder，该类口在 c.cylinder 包中，继承圆类
// 域：圆柱体高度 height
// 方法：构造方法；求表面积方法 area；求体积方法 volume
public class Cylinder extends Circle {

    /**
     * 圆柱体的高
     */
    private double height;

    /**
     * 构造方法
     *
     * @param radius 圆半径
     * @param height 圆柱高
     */
    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    /**
     * 求圆柱体表面积
     *
     * @return 表面积
     */
    @Override
    public double area() {
        return super.area() * 2 + super.perimeter() * height;
    }

    /**
     * 求圆柱体体积
     *
     * @return 体积
     */
    public double volume() {
        return super.area() * height;
    }

}
