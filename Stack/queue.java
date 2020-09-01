public class queue{
    private int[] arr;
    private int size;
    private int head;
    private int tail;
    private int maxsize;

    private void push_(int val){
        arr[++this.tos] = val;
        this.size++;
    }

    public stack(){
        setvalues(10);
    }

    public stack(int n){
        setvalues(n);
    }

    protected void setvalues(int n){
        this.size = 0;
        this.maxsize = n;
        this.arr = new int[n];
        this.head = 0;
        this.tail = 0;
    }

    public int capacity(){
        return this.maxsize;
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
        return this.size();
    }

    public boolean isEmpty(){
        return this.size==0;
    }

    public int top() throws Exception{
        if(this.size==0){
            throw new Exception("Stack is Empty");
        }
        return arr[this.tos];
    }

    private void pop_(){
        arr[tos--] = 0;
    }

    public void pop() throws Exception{
        if(this.size==0){
            throw new Exception("Stack is Empty");
        }
        pop_();
    }

}