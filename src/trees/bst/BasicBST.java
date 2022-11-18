package trees.bst;

import java.util.*;
import java.lang.*;

public class BasicBST {
    public Node root;

    public static class Node{
        public Node left;
        public Node right;
        public int value;

        public Node(int value){
            this.left =  this.right = null;
            this.value = value;
        }
    }

    public Node insertNode(int value){
        return insertRec(value, this.root);
    }

    //How to handle duplicates, ignoring for now
    /*
     * Time complexity: O(logn)
     */
    public Node insertRec(int value, Node currNode){
        if(currNode == null){
            return new Node(value);
        }
        else if( value > currNode.value){
            currNode.right = insertRec(value, currNode.right);
        }
        else if( value < currNode.value){
            currNode.left = insertRec(value,currNode.left);
        }
        else if(value == currNode.value){
            return null;
        }

        return currNode;
    }

    /*
     * Time complexity: O(logn)
     */
    public Node search(int value){
            Node currentNode = this.root;
            while(true){
                if(currentNode == null){
                    return null;
                }
                if(value > currentNode.value 
                ){
                    currentNode = currentNode.right;
                }
                else if(value < currentNode.value ){
                    currentNode = currentNode.left;
                }
                else if(value == currentNode.value ){
                    return currentNode;
                }
        }   
    }

    /*
     * 3 cases:
     * 1. No children: delete the node directly
     * 2. one child: replace the node with the child node
     * 3. two children: replace the node with its inorder successor, i.e., the left most node in the right subtree
     */
    public Node deleteNode(int value){




        return null;
    }

    public Node deleteHelper(int value,Node current){


        return null;
    }


    /*
     * wrong implementation
     */
    public boolean delete(int value){
        Node currentNode = this.root;
        Node targetNode = search(value);
       // System.out.println("target node is "+targetNode.value);
        while(true){
            if(targetNode == null){
                return false;
            } else{
                Node parent = getParent(targetNode.value);
                    if(targetNode.right!=null && targetNode.left!=null){
                      Node leftMostNode = getLeftMostNode(targetNode.right);
                      System.out.println("leftmost node is "+leftMostNode.value);
                      leftMostNode.left = targetNode.left;
                        parent.right = targetNode.right;
                        System.out.println("target Node after replacement is "+  parent.right.value);
                        return true;
                    }else if(targetNode.left == null && targetNode.right!=null ){
                         parent.right = targetNode.right;
                        return true;     
                    }else if(targetNode.right==null && targetNode.left != null){
                        parent.left = targetNode.left;
                        return true;
                    }
                    
            }
        }
            
    }
  
    public Node getLeftMostNode(Node currNode){
        while(currNode!=null && currNode.left !=null){
            currNode=currNode.left;
        }
        return currNode;
    }

    public Node getParent(int value){
        return getParentHelper(value, this.root);
    }
    public Node getParentHelper(int value, Node currNode){
        if(currNode == null){ return null;}
        else{
            System.out.println("currentNode.right.value "+currNode.right.value);
         System.out.println("currNode.right is "+(currNode.right.value == value?"true":"false"));

        if( (currNode.left !=null && currNode.left.value == value) || (currNode.right!=null && currNode.right.value == value)){
            System.out.println("currNode for which child value matched is "+currNode.value);
            return currNode;
        }
         System.out.println("currNode here "+currNode.value);
            if(value > currNode.value ){
                currNode = getParentHelper(value,currNode.right);
            }
            else if(value<currNode.value){
                currNode = getParentHelper(value,currNode.left);
            }
            return currNode;

        }

        }

        /*
         * Time complexity: O(n)
         */
        public int getHeight(){
            return heightHelper(this.root);
        }
        public int heightHelper(Node curr){
            if(curr == null) return 0;
            return 1+Math.max(heightHelper(curr.left), heightHelper(curr.right));
        }

        public int size(){
            return sizeHelper(this.root);
        }
        public int sizeHelper(Node curr){
            if(curr == null) return 0;
            return 1+sizeHelper(curr.left)+sizeHelper(curr.right);
        }

        public void inorder(){
            inorderHelper(this.root);
        }
        public void inorderHelper(Node curr){
            if(curr==null) return;
            inorderHelper(curr.left);
            System.out.print(" "+curr.value);
            inorderHelper(curr.right);
        }

        public void preOrder(){
            preOrderHelper(this.root);
        }
        public void preOrderHelper(Node curr){
            if(curr == null) return;
            System.out.print(" "+curr.value);
            preOrderHelper(curr.left);
            preOrderHelper(curr.right);
        }

        public void postOrder(){
            postOrderHelper(this.root);
        }
        public void postOrderHelper(Node curr){
            if(curr == null) return;
            postOrderHelper(curr.left);
            postOrderHelper(curr.right);
            System.out.print(" "+curr.value);

        }
}