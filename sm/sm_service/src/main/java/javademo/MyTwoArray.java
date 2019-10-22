package javademo;

import java.util.Arrays;

public class MyTwoArray {

    public static void main(String[] args) {
        int[][] arr = {{3, 2, 23, 2132}, {231, 41}, {341, 43, 4}, {543, 43, 43}, {45, 543, 343, 4, 434}};
        int[] arr2 = {3, 2, 23, 2132, 231};
        myArray(arr);
        System.out.println("-------------------");

        myArraySort(arr2);
        System.out.println(Arrays.toString(arr2));

        System.out.println("-------------------");
        yanghuiSanjiao();

        System.out.println("-------------------");
        bijiao();

        System.out.println("-------------------");
        shuixianhua();
    }

    public static void myArray(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void myArraySort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j =0; j<arr.length-i-1; j++){
                int temp = 0;
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    public static void yanghuiSanjiao(){

        int n =10;
        int[][] arr = new int[n][n];

        for (int i=0; i<arr.length; i++){
            arr[i][0]=1;
            arr[i][i]=1;
            if (i>1){
                for (int j =1; j<i; j++){
                    arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
                }
            }
        }

        for (int i=0; i<arr.length; i++){
            for (int j=0; j<=i; j++){
                System.out.printf("%4d",arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void bijiao(){
        String str1 = new String("java");
        String str2 = new String("java");
        StringBuffer stringBuffer = new StringBuffer("java");
        System.out.println(str1==str2);
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(stringBuffer));

    }

    public static void shuixianhua(){
        for (int i=100;i<1000;i++){
            int a = i/10;
            int b = i%100/10;
            int c = i/100;
            if(i==a*a*a+b*b*b+c*c*c){
                System.out.println(i);
            }
        }
    }
}
