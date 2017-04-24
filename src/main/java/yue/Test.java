package yue;

/**
 * Created by caoyuncong on
 * 2017/4/8 15:20
 * over.
 */
public class Test {
    public static void main(String[] args) {
        Worker worker = new Worker(20000);
        System.out.println(worker.getSalry());

        Farmer farmer = new Farmer(15000);
        System.out.println(worker.getSalry());

        Clerk clerk = new Clerk(30000);
        System.out.println(worker.getSalry());

        Sensor sensor = new Sensor(100000, 900000);
        System.out.println(worker.getSalry());

        Teacher teacher = new Teacher(80000, 600);
        System.out.println(teacher.getSalry());
    }

}
