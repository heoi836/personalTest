package com.zto.test;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.cglib.beans.BeanCopier;

import java.util.*;
import java.util.stream.Stream;

public class Test2 {


    public static void main(String[] args) {
        User1 user1 = new User1();
        user1.setAge(11);
        user1.setName("zs");
        user1.setHabit("girl");
        user1.setLegth("170");
        User2 user2 = new User2();
        BeanCopier beanCopier = BeanCopier.create(user1.getClass(), user2.getClass(), false);
        beanCopier.copy(user1,user2,null);
        System.out.println(user1);
        System.out.println(user2);


    }
}

@Setter@Getter@ToString
class User1 {
    String name;
    int age;
    String habit;
    String legth;

}

@Setter@Getter@ToString
class User2 {
    String name;
    int age;
}