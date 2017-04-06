package c.circle;

import c.shape.Shape;

/**
 * Created by Administrator on 2017/2/18.
 */
// exam.Circle.java 文件，在该文件中定义圆类 exam.Circle，该类在 c.circle 包中，实现 Shape 接口
// 域：圆半径 radius
// 方法：构造方法；实现接口中求面积方法 area；求周长方法 perimeter
public class Circle implements Shape {
    /**
     * 圆半径
     */
    private double radius;
    /*
    *构造方法
     *
      * @param radius 圆半径
    * */

    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * 求圆的面积
     *
     * @return 面积
     */
//    @Override
    public double area() {
        return Shape.PI * radius * radius;
    }

    /*求圆的周长
    * @return 周长
    * */
    public double perimeter() {
        return 2 * Shape.PI * radius;
    }

}
