public class l003_avl{
    public static void main(final String[] args) {
        solve();
    }

    public static class Node{
        int data = 0;
        Node left = null;
        Node right = null;
        int height = 0;
        int bal = 0;
        Node(int data){
            this.data = data;
        }
    }

    public static void display(Node node){
        if(node==null) return;
        StringBuilder sb = new StringBuilder();
        
        sb.append(node.left!=null?node.left.data+"" : ".");
        sb.append(" <- " + node.data + " -> ");
        sb.append(node.right!=null?node.right.data+"" : ".");

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);
    }

    public static void UpdateHeightandBalance(Node node){
        int lh = -1;
        int rh = -1;
        if(node.left!=null) lh = node.left.height;
        if(node.right!=null) rh = node.right.height;
        int height = Math.max(lh,rh)+1;
        int bal = lh-rh;
        node.height =height;
        node.bal = bal;
    }

    public static Node rr(Node A){
        Node B = A.left;
        Node Bright = B.right;
        B.right = A;
        A.left = Bright;
        UpdateHeightandBalance(A);
        UpdateHeightandBalance(B);
        return B;  
    }

    public static Node lr(Node A){
        Node B = A.right;
        Node Bleft = B.left;
        B.left = A;
        A.right = Bleft;
        UpdateHeightandBalance(A);
        UpdateHeightandBalance(B);
        return B;  
    }

    public static Node getRotation(Node node){
        UpdateHeightandBalance(node);
        if(node.bal==2){
            if(node.left.bal==1){ //ll
                return rr(node);
            }
            else{ //lr
                node.left = lr(node.left);
                return rr(node);
            }
        }
        else if(node.bal==-2){
            if(node.right.bal==-1){ //rr
                return lr(node);
            }
            else{ //rl
                node.right = rr(node.right);
                return lr(node);
            }
        }
        return node;
    }

    public static Node addNode(Node node,int data){
        if(node==null) return new Node(data);
        if(data<node.data) node.left = addNode(node.left, data);
        else if(data>node.data) node.right = addNode(node.right,data);
        node = getRotation(node);
        return node;
    }

    public static int minimum(Node node){
        Node curr = node;
        while(curr.left!=null){
            curr =curr.left;
        }
        return curr.data;
    }

    public static Node removeNode(Node node,int data){
        if(node == null) return null;
        if(data<node.data) node.left = removeNode(node.left, data);
        else if(data>node.data) node.right = removeNode(node.right, data);
        else{
            if(node.left==null ||  node.right==null) return node.left!=null?node.left:node.right;
            int minEle = minimum(node.right);
            node.right = removeNode(node.right, minEle);
        }
        node = getRotation(node);
        return node;
    }

    public static void solve(){
        Node root = null;

        for(int i=1;i<=18;i++) {
           root = addNode(root,i*10);
           display(root);

           System.out.println("=================================================");
        }
        for(int i=1;i<=18;i++) {
            root = removeNode(root,i*10);
            display(root);
 
            System.out.println("=================================================");
         }
        // int a[]={2,1,15};
        // int i = ++a[1];
        // int j = a[1]++;
        // int m = a[i++];
        // System.out.println(i+" "+j+" "+m);
        // System.out.println(a[1]);
        // int i = 0;
        // i++;
        // System.out.println(i++);
        // System.out.println(++i);
    }

}