package LinkedLists;

public class SinglyLinkedList {
    Node head;
    int length;
    Node tail;

    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    /*
     * add an element at the end of the list
     */
    public SinglyLinkedList add(int value) {
        Node newNode = new Node(value);
        /*
         * if you do not have the tail, you will have to travrese the whole linked list
         * to reach the end
         */
        /*
         * if(node != null){
         * 
         * while(node.next!=null){
         * node = node.next;
         * }
         * node.next = newNode;
         * this.tail = newNode;
         * this.length++;
         * return true;
         * }else{
         * this.head = this.tail = newNode;
         * this.tail = newNode;
         * this.length++;
         * return true;
         * }
         */

        /*
         * It is difficult to traverse the entire linked list to add a new item if there
         * are millions of items in the list
         * Hence, if you are taking care of the tail, no need to traverse the entire
         * list, just add the new node to the tail.next
         *
         */

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            this.length++;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
            this.length++;
        }
        return this;
    }

    /**
     * insert a node value at a specific location
     * @param position
     * @param value
     * @return
     */
    public boolean insert(int position, int value){
        Node currNode = this.head;
        int count =0;
       
        if (position < 0 || position > this.length)
        return false;

        if(position ==0){
            unshift(value);
            return true;
        }
        if(position == this.length){
            Node newNode = new Node(value);
            this.tail.next =newNode;
            this.tail = newNode;
        }

        Node prev=null;
        while (currNode.next != null) {
            
            if (count == position) {
                Node newNode = new Node(value);
                prev.next =newNode;
                newNode.next = currNode;
                return true;

            } else {
                prev = currNode;
                currNode = currNode.next;
                count++;
            }
        }
        return false;
    }

    /**
     * adds an element to the beginning of the list, i.e., add a new head
     * 
     * @return
     */
    public Node unshift(int value) {
        if (this.head == null) {
            this.head = this.tail = new Node(value);
            this.length++;
        } else {
            Node currHead = this.head;
            this.head = new Node(value);
            this.head.next = currHead;
            this.length++;
        }
        return this.head;
    }
    
    /**
     * Update a node value at a specific location
     * @param position
     * @param value
     * @return
     */
    public int set(int position, int value){
        Node currNode = this.head;
        int count = 0;
        if (position < 0 || position > this.length)
            return -1;
        while (currNode != null) {
            if (count == position) {
                currNode.value = value;
                return currNode.value;
            } else {
                currNode = currNode.next;
                count++;
            }
        }
        return -1;
    }

    /**
     * Get a method by its position in the linked list
     * 
     * @return
     */
    public int get(int position) {
        Node currNode = this.head;
        int count = 0;
        if (position < 0 || position > this.length)
            return -1;
        while (currNode != null) {
            if (count == position) {
                return currNode.value;
            } else {
                currNode = currNode.next;
                count++;
            }
        }
        return -1;
    }

    /**
     * Removes and returns the tail of the list
     * 
     * @return
     */
    public Node pop() {
        Node currNode = this.head;
        Node removedNode= null;
        if (currNode == null) {
            return null;
        } else {
            Node preNode = null;
            while (currNode.next != null) {
                preNode = currNode;
                currNode = currNode.next;
            }
            removedNode = preNode.next;
            preNode.next = null;
            this.tail = preNode;
            this.length--;
        }
        return removedNode;
    }

    /**
     * Remove and return the head of the list
     * 
     * @return
     */
    public Node poll() {
        if (this.head != null) {
            Node head = this.head;
            this.head = this.head.next;
            return head;
        }
        return null;
    }

    /**
     * remove and return any element from the list
     * 
     * @param value
     * @return
     */
    public Node remove(int value) {
        /*
         * cases:
         * if the node to remove is the head
         * if the node to remove is the tail
         * if the node to remove lies in the middle
         */
        Node currNode = this.head;
        if (currNode == null) {
            return this.poll();
        } else if (this.head.value == value) {
            Node headToReturn = this.head;
            this.head = this.head.next;
            return headToReturn;
        } else if (this.tail.value == value) {
            return this.pop();
        } else {
            while (currNode.next != null) {
                if (currNode.next.value == value) {
                    Node nodeToReturn = currNode.next;
                    currNode.next = currNode.next.next;
                    this.length--;
                    return nodeToReturn;
                }else{
                    currNode = currNode.next;
                }
            }
        }
        return null;
    }

    public void printLinkedList() {
        Node node = this.head;
        if (node != null) {
            while (node != null) {
                System.out.print(node.value + " -> ");
                node = node.next;
            }
        }
        System.out.println();
    }

    public void reverse(){
      //  reverseHelper(this.head);
          iterativeReverse();
    }

    public void iterativeReverse(){
        /**
         * Add condition to check if head is null
         */
        Node prev = null;
        Node curr = this.head;
        this.head=this.tail;
        Node next = null;

        while(curr!=null){
            //save the next element as we are going to break the link between current and next by assigning the next of current to be previous
            next = curr.next;
            curr.next = prev;
            //make the current element as previous and the next element as current as we move on
            prev = curr;
            curr = next;
        }

    }

    /**
     * recursive approach to return a linked list
     * the idea here is to move from the second last node to the first node, where each node is removed from its position and moved to the end of the list
     * thise approach requires additional operations like removing a node, which uses iteration over the list.
     * @param currNode
     */
    public void reverseHelper(Node currNode){
        if(currNode.next == null){
            return;
        }
        reverseHelper(currNode.next);
        System.out.println("node here "+currNode.value);
        Node node = remove(currNode.value);
        add(node.value);
        //return currNode;

    }


    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.add(77);
        linkedList.add(5);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(6);

        System.out.println(linkedList.add(0).head.value);
        // System.out.println("popped the tail "+linkedList.pop());
        // System.out.println("tail here is "+linkedList.tail.value);

        // System.out.println("removing value "+linkedList.remove(5));
        // System.out.println(linkedList.poll());
        // System.out.println(linkedList.poll());

        System.out.println("adding new head " + linkedList.unshift(99).value);
        System.out.println("adding new head " + linkedList.unshift(1099).value);
        linkedList.add(55);
        linkedList.printLinkedList();
        System.out.println("getting the node at certain position " + linkedList.set(5,8864));
        linkedList.printLinkedList();
        System.out.println("getting the node at certain position " + linkedList.get(5));

        System.out.println("adding a node at a certain position "+linkedList.insert(linkedList.length,617));
        linkedList.printLinkedList();


        System.out.println("going to reverse the list ");
        linkedList.reverse();
        System.out.println();

        linkedList.printLinkedList();


    }
}