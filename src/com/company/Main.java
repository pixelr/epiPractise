package com.company;

public class Main {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void moveZeroes(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        while (s < e) {
            if (nums[s] != nums[e] && nums[s] == 0) {
                swap(nums, s, e);
                e--;
            } else {
                s++;
            }
        }
    }

    public static void moveZe(int[] nums){
        int itr =0 ;
        int lwr = -1;
        int end = nums.length-1;
        while( itr < end){
            lwr++;
            while (nums[itr]==0) itr++;
            nums[lwr]= nums[itr];

        }
        while (lwr<end){
            nums[lwr] =0;
        }
    }

    public static void main(String[] args) {
        // write your code here
        int[] num = {0,1,0,3,12};
        moveZe(num);
    }
}
