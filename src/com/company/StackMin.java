package com.company;

import java.util.LinkedList;

public class StackMin {

    /** initialize your data structure here. */
    LinkedList<Integer> stack;
    LinkedList<Integer> minstack;
    private int x,y,i,h;

    public StackMin(int x, int y, int i, int h) {
        this.x = x;
        this.y = y;
        this.i = i;
        this.h = h;
        stack = new LinkedList<Integer>();
        minstack = new LinkedList<Integer>();

    }

    public void push(int x) {
        stack.offerLast(x);
        if(minstack.isEmpty()){
            minstack.offerLast(x);
            return;
        }
        minstack.offerLast(Math.min(minstack.peekLast(),Integer.valueOf(x)));
    }

    public void pop() {
        minstack.pollLast();
        stack.pollLast();
    }

    public int top() {
        return stack.peekLast();
    }

    public int getMin() {
        return minstack.peekLast();
    }

    public static void main(String[] args){
        StackMin stackMin1 = new StackMin(1, 2, 3, 4);
        stackMin1.push(2);
        stackMin1.push(0);
        stackMin1.push(3);
        stackMin1.push(0);
        System.out.println(stackMin1.getMin());
        stackMin1.pop();
        System.out.println(stackMin1.getMin());
        stackMin1.pop();
        System.out.println(stackMin1.getMin());
        stackMin1.pop();
        System.out.println(stackMin1.getMin());
    }
}
