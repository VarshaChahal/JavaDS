package stacks_queues;

class EnhancedStack {
    Node first;
    Node last;
    int size;
    public EnhancedStack(){
        this.first =null;
        this.last=null;
        this.size=0;

    }
    
    /**
     * adding nodes to the beginning
     * @param node
     * @return
     */
    public int push(Node node){
            if(this.first==null){
                this.first=node;
                this.last=node;
            }else{
                Node temp = this.first;
                this.first=node;
                this.first.next=temp;
            }
            return ++this.size;
    }
    /**
     * Removing nodes from the beginning, requires only a pointer change at first element
     * @return
     */
    public int pop(){
        int removedValue=-1;
        removedValue=this.first.value;

        if(this.first.value==this.last.value){
            this.first=this.last=null;
           // this.size=0;
        }
        else{
            this.first=this.first.next;
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
        EnhancedStack stack = new EnhancedStack();
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        System.out.println(stack.size);
        stack.push(node1);
        stack.push(node2);
        stack.push(node3); 
        stack.push(node4);
        System.out.println(stack.pop());

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
