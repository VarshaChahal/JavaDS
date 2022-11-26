package Sorts;

import java.util.Arrays;

public class QuickSort{

    public void quickSort(int[] arr){
        this.quickSortHelper(arr, 0, arr.length-1);
    }

    public void quickSortHelper(int[] arr, int start, int end){
        if(start>=end){
           // System.out.println("ooooo");
           return;
        }
            int pivotIndex = pivotHelper2(arr, start, end);
            quickSortHelper(arr, start,pivotIndex-1);
            quickSortHelper(arr, pivotIndex,end);
 
    }
    
    /**
     * In this algorithm we are going to move the pivot element to it's correct positon
     * Using the first element as pivot
     * keep track of a pointer, that we called pi(pivotIndex). 
     * Loop throught the array and if an element is smaller than the pivot, increment the pivot index, and swap the current element withthe element at pivot index.
     * This will ensure that all the elements smaller than the pivot move to left side of the array and all the elements greater than the pivot move to the right side.
     * When the loop ends, you pivot index holds the last element in the array that is smaller than pivot and we swap the pivot element with the element at pivot index.
     * Following these steps will result in the pivot element being in the right place in the array compare to all the other elements.
     * When we break the array into furher parts, we rach a point where there is only one element in the array(which is sorted anyway), 
     *  and quick sort uses this fact to sort all the elements.
     * @param arr
     * @param start
     * @param end
     */
    public int pivotHelper(int[] arr, int start, int end){
        int pivot  = arr[start];
        //pivot index, to keep track of where the pivot element should end up making it in the right spot.
        int pi = start;

        int i=start+1;
        while(i<=end){
            if(arr[i]<pivot){
                pi++;
                if(pi!=i){
                    swap(arr,i,pi);
                }
            }
            i++;
        }
        swap(arr,start,pi);
        return pi;
    }

    /**
     * another approach to return the pivot index
     * Here we select a random element to be the pivot, move the elements smaller than pivot to the left side of the pivot and elements greater to the right side of the pivot
     * 
     * @param arr
     * @param start
     * @param end
     */
    public int pivotHelper2(int[] arr, int start, int end){

        int pivot = arr[(start+end)/2];

        int left=start, right= end;

        while(left<=right){
            while(arr[left]<pivot){
                left++;
            }
            while(arr[right]>pivot){
                right--;
            }
            if(left<=right){
                swap(arr,left,right);
                left++;
                right--;
            }

        }
        return left;

    }

    public void swap(int[] arr, int first,int second){
        int firstValue = arr[first];
        int secondValue = arr[second];

        arr[first]=secondValue;
        arr[second]=firstValue;
    }

    public static void main(String[] args){
        QuickSort qs = new QuickSort();

        int[] arr = new int[]{4,8,2,1,5,-7,6,3};
       // qs.swap(arr,0,3);

      // System.out.println("arr[0]"+arr[0]);
       // System.out.println("arr[3]"+arr[3]);

        qs.quickSort(arr);

        Arrays.stream(arr).forEach((element)->{
            System.out.println(element);
        });

    }
}