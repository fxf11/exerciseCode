package com.fxf.sortAlgorithm;

import org.junit.Test;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/8/15 22:29
 */
public class BubbleSort {

    private int[] array = {11,23,34,64,42,62,91,31};

    /**
     * 冒泡排序
     */
    @Test
    public void bubbleSort(){

        int t = 0;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1; j++) {
                if (array[j] > array[j+1]){
                    t = array[j];
                    array[j] = array[j+1];
                    array[j+1] = t;
                }
            }
        }
        for (int i : array) {
            System.out.print(i+" ");
        }
//        System.out.println();
    }

    /**
     * 直接插入排序
     */
    @Test
    public void insertionSort(){
//        for (int i = 0; i < array.length; i++) {
//            for (int j = i; j  > 0; j--) {
//                if (array[j] < array[j-1]){
//                    int temp = array[j-1];
//                    array[j-1] = array[j];
//                    array[j] = temp;
//                }
//            }
//        }


        for (int i = 0; i < array.length; i++) {

            int j = i;
            int target = array[i];

            while (j > 0 && target < array[j-1]){
                array[j] = array[j-1];
                j--;
            }

            array[j] = target;

        }
        for (int i : array) {
            System.out.print(i+" ");
        }
    }


}
