public class Queue{
    private int[] arr;
    private int size;
    private int head;
    private int tail;
    private int maxsize;

    protected void push_(int val){
        arr[++this.tos] = val;
        this.size++;
    }

    public Queue(){
        setvalues(10);
    }

    public Queue(int n){
        setvalues(n);
    }

    protected void setvalues(int n){
        this.size = 0;
        this.maxsize = n;
        this.arr = new int[n];
        this.head = 0;
        this.tail = 0;
    }

    public void push(int val) throws Exception{
        if(this.size==this.maxsize){
            throw new Exception("Stack is Full");
        }
        push_(val);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = this.tos;i>=0;i--){
            sb.append(arr[i]);
            if(i!=0) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    public int size(){
        return this.size;
    }

    public int capacity(){
        return this.maxsize;
    }

    public boolean isEmpty(){
        return this.size==0;
    }

    protected int top_(){
        return this.arr[this.tos];
    }

    public int top() throws Exception{
        if(this.size==0){
            throw new Exception("Stack is Empty");
        }
        return top_();
    }

    protected int pop_(){
        int rv = top_();
        this.arr[this.tos--] = 0;
        this.size--;
        return rv;
    }

    public int pop() throws Exception{
        if(this.size==0){
            throw new Exception("Stack is Empty");
        }
       return pop_();
    }

}