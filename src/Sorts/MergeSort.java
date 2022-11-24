package Sorts;

import java.util.Arrays;

public class MergeSort {
    

    public static void main(String[] args){
        MergeSort mergeSort=  new MergeSort();

        int[] arr1 = new int[]{17};
        int[] arr2 = new int[]{85,20,6,9};

       /*  Arrays.stream(mergeSort.mergeHelper(arr1,arr2)).forEach((element) ->{
            System.out.println(element);
        });; */

        mergeSort.mergeSort(arr2);

        Arrays.stream(mergeSort.mergeSort(arr2)).forEach((element) ->{
            System.out.println(element);
        });; 

    }

    /**
     * Break the array into two halves until you have 0 or 1 elements in it
     * once you have the smaller arrays, merge those arrays with other sorted arrays until you get back the full length of the array
     * once it has been merged back together, return the merged(sorted) array.
     */

    public int[] mergeSort(int[] arr){
       // if(arr.length ==1) return;
       if(arr.length <=1) return arr;
        int mid = (int)Math.floor(arr.length/2);
      
        //int[] left = Arrays.copyOfRange(arr,0,mid);
        //int[] right = Arrays.copyOfRange(arr,mid,arr.length);
        // return mergeHelper(left,right);
       return  mergeHelper(mergeSort(Arrays.copyOfRange(arr,0,mid)),mergeSort(Arrays.copyOfRange(arr,mid,arr.length)));
    }

    public int[] mergeHelper(int[] arr1, int[] arr2){
        int[] result = new int[arr1.length+arr2.length];
        
        int i=0, j=0;
        while(i < arr1.length && j< arr2.length){
            if(arr1[i]<arr2[j]){
                result[i+j]=arr1[i];
                i++;
            }
            else if(arr1[i]>arr2[j]){
                result[i+j]=arr2[j];
                j++;
            }
            else{
                //when both the items are equal, add both to the result in any order and increment both the pointers
                result[i+j] = arr1[i];
                result[i+j+1] = arr2[j];
                i++;
                j++;
            }
        }
        /**
         * we broke out of the previous loop as soon as one of the arrays hit the end,
         * hence if there are extra items in any of the arrays whose end was not reached, we just add all the remaining items from that array into the result
         */
        while(i<arr1.length){
            result[i+j]=arr1[i];
            i++;
        }
        while(j<arr2.length){
            result[i+j]=arr2[j];
            j++;
        }

        return result;

    }
}
