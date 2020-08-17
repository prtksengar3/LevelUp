import java.util.*;
public class l001{

    public class Node{
        int data=0;
        Node left=null;
        Node right=null;
        Node(int data){
            this.data = data;
        }
    }

    public static Node constructTree(int[] arr){
        if(idx == arr.length || arr[idx]==-1){
            idx++
            return null;
        }
        Node node = new Node(arr[idx++]);
        node.left = constructTree(arr);
        node.right = constructTree(arr); 
        return node;
    }
    
    public static void solve(){
        int[] arr={10,20,40,-1,-1,50,80,-1,-1,90,-1,-1,30,60,100,-1,-1,-1,70,110,-1,-1,120,-1,-1};
        Node root = constructTree(arr);
        display(root);
    }

    public static void display(Node node){
        if(node == null) return;
    }

    public static void main(String[] args) {
        solve();
    }
}