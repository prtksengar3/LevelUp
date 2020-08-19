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
        int rh = leftview(node.right,level+1);
        int lh = leftview(node.left,level+1);
        return lh;
    }

    public static void solve(){
        // int[] arr={50,25,12,-1,-1,37,30,-1,-1,-1,75,62,-1,70,-1,-1,87,-1,-1};
        int[] arr={10,20,40,-1,-1,50,80,-1,-1,90,-1,-1,30,60,100,-1,-1,-1,70,110,-1,-1,120,-1,-1};
        Node root = constructTree(arr);
        display(root);
        int[] minmax = new int[2];
        // width(root,minmax, 0);
        int width = minmax[1]-minmax[0]+1;
        // System.out.println(width);
        // System.out.println(size(root));
        // System.out.println(height(root));
        leftview(root,0);
        // System.out.println(maxlevel);
    }

}