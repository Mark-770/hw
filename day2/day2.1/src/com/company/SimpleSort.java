package com.company;


public class SimpleSort {

    public static void main(String[] args) {
        int[] arr = {7, 4, 2, 66, 14};
        printArr(arr);
        simpleSort(arr);
        printArr(arr);

    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }

    private static void swap(int[] arr, int index1, int index2) {
        int tmd = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmd;
    }

    private static void simpleSort(int[] arr) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i - 1]) {
                    swap(arr, i, i - 1);
                    flag = true;
                }
            }
        }
    }
}

