package javademo.zhujie;

public class ChouxiangDemo extends Chouxiang implements Ijiekou1{

    private  String s="空";

    public void hhehe(){
       String s1 = this.s;
       String s2 = super.s;

       System.out.println(s1);
       System.out.println(s2);
    }

//    @Override
    public void haha() {
        System.out.println("子类哈哈方法");
    }

    public static void main(String[] args) {
        Chouxiang chouxiang = (ChouxiangDemo) new ChouxiangDemo();
        chouxiang.haha();
    }
}
