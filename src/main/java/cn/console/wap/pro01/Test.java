package cn.console.wap.pro01;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Set<Integer> nums = new HashSet<Integer>();
        nums.add(1);
        nums.add(1);
        nums.add(3);
        for(int num:nums)
        System.out.println(num);
    }
}
