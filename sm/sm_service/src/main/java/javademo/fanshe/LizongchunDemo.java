package javademo.fanshe;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LizongchunDemo {

    public static void main(String[] args) {
        Lizongchun lizongchun = new Lizongchun();
        Class c = lizongchun.getClass();
        try {
            Method m = c.getMethod("chiShi");
            try {
                m.invoke(lizongchun);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
