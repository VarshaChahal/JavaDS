package trees;

import java.util.*;

import trees.bst.BasicBST;

public class BFS {


    public static void main(String args[]){
    
        BasicBST bst = new BasicBST();
        bst.root = new BasicBST.Node(10);
        bst.insertNode(18);
        bst.insertNode(14);
        bst.insertNode(22);
        bst.insertNode(16);
        bst.insertNode(20);
        BasicBST.Node node24 = bst.insertNode(24);
        bst.insertNode(13);
        bst.insertNode(5);
        bst.insertNode(7);
        bst.insertNode(2);

        LinkedList bfsResult = bfs(bst);
        bfsResult.stream().forEach((element)-> {System.out.println(element);});
    }

    public static LinkedList bfs(BasicBST bst){
        
        Queue<BasicBST.Node> queue = new LinkedList<>();
        LinkedList<Integer> visited= new LinkedList<>();

        if(bst.root != null){
            queue.add(bst.root);
        }
        while(queue.size() > 0){
            BasicBST.Node curr = queue.remove();
            visited.add(curr.value);
            if(curr.left!=null){
                queue.add(curr.left);
            }
            if(curr.right!=null){
                queue.add(curr.right);
            }
        }
        return visited;

    }
}
