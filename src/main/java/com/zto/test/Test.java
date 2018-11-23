package com.zto.test;

public class Test {

    public static void main(String[] args) {
        System.out.println(8 >>> 2);

        System.out.println(Math.ceil(0.1 + Math.floor(Math.random())));

        for (int i = 1; i <= 5; i++) {//定义行数为5
            for (int j = 1; j <= 5; j++) {//定义列数为5
                if (i == 1 || j == 1 || i == 5 || j == 5) {//如果符合条件为行数为1或5，列数为1或5的元素就打印*
                    System.out.print("* ");
                } else {
                    System.out.print(" ");//否则就打印空格
                }
            }
            System.out.println();
        }
        int num = 50;
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 3 == 0) {
                num++;

            }
        }
        Num(50, 0);

        System.out.println(num);
    }

    public static void Num(int num, int total) {
        if (num / 3 == 0) {
            System.out.println(total + num);
        } else {
            total = total + num - (num % 3);
            num = num / 3 + num % 3;

            Num(num, total);
        }
    }
}
