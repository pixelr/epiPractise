package com.company;

import java.net.Inet4Address;
import java.util.*;

public class topKelement {
    public static List<Integer> topElements(int[] nums,int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        });

        for(int a:nums){
            priorityQueue.add(a);
            if(priorityQueue.size()>k){
                priorityQueue.poll();
            }
        }
        return new ArrayList<>(priorityQueue);
    }

    public static class Pair{
        public int x,y;
    }
    public static List<Integer> topKFrequentElement(int[] nums,int k){
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int a: nums){
            map.put(a,map.getOrDefault(a,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue
                = new PriorityQueue<>((a,b)-> Integer.compare(b.getValue(),a.getValue()));

        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            priorityQueue.add(e);
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        while(arrayList.size()<k){
            arrayList.add(priorityQueue.poll().getKey());
        }
        return arrayList;
    }

    public static void main(String[] args){
        topKFrequentElement(new int[]{1,1,2,2,1,3},2)
                .stream().forEach(System.out::println);
    }
}
