package Sorts;

import java.util.Arrays;
public class InsertionSort{

    public static void main(String args[]){
        int[] arr = new int[]{42,12,43,18,19,47,21,14};
        InsertionSort is = new InsertionSort();
        is.insertionSort(arr);
        Arrays.stream(arr).forEach((element)->{
            System.out.println(element);
        });;
    }

    /**
     * For each element in the array, move the element to its right position on the left side of the array i.e., 
     *          look on the left side of the array from current position
     *          find a position where your element will fit
     *          from this position, move all the elements right until the current element's position.
     * @param arr
     */
    public void insertionSort(int[] arr){
        //iterate over the entire array
        for(int i=0;i<arr.length;i++){
            int temp = arr[i];
            //iterate from the i-1 down to 0
            int j=i-1;
            while(j>=0 && arr[j]>temp){
                arr[j+1]=arr[j];
                j--;
            }
                arr[j+1]=temp;           
        }
    }

}