package com.company;

import java.util.Map;

public class MappOf {
    public  static void main(String[] args){
        Map<String,Integer> map = Map.of("ama",1,"jama",2);
        map.keySet().stream().forEach(System.out::println);
    }
}
