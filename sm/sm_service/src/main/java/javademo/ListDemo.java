package javademo;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {
        listdemo1();
    }

    public static void listdemo1(){
        List<String> list = new ArrayList();
        list.add("Java");
        list.add("C");
        list.add("C++");
        list.add("GO");
        list.add("swift");
        System.out.println(list.size());
        System.out.println("-------------------");
        for (int i = 0; i<list.size(); i++){
            System.out.println(list.get(i));
        }

        int[][] a = {{123,424},{43453,54354,87}};
        System.out.println("增强型for循环 数组a");
        for (int[] element:a){
            System.out.print(element               +"\t");
        }
        System.out.println("增强型for循环 数组a");



        System.out.println("增强型for循环");
        for (String haha:list){
            System.out.print(haha+"\t");
        }
        System.out.println("增强型for循环");


        list.remove(2);
        for (int i = 0; i<list.size(); i++){
            System.out.print(list.get(i)+"\t");
        }
        System.out.println();

        list.remove("GO");
        for (int i = 0; i<list.size(); i++){
            System.out.print(list.get(i)+"\t");
        }
    }
}
