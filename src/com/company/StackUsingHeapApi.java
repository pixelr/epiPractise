package com.company;

import java.util.PriorityQueue;

public class StackUsingHeapApi {
    public static class ValueRank{
        int val,rank;

        ValueRank(int val, int rank) {
            this.val = val;
            this.rank = rank;
        }
    }
    private int timestamp=0;
    private PriorityQueue<ValueRank> heap = new PriorityQueue<>((b,a)-> Integer.compare(a.rank,b.rank));
    public void push(int x){
        heap.add(new ValueRank(x,timestamp++));
    }
    public int pop(){
        return heap.poll().val;
    }
    public int peek(){
        return heap.peek().val;
    }
    public boolean isEmpty(){
        return heap.isEmpty();
    }
    public static void main(String[] args){
        StackUsingHeapApi stackUsingHeapApi = new StackUsingHeapApi();
        stackUsingHeapApi.push(1);
        stackUsingHeapApi.push(2);
        stackUsingHeapApi.push(3);
        while (!stackUsingHeapApi.isEmpty()){
            System.out.print(stackUsingHeapApi.pop()+", ");
        }
        System.out.print(stackUsingHeapApi.pop()+", ");
    }
}
