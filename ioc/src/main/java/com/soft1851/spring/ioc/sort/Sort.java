package com.soft1851.spring.ioc.sort;

/**
 * @author Zeng
 * @ClassName Sort
 * @Description TOOD
 * @Date 2020/3/10
 * @Version 1.0
 **/
public class Sort {
    public void sort() {
        int[] nums = {3, 2, 6, 34, 56, 33, 0};
        int temp;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j+1] = temp;
                }
            }
        }

        for (int a : nums) {
            System.out.println(a);
        }
    }
}
