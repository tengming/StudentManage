package javademo.fanshe;

public class Lizongchun {
    static String name = "李宗纯";

    String sex;
    int age;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Lizongchun.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public  void chiShi(){
        System.out.println("我爱吃屎");
    }
}
