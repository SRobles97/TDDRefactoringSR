package com.mycompany.generala;

public class Dice {
    private int[] nums;

    public Dice(int num1, int num2, int num3, int num4, int num5){
        nums = new int[5];
        nums[0] = num1;
        nums[1] = num2;
        nums[2] = num3;
        nums[3] = num4;
        nums[4] = num5;
    }

    public int[] getNums(){
        return nums;
    }

}
