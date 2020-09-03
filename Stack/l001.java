import java.util.Stack;
import java.util.Arrays;
public class l001{
    public static void main(String[] args) {
        solve();
    }

    public static void ngor(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans,n);
        for(int i = 0;i<n;i++){
            while(st.size()!=0 && arr[i]>arr[st.peek()]){
                ans[st.pop()]=i;
                }
                
                st.push(i);
        }
        for(int i = 0;i<n;i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }

    public static void ngol(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        for(int i = n-1;i>=0;i--){
            while(st.size()!=0 && arr[i]>arr[st.peek()]){
                ans[st.pop()]=i;
                }
                
                st.push(i);
        }
        for(int i = 0;i<n;i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }

    public static void nsor(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans,n);
        for(int i = 0;i<n;i++){
            while(st.size()!=0 && arr[i]<arr[st.peek()]){
                ans[st.pop()]=i;
                }
                
                st.push(i);
        }
        for(int i = 0;i<n;i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }

    public static void nsol(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        for(int i = n-1;i>=0;i--){
            while(st.size()!=0 && arr[i]<arr[st.peek()]){
                ans[st.pop()]=i;
                }
                
                st.push(i);
        }
        for(int i = 0;i<n;i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }

    public static void solve(){
        int[] arr = {2,6,3,9,7};
        ngor(arr);
        ngol(arr);
        nsor(arr);
        nsol(arr);
        
    }
}