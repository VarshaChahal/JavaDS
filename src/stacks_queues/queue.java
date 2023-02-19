package stacks_queues;

class Queue {
    Node first;
    Node last;
    int size;

    public Queue(){
        this.first=null;
        this.last=null;
        this.size=0;
    }

    class Node{
        int value;
        Node next;
        public Node(int value){
            this.value=value;
            this.next=null;
        }
    }

    public int enqueue(int value){
        Node node = new Node(value);
        if(this.first==null){
            this.first=node;
            this.last=node;
        }else{
            this.last.next=node;
            this.last=node;
        }
        return ++this.size;
    }

    public int dequeue(){
        int removedValue=-1;
        removedValue=this.first.value;

        if(this.first==this.last){
            this.first=null;
            this.last=null;
        }else this.first=this.first.next;
        this.size--;

        return removedValue;
    }

    public void printQueue(){
        Node current = this.first;

        while(current!=null){
            System.out.println("Queue entry: "+current.value);
            current=current.next;
        }
    }

    public static void main(String args[]){
        Queue queue = new Queue();

        System.out.println(queue.size);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3); 
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.enqueue(4);
        queue.enqueue(5);

        queue.printQueue();
    }
}

