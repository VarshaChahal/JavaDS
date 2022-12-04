package graphs;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.Map.Entry;

/*
 * UNDIRECTED GRAPH
 */
public class BasicGraph {
    private static Map<Integer,ArrayList<Integer>> adjList = new HashMap<Integer,ArrayList<Integer>>(); 

    public  class Vertex{
        String label;
        Vertex(String label){
            this.label=label;
        }
    }
 
    /*
     * Simply add the vertex to the map and assign it a new arrayList which will be used later to add edges
     */
    public void addVertex(int num){
        if(!adjList.containsKey(num))  this.adjList.put(num, new  ArrayList<Integer>());
        System.out.println("map sze "+this.adjList.size());
        System.out.println("map has the vertex "+this.adjList.containsKey(num));
        for(Entry<Integer,ArrayList<Integer>> entry : this.adjList.entrySet()){
            System.out.println("entry is "+entry.getKey() +" "+entry.getValue());
        }
    }
    
    public void addEdge(int v1, int v2){
         if(this.adjList.containsKey(v1)){
            (this.adjList.get(v1)).add(v2);
         }
         if(adjList.containsKey((v2))){
            (adjList.get(v2)).add(v1);
         }
    }

    public void removeEdge(int v1, int v2){
        ArrayList<Integer> v1List = this.adjList.get(v1);
        ArrayList<Integer> v2List = this.adjList.get(v2);

        if(v1List!=null && v1List.contains(v2)){
            //remove method below takes index, hence converting v2 to an object to remove that particular object and not anythng from the index v2
            v1List.remove(new Integer(v2));
        }
        if(v2List!=null && v2List.contains(v1)){
            v2List.remove(new Integer(v1));
        }

    }

    public void removeVertex(int v){
        ArrayList<Integer> vList = new ArrayList<Integer>();
        if(this.adjList.containsKey(v)){
            vList = this.adjList.remove(v);
        }
        for(int edge : vList){
            removeEdge(v, edge);
        }

    }

    public static void main(String[] args){
        BasicGraph graph = new BasicGraph();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);

        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(2,6);
        graph.addEdge(3,6);
        graph.addEdge(4,5);
        graph.addEdge(5,6);
        graph.addEdge(4,6);


        System.out.println("adj list for A after adding edge"+graph.adjList.get(1).size());
        System.out.println("adj list for A after removing edge"+graph.adjList.get(2).size());

        bfs(1);
        

    /*     System.out.println("recursive dfs");
        Set<Integer> dfsRecursiceResult = dfs(5,true);

        System.out.println("iterative dfs");
        Set<Integer> dfsIterativeResult = dfs(5,false); */


       // dfsResult.stream().forEach((el)-> {System.out.println(el);});
     //   graph.removeEdge(2,4);
    //   System.out.println("after removing edges"); 
       printGraph(graph);   
    }
    public static void printGraph(BasicGraph graph){
        graph.adjList.forEach((key,val)->{
            System.out.print(key +" -> ");
           val.stream().forEach((adjVal)->{
               System.out.print(adjVal +" ");
           });
           System.out.println();
      });
    }

    public static Set<Integer> dfs(int vertex, boolean recursive){
        /*
         * You can also use a simple array instead of a map, add each visited element into the list
         * and check if the element is visited by checking if it exists in the array
         */
        Map<Integer, Boolean> map = new HashMap<Integer,Boolean>();
        if(recursive) dfsRec(map,vertex );
        else dfsIterative(map, vertex);
        return map.keySet();
    }

    /*
     * if the vertex is not having an adjacency list, return 
     * add the vertex to the visited list and mark it as lisited
     * loop over the neighbors of vertex 
     *      if the neighbor is not visited
     *          call the dfs again on that neighbor of vertex
     */
    public static void dfsRec(Map map,int vertex){
        ArrayList<Integer> elAdjacencyList = adjList.get(vertex);

        if(elAdjacencyList == null || elAdjacencyList.isEmpty()){
            return;
        }
        map.put(vertex,true);
        //just printing the node marked visited above
        System.out.println(vertex);
        for(int ver: elAdjacencyList){
            if(map.get(ver) == null ||  (boolean)map.get(ver)!= true){
                dfsRec(map,ver);
            }
        }
    }

         /*
         * RESULT ORDER DIFFERENCE between Recursive DFS and Iterative DFS
         * you might get the result in different order from the dfs recursive and iterative algorithms
         * because in recursive you are calling again on the first element of the adjacent neighbors, visiting the first element in the list in each time
         * whereas in iterative approach, you are adding elements to the stack in the list order and they are visited by popping,
         *          hence the last element is chosen first
         * All in all, in recursive, first element among the neighbors list is visited first
         *             in iterative, last element among the neighbors list is visited first
         * The result is still in DFS.
         */


    /*
     * Use a stack, because we would like to go deeper onto the vertex we saw.
     * here, you add all neighbors to the stack and you can go deeper into the path only if you take out the children each time rather then the siblings
     * siblings are taken out when it is a queue.
     * When using a queue for the bfs, you are adding sibling together to queue, but since you are removing from the front of the queue, you encounter one sibling after the other and
     * the children for each node is added at the end of the queue, hence you visit the children later than the stack.
     */
    public static void dfsIterative(Map<Integer, Boolean> map,int vertex){
        Stack stack = new Stack();
        
        //take the vertext to start from and put it in the stack
        stack.push(vertex);

        //while the stack still has elements
        while(stack.size()>0){
                //pop the last element from the stack
                int element = (int)stack.pop();
                //if you have not visited this element before
                if(map.get(element) == null || map.get(element) !=true){
                    //mark this element visited by adding it to the map and setting its value to true
                    map.put(element,true);

                    //just printing the node marked visited above
                    System.out.println(element);

                    //add all the neighbors of this element to the stack; we could use a for loop to add manually
                    ArrayList<Integer> list = adjList.get(element);

                    /*
                     * you can revert the list to make the result look like the result from recursive dfs
                     * Refer to the comment named : RESULT ORDER DIFFERENCE 
                     */
                     //Collections.reverse(list);
                    stack.addAll(list);
                }
        }
    }

    public static Set<Integer> bfs(int vertex){
        System.out.println("doing a bfs");
        /*
         * You can also use a simple array instead of a map, add each visited element into the list
         * and check if the element is visited by checking if it exists in the array
         */
        Map<Integer,Boolean> resultMap= new HashMap<Integer,Boolean>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(vertex);

        while(queue.size() >0){
            int element = queue.remove();
            if(resultMap.get(element) == null || resultMap.get(element) != true){
                resultMap.put(element,true);
                System.out.println(element);
                queue.addAll(adjList.get(element));
            }
        }
        return resultMap.keySet();
    }

    }

   