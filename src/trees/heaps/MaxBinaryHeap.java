package trees.heaps;

import java.util.LinkedList;
import java.lang.Math;

public class MaxBinaryHeap {
    LinkedList<Integer> list = new LinkedList<>();

    /*
     * Approach: add to the end, bubble up
     */
    public int insert(int value) {
        /*
         * add value to the end of list
         * while the parent of value in list is smaller than the value, swap the value
         * with the parent
         */
        list.add(value);

            int index = list.size() - 1;
            int element = list.get(index);
        while(true){
            int parentInd = (int) Math.floor((index - 1) / 2);
            int parent =  list.get(parentInd);
            if(element > parent){
                list.set(parentInd, value);
                list.set(index, parent);
                index = parentInd;
            }
            else break;
        }
            return index;
    }
    

}
