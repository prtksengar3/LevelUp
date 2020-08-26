public class linkedlist{
    private class Node{
        int data = 0;
        Node next = null;
        Node(int data){
            this.data = data;
        }
    }

    Node head = null;
    Node tail = null;
    int size = 0;

    public int Size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    @Override
    public String toString(){
        Node curr = this.head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(curr!=null){
            sb.append(curr.data);
            if(curr.next!=null) sb.append(",");
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }

    private void addFirstNode(Node node){
        if(this.size==0){
            this.head = node;
            this.tail = node;
        }else{
            node.next = this.head;
            this.head = node;
        }
        this.size++;
    }

    public void addFirst(int data){
        Node node = new Node(data);
        addFirstNode(node);
    }

    private void addLastNode(Node node){
        if(this.size==0){
            this.head = node;
            this.tail = node;
        }else{
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }

    public void addLast(int data){
        Node node = new Node(data);
        addLastNode(node);
    }

    private void addNodeAt(int idx,Node node){
        if(idx==0){
            addFirstNode(node);
        }
        else if(idx==this.size){
            addLastNode(node);
        }
        else{
            Node prev = getNodeAt(idx-1);
            Node succ = prev.next;
            prev.next = node;
            node.next = succ;
            this.size++;
        }
    }

    public void addAt(int idx,int data) throws Exception{
        if(idx<0 || idx >this.size){
            throw new Exception("Null Pointer");
        }
        Node node = new Node(data);
        addNodeAt(idx,node);
    }

    private Node RemoveFirstNode(){
        Node rnode = this.head;
        if(this.size==1){
            this.head = null;
            this.tail = null;
        }else{
            this.head = this.head.next;
            rnode.next = null;
        }
        this.size--;
        return rnode; 
    }

    public int RemoveFirst() throws Exception{
        if(this.size==0){
            throw new Exception("List is Empty");
        }
        Node rnode = RemoveFirstNode();
        return rnode.data; 
    }    

    private Node RemoveLastNode(){
        Node rnode = this.tail;
        if(this.size==1){
            this.head = null;
            this.tail = null;
        }else{
            Node slnode = getNodeAt(this.size-2);
            slnode.next=null;
            this.tail = slnode;
        }
        this.size--;
        return rnode;
    }

    public int RemoveLast() throws Exception{
        if(this.size==0){
            throw new Exception("List is Empty");
        }
        Node rnode = RemoveLastNode();
        return rnode.data; 
    }    

    private Node removeNodeAt(int idx){
        if(idx==0){
            return RemoveFirstNode();
        }
        else if(idx==this.size-1){
           return RemoveLastNode();
        }
        else{
            Node prev = getNodeAt(idx-1);
            Node rnode = prev.next;
            prev.next = rnode.next;
            rnode.next = null;
            this.size--;
            return rnode;
        }
    }

    public int removeAt(int idx) throws Exception{
        if(idx<0 || idx >this.size){
            throw new Exception("Null Pointer");
        }
        Node rnode = removeNodeAt(idx);
        return rnode.data;
    }

    public int getFirst() throws Exception{
        if(this.size==0){
            throw new Exception("List is Empty");
        }
        return this.head.data;
    }

    public int getLast() throws Exception{
        if(this.size==0){
            throw new Exception("List is Empty");
        }
        return this.tail.data;
    }

    private Node getNodeAt(int idx){
        Node curr = this.head;
        while(idx-->0){
            curr = curr.next;
        }
        return curr;
    }
    
    public int getAt(int idx) throws Exception{
        if(idx < 0 || idx >=this.size){
            throw new Exception("Null Pointer");
        }
        return getNodeAt(idx).data;
    }

}