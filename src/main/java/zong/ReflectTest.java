package zong;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by caoyuncong on
 * 2017/5/6 14:54
 * over.
 */
// 使用反射机制获取 java.lang.String 类的所有域、构造方法、成员方法
public class ReflectTest {
    public static void main(String[] args) {
        Class clazz = String.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
