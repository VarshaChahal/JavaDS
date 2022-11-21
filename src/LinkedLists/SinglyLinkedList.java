package LinkedLists;

public class SinglyLinkedList{
    Node head;
    int length;
    Node tail;
    public static class Node{
        int value;
        Node next;

        public Node(int value){
            this.value =value;
            this.next = null;
        }
    }

    public SinglyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length=0;
    }

    public SinglyLinkedList add(int value){
        Node newNode = new Node(value);
        /*
         * if you do not have the tail, you will have to travese the whole linked list to reach the end
         */
            /*
             if(node != null){
           
            while(node.next!=null){
                node = node.next;
            }
            node.next = newNode;
            this.tail = newNode;
            this.length++;
            return true;
            }else{
            this.head = this.tail = newNode;
            this.tail = newNode;
            this.length++;
            return true;
        }
             */

         /*
             * It is difficult to traverse the entire linked list to add a new item if there are millions of items in the list
             * Hence, if you are taking care of the tail, no need to traverse the entire list, just add the new node to the tail.next
             *
             */

             if(this.head == null){
                this.head = newNode;
                this.tail = newNode;
                this.length++;      
             }
             else{
                this.tail.next = newNode;
                this.tail = newNode;
                this.length++;
             }
             return this;       
    }

    public int pop(){
        Node currNode = this.head;
        int removedNodeValue = -1;
        if(currNode == null){
            return -1;
        }
        else{
            Node preNode =null;
             while(currNode.next!=null){
                preNode = currNode;
                currNode = currNode.next;
             }
             removedNodeValue =  preNode.next.value;
             preNode.next = null;
             this.tail= preNode;
             this.length--;
        }
        return removedNodeValue;
    }

    public int poll(){
        if(this.head!=null){
            int headValue = this.head.value;
            this.head = this.head.next;
            return headValue;
        }
        return -1;
    }
    
    public int remove(int value){
        /*
         * cases: 
         * if the node to remove is the head
         * if the node to remove is the tail
         * if the node to remove lies in the middle
         */
        Node currNode = this.head;
        if(currNode == null){
            return this.poll();
        }
        else if(this.head.value == value){
            this.head = this.head.next;
            return value;
        }
        else if(this.tail.value == value){
           return this.pop();
        }
        else{
            while(currNode.next!=null){
                if(currNode.next.value == value){
                    int valueToReturn = currNode.next.value;
                    currNode.next = currNode.next.next;
                    this.length--;
                    return valueToReturn;
                }
            }
        }
        return -1;
    }

    public void printLinkedList(){
        Node node = this.head;
        if(node !=null){
            while(node!=null){
                System.out.print(node.value +" -> ");
                node = node.next;
            }
        }
    }
    public static void main(String[] args){
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.add(77);
        linkedList.add(5);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(6);

        System.out.println(linkedList.add(0).head.value);
       // System.out.println("popped the tail "+linkedList.pop());
       //System.out.println("tail here is "+linkedList.tail.value);

       // System.out.println("removing value "+linkedList.remove(5));
       System.out.println(linkedList.poll());
       System.out.println(linkedList.poll());

        linkedList.printLinkedList();


    }
}