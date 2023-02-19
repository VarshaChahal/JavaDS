package stacks_queues;

public class Stack {
    Node first;
    Node last;
    int size;
    public Stack(){
        this.first =null;
        this.last=null;
        this.size=0;

    }

    public int push(Node node){
            if(this.first==null){
                this.first=node;
                this.last=node;
            }else{
                this.last.next=node;
                this.last=node;
            }
            return ++this.size;
    }

    public int pop(){
        int removedValue=-1;
        if(this.first.value==this.last.value){
            removedValue=this.first.value;
            this.first=this.last=null;
           // this.size=0;
        }
        else{
            Node current=this.first;
            Node prev=null;
            while(current.next!=null){
                prev=current;
                current=current.next;
            }
            removedValue=current.value;
            this.last=prev;
            this.last.next=null;
        }
        this.size--;

        return removedValue;
    }

    public void printStack(){
        Node current = this.first;

        while(current!=null){
            System.out.println("Stack entry: "+current.value);
            current=current.next;
        }
    }

    public static void main(String args[]){
        Stack stack = new Stack();
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        System.out.println(stack.size);
        stack.push(node1);
        stack.push(node2);
        stack.push(node3); 
        System.out.println(stack.pop());
        stack.push(node4);
        stack.push(new Node(5));

        stack.printStack();

    }
}

class Node{
    int value;
    Node next;
    public Node(int value){
        this.value=value;
        this.next=null;
    }
}
