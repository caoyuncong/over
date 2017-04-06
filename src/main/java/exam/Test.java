package exam;

/**
 * Created by Administrator on 2017/3/18.
 */
public class Test {
    public static void main(String[] args) {
        Student s1 = new Student("Mary", '男', 28, "2017666");
        Student s2 = new Student("Jerry", '女', 43, "2017449");
        System.out.println("学号：" + s1.getSno()+"\t" + "姓名：" + s1.getName() +"\t"+ "性别：" + s1.getGender()+"\t" + "年龄：" + s1.getAge()+"\t");
        System.out.println("学号：" + s2.getSno()+"\t" + "姓名：" + s2.getName() +"\t"+ "性别：" + s2.getGender()+"\t" + "年龄：" + s2.getAge()+"\t");
    }
}
