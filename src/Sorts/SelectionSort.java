package Sorts;

import java.util.Arrays;

public class SelectionSort {
    
    public static void main(String[] args){
        SelectionSort ss = new SelectionSort();
        int[] arr = new int[]{19,44,38,5,47,15};
        ss.selectionSort(arr);
        Arrays.stream(arr).forEach((element)->{
            System.out.println(element);
        });
    }
    /**
     * iterate over the array and find the minimum element. swap it with the element where you started from
     * @param arr
     */
    public void selectionSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int smallest = arr[i];
            int smallestIndex = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<smallest){
                        smallest = arr[j];
                        smallestIndex = j;
                    }
            }
            if(i!=smallestIndex){
            swap(arr,i,smallestIndex);
            }
        }
    }

    public void swap(int[] arr, int first,int second){
        int firstValue = arr[first];
        int secondValue = arr[second];

        arr[first]=secondValue;
        arr[second]=firstValue;
    }
}
