package Sorts;

import java.util.Arrays;

public class BubbleSort {
    
    /**
     * iterate over every element of the array,
     * while you do that, within the inner loop we keep swapping the elements until the biggest element is bubbled up until the end.
     * since the last element is ensure to be the biggest one after completing the inner loop each time, we iterate in the inner loop only until the elements that are not 
     *  sorted, hence we only go until (array.length-i-1) elements in each inner loop.
     * We can also maintain a boolean variable to handle the case where the array is nearly sorted. In this case, we will be iterating almost for nothing.
     *  hence you break out of the swapping as soon as you find that there were no swaps made in the last loop, which tells you that it is sorted already.
     * @param arr
     */
    public void bubbleSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            boolean swapped = false;
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    swapped=true;
                }            
            }
            if(!swapped){
                break;
            }
        }
        
    }

    public void swap(int[] arr, int first,int second){
        int firstValue = arr[first];
        int secondValue = arr[second];

        arr[first]=secondValue;
        arr[second]=firstValue;
    }

    public static void main(String[] args){
        BubbleSort bs = new BubbleSort();
        int[] arr = new int[]{4,8,2,1,5,-7,6,3};

        bs.bubbleSort(arr);

        Arrays.stream(arr).forEach((element)->{
            System.out.println(element);
        });
    }
}
