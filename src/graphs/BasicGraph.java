package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

/*
 * UNDIRECTED GRAPH
 */
public class BasicGraph {
    private Map<String,ArrayList<String>> adjList = new HashMap<String,ArrayList<String>>(); 

    public  class Vertex{
        String label;
        Vertex(String label){
            this.label=label;
        }
    }

    /*
     * Simply add the vertex to the map and assign it a new arrayList which will be used later to add edges
     */
    public void addVertex(String str){
        if(!adjList.containsKey(str))  this.adjList.put(str, new  ArrayList<String>());
        System.out.println("map sze "+this.adjList.size());
        System.out.println("map has A"+this.adjList.containsKey("A"));
        System.out.println("map has the vertex "+this.adjList.containsKey(str));
        for(Entry<String,ArrayList<String>> entry : this.adjList.entrySet()){
            System.out.println("entry is "+entry.getKey() +" "+entry.getValue());
        }
    }
    
    public void addEdge(String v1, String v2){
         if(this.adjList.containsKey(v1)){
            (this.adjList.get(v1)).add(v2);
         }
         if(adjList.containsKey((v2))){
            (adjList.get(v2)).add(v1);
         }
    }

    public void removeEdge(String v1, String v2){
        ArrayList<String> v1List = this.adjList.get(v1);
        ArrayList<String> v2List = this.adjList.get(v2);

        if(v1List!=null && v1List.contains(v2)){
            v1List.remove(v2);
        }
        if(v2List!=null && v2List.contains(v1)){
            v1List.remove(v1);
        }

    }

    public void removeVertex(String v){
        ArrayList<String> vList = new ArrayList<String>();
        if(this.adjList.containsKey(v)){
            vList = this.adjList.remove(v);
        }
        for(String edge : vList){
            removeEdge(v, edge);
        }

    }

    public static void main(String[] args){
        BasicGraph graph = new BasicGraph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A","B");
        System.out.println("adj list for A after adding edge"+graph.adjList.get("A").size());
        graph.removeEdge("A","B");
        System.out.println("adj list for A after removing edge"+graph.adjList.get("A").size());

    
    }

    }

   