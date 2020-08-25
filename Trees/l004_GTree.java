import java.util.ArrayList;
import java.util.Stack;
public class l004_GTree{
    public static void main(String[] args) {
        solve();
    }

    public static class Node{
        int data = 0;
        ArrayList<Node> children = new ArrayList<>();
        Node(int data){
            this.data = data;
        }
    }

    public static Node ConstructTree(int[] arr){
        Stack<Node> st = new Stack<>();
        for(int i = 0;i<arr.length-1;i++){
            if(arr[i]!=-1){
                st.push(new Node(arr[i]));
            }
            else{
                Node node = st.pop();
                st.peek().children.add(node);
            }
        }
        return st.peek();
    }

    public static void display(Node node){
        StringBuilder sb = new StringBuilder();
        sb.append(node.data +" -> ");
        for(Node child:node.children){
            sb.append(child.data +", ");
        }
        sb.append(".");
        System.out.println(sb);
        for(Node child:node.children){
            display(child);
        }
    }

    public static int size(Node node){
        int s = 0;
        for(Node child:node.children){
            s+= size(child);
        }
        return s+=1;
    }

    public static int max(Node node){
        int max = node.data;
        for(Node child:node.children){
            max = Math.max(max,max(child));
        }
        return max;
    }

    public static int height(Node node){
        int height = -1;
        for(Node child:node.children){
            height =Math.max(height,height(child));
        }
        return height+1;
    }

    public static boolean find(Node node,int data){
        if(node.data == data) return true;
        for(Node child:node.children) if(find(child,data)) return true;
        return false;
    }

    public static void solve(){
        int[] arr={10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 100, -1, 110, -1, -1, 90, -1, -1, 40, 120, 140, -1, 150, -1, -1, -1,-1};
        Node root = ConstructTree(arr);
        display(root);
        System.out.println(find(root,90));
    }
}