package com.zto.demo;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class JsonToString {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("952718120501");
        list.add("952718120502");
        System.out.println(JSON.toJSONString(list));
    }
}
