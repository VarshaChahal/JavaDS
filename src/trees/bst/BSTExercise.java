package trees.bst;


public class BSTExercise {

    public static void main(String args[]){
        BasicBST bst = new BasicBST();
        bst.root = new BasicBST.Node(10);
      /*   bst.root.right = new BasicBST.Node(20);
        bst.root.left = new BasicBST.Node(9);
        bst.root.right.right = new BasicBST.Node(25);
        bst.root.right.left = new BasicBST.Node(17);
        bst.root.left.right = new BasicBST.Node(10);
        bst.root.left.left = new BasicBST.Node(8);
      */
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

        System.out.println("inorder traversal ");
        bst.inorder();

        System.out.println("\npreorder traversal ");
        bst.preOrder(); 

        System.out.println("\npostorder traversal ");
        bst.postOrder(); 

        System.out.println("\nheight of the tree before deletion "+bst.getHeight());
        System.out.println("size of the tree before deletion "+bst.size());

      System.out.println(bst.delete(18));
      System.out.println("root.right.left.left "+bst.root.right.left.left.value);
      System.out.println("height of the tree after deletion "+bst.getHeight());
      System.out.println("size of the tree after deletion "+bst.size());
      
    }
}
