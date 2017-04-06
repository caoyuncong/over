package exam;

/**
 * Created by Administrator on 2017/3/18.
 */
class Student extends Person{
    private String sno;

    public Student(String name, char gender, int age, String sno) {
        super(name, gender, age);
        this.sno = sno;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

}
