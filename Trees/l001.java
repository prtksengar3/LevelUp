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

    // public static int width(Node node,int[] minmax,int level){
    //     width(node.left)
    // }

    public static void solve(){
        // int[] arr={50,25,12,-1,-1,37,30,-1,-1,-1,75,62,-1,70,-1,-1,87,-1,-1};
        int[] arr={10,20,40,-1,-1,50,80,-1,-1,90,-1,-1,30,60,100,-1,-1,-1,70,110,-1,-1,120,-1,-1};
        Node root = constructTree(arr);
        display(root);
    }

}