import java.util.*;
public class l001{

    public static void main(String[] args) {
        solve();
    }

    public static class Node{
        int data=0;
        Node left=null;
        Node right=null;
        Node(int data){
            this.data = data;
        }
    }
    static int idx = 0;
    public static Node constructTree(int[] arr){
        if(idx == arr.length || arr[idx]==-1){
            idx++;
            return null;
        }
        Node node = new Node(arr[idx++]);
        node.left = constructTree(arr);
        node.right = constructTree(arr); 
        return node;
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

    public static void width(Node node,int[] minmax,int level){
        if(node == null) return;
        minmax[0] = Math.min(minmax[0], level);
        minmax[1] = Math.max(minmax[1],level);
        width(node.left,minmax,level-1);
        width(node.right, minmax, level+1);
        return;
    }

    public static int size(Node node){
        if(node == null) return 0;
        int ls = size(node.left);
        int rs = size(node.right);
        return ls+rs+1;
    }

    public static int height(Node node){
        if(node==null){
            return -1; //-1 for edges, 0 for nodes
        }
        int lh = height(node.left);
        int rh = height(node.right);
        return Math.max(lh,rh)+1;
    }

    // public static List<List<Integer> topview(Node node,int[minmax],int level){
        
    // }

    static int maxlevel = -1;

    public static int leftview(Node node,int level){
        if(node == null) return -1;
        if(level>maxlevel) 
        {
            System.out.println(node.data);
            maxlevel = level;
        }
        int lh = leftview(node.left,level+1);
        int rh = leftview(node.right,level+1);
        return lh;
    }

    public static int topview(Node node,int level,HashMap<Integer,Integer> hm){
        if(node == null) return -1;
        if(!hm.containsKey(level)){
            // System.out.println(node.data);
            hm.put(level, node.data);
        }
        int lh = topview(node.left, level-1,hm);
        int rh = topview(node.right, level+1,hm);
        return rh;
    }

    public static class allPair{
        int height = 0;
        int size = 0;
        boolean find = false;
        int ceil = (int)1e8;
        int floor = -(int)1e8;
        Node pred = null,succ =null,prev = null;
    }

    public static void allPairSolutions(Node node,int level,int data,allPair pair){
        if(node == null) return;
        pair.size++;
        pair.height = Math.max(pair.height,level);
        pair.find = pair.find || node.data==data;
        if(node.data > data) pair.ceil=Math.min(pair.ceil,node.data);
        if(node.data < data) pair.floor = Math.max(pair.floor,node.data);
        if(node.data == data) pair.pred = pair.prev;
        if(pair.prev!=null && pair.prev.data == data) pair.succ = node;
        pair.prev = node;
        allPairSolutions(node.left,level+1,data,pair);
        allPairSolutions(node.right,level+1,data,pair);
    }

    public static void solve(){
        // int[] arr={50,25,12,-1,-1,37,30,-1,-1,-1,75,62,-1,70,-1,-1,87,-1,-1};
        int[] arr={10,20,40,-1,-1,50,80,-1,-1,90,-1,-1,30,60,100,-1,-1,-1,70,110,-1,-1,120,-1,-1};
        Node root = constructTree(arr);
        display(root);
        int[] minmax = new int[2];
        // width(root,minmax, 0);
        // int width = minmax[1]-minmax[0]+1;
        // System.out.println(width);
        // System.out.println(size(root));
        // System.out.println(height(root));
        // leftview(root,0);
        // System.out.println(maxlevel);
        // HashMap<Integer,Integer> hm = new HashMap<>();
        // topview(root, 0,hm);
        // System.out.println(hm);
        allPair pair = new allPair();
        allPairSolutions(root,0,90,pair);
        System.out.println(pair.size);
        System.out.println(pair.height);
        System.out.println(pair.find);
        System.out.println(pair.ceil);
        System.out.println(pair.floor);
        System.out.println(pair.pred.data +" "+pair.succ.data);

    }

}