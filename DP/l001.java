import java.util.Arrays;
import java.util.LinkedList;

public class l001 {
    public static void main(String[] args) {
    solve();    
    }

    public static void display(int[] dp) {
        for (int ele : dp)
            System.out.print(ele + " ");
        System.out.println();
    }

    public static void display2D(int[][] dp) {
        for (int[] ar : dp) {
            display(ar);
        }
        System.out.println();
    }

    public static int fibo(int n,int dp[]){
        if(n<=1) return dp[n]=n;
        if(dp[n]!=0) return dp[n];
        int n1 = fibo(n-1,dp);
        int n2 = fibo(n-2,dp);
        return dp[n]=n1+n2;
    }

    public static int fibo_tab(int N,int dp[]){
        
        for(int n=0;n<=N;n++){
            if(n<=1){
                dp[n]=n;
                continue;
            } 
            // if(dp[n]!=0) return dp[n];
            int n1 = dp[n-1];//fibo(n-1,dp);
            int n2 = dp[n-2];//fibo(n-2,dp);
            dp[n]=n1+n2;
        }
        return dp[N];
    }

    public static int fibo_opti(int n){
        int a = 0,b=1;
        for(int i = 0;i<n;i++){
            int c = a+b;
            a=b;
            b=c;
        }
        return a;
    }

    public static int mazepath(int[][] arr,int sr,int sc){
        if(sr==arr.length-1 && sc == arr[0].length-1){
            return 1;
        }
        int count = 0;
        if(sr+1<arr.length)
        count+= mazepath(arr,sr+1,sc);
        if(sc+1<arr[0].length)
        count+= mazepath(arr,sr,sc+1);

        return count;
    } 

    public static int mazepath_memo(int[][] arr,int sr,int sc,int[][] dp){
        if(sr==arr.length-1 && sc == arr[0].length-1){
            return dp[sr][sc]=1;
        }
        if(dp[sr][sc]!=0) return dp[sr][sc];
        int count = 0;
        if(sr+1<arr.length)
        count+= mazepath_memo(arr,sr+1,sc,dp);
        if(sc+1<arr[0].length)
        count+= mazepath_memo(arr,sr,sc+1,dp);
        if(sc+1<arr[0].length && sr+1<arr.length)
        count+= mazepath_memo(arr, sr+1, sc+1,dp);
        return dp[sr][sc]=count;
    }     

    public static int mazepath_tab(int[][] arr,int sr,int sc,int[][] dp){

        for(sr=arr.length-1;sr>=0;sr--){
            for(sc = arr[0].length-1;sc>=0;sc--){

                if(sr==arr.length-1 && sc == arr[0].length-1){
                    dp[sr][sc]=1;
                    continue;
                }
                // if(dp[sr][sc]!=0) return dp[sr][sc];
                int count = 0;
                if(sr+1<arr.length)
                count+= dp[sr+1][sc]; //mazepath_memo(arr,sr+1,sc,dp);
                if(sc+1<arr[0].length)
                count+= dp[sr][sc+1]; //mazepath_memo(arr,sr,sc+1,dp);
                if(sc+1<arr[0].length && sr+1<arr.length)
                count+= dp[sr+1][sc+1]; //mazepath_memo(arr, sr+1, sc+1,dp);
                dp[sr][sc]=count;
            }
        }
        return dp[0][0];

    } 

    public static int mazepathjump_tab(int[][] arr,int sr,int sc,int[][] dp){

        for(sr=arr.length-1;sr>=0;sr--){
            for(sc = arr[0].length-1;sc>=0;sc--){

                if(sr==arr.length-1 && sc == arr[0].length-1){
                    dp[sr][sc]=1;
                    continue;
                }
                // if(dp[sr][sc]!=0) return dp[sr][sc];
                int count = 0;
                for(int jump = 0;sr+jump<arr.length;jump++) 
                count+= dp[sr+jump][sc]; //mazepath_memo(arr,sr+1,sc,dp);
                for(int jump = 0;sc+jump<arr[0].length;jump++)
                count+= dp[sr][sc+jump]; //mazepath_memo(arr,sr,sc+1,dp);
                for(int jump = 0;sc+jump<arr[0].length && sr+jump<arr.length;jump++)
                count+= dp[sr+jump][sc+jump]; //mazepath_memo(arr, sr+1, sc+1,dp);
                dp[sr][sc]=count;
            }
        }
        return dp[0][0];

    } 

    public static int boardPath(int si, int ei,int[] dp) {
        if(si==ei) return dp[si] = 1;
        int count = 0;
        if(dp[si]!=0) return dp[si]; 
        for(int i = 1;i<=6 && si+i<=ei;i++){
            count += boardPath(si+i,ei,dp);
        }
        return dp[si]=count;
    }

    public static int boardPath_tab(int si, int ei, int[] dp) {

        for(si=ei;si>=0;si--){
            if (si == ei) {
                dp[si] = 1;
                continue;
            }
    
            // if (dp[si] != 0) return dp[si];
    
            int count = 0;
            for (int dice = 1; dice <= 6 && si + dice <= ei; dice++) {
                count += dp[si+dice]; //boardPath(si + dice, ei, dp);
            }
    
            dp[si] = count;
        }
        return dp[0];

    }


    public static int boardPath_optimisedtab(int si, int ei, int[] dp) {
        LinkedList<Integer> ll = new LinkedList<>(); 
        for(si=ei;si>=0;si--){
            if (si >= ei-1) {
                ll.addFirst(1);
                continue;
            }
    
            // if (dp[si] != 0) return dp[si];
    
            if(ll.size()<=6) ll.addFirst(ll.getFirst()*2);//only for regular dice
            else{
                int lval = ll.removeLast();
                ll.addFirst(ll.getFirst()*2 - lval);
            }
        }
        return ll.getFirst();

    }

    public static int boardPathmoves_tab(int si, int ei, int[] dp) {
        // int[] moves={2,5,8,3};
        int[] moves = {2,5,8,3};
        Arrays.sort(moves);
        for(si=ei;si>=0;si--){
            if (si == ei) {
                dp[si] = 1;
                continue;
            }
    
            // if (dp[si] != 0) return dp[si];
    
            int count = 0;
            for (int i = 0;i<moves.length && si + moves[i] <= ei; i++) {
                count += dp[si+moves[i]]; //boardPath(si + dice, ei, dp);
            }
    
            dp[si] = count;
        }
        return dp[0];

    }

    public static int climbStairs_(int si,int ei,int[] dp){
        if(si==ei) return dp[si] = 1;
        if(dp[si]!=0) return dp[si];
        int count = 0;
        if(si+1<=ei) count+=climbStairs_(si+1,ei,dp);
        if(si+2<=ei) count+=climbStairs_(si+2,ei,dp);
        return dp[si] = count;
    }

    //www.geeksforgeeks.org/count-number-of-ways-to-partition-a-set-into-k-subsets/
    public static int ksubsetspartition(int n,int k,int[][] dp){ 
        if(k==1 || k==n){
                return dp[n][k] = 1;
            }
            int kmonesubset = ksubsetspartition(n-1, k-1,dp);
            int ksubset = ksubsetspartition( n-1, k,dp)*k;

            return dp[n][k] = ksubset+kmonesubset;

    }

    public static int ksubsetspartition_tab(int n,int k,int[][] dp){ 
        int N = n;
        int K = k;
        for(n= 1;n<=N;n++){
            for(k = 1;k<=K;k++){

                if(k==1 || k==n){
                     dp[n][k] = 1;
                    continue;
                }
                int kmonesubset = dp[n-1][k-1];//ksubsetspartition(n-1, k-1,dp);
                int ksubset = dp[n-1][k]*k;//ksubsetspartition( n-1, k,dp)*k;
    
                dp[n][k] = ksubset+kmonesubset;

            }
        }
        return dp[N][K];

    }
    


    public static void solve(){
        int n = 10;
        // int[][] arr = new int[n][n];
        int[] arr = {1,2,3};
        // int[] dp = new int[n+1];
        int[][] dp= new int[10+1][7+1]; 
        // int ans = fibo(n,dp);
        // int ans = fibo_tab(n, dp);
        // int ans = fibo_opti(n); 
        // int ans = mazepath(arr, 0, 0);
        // int ans = mazepath_memo(arr, 0, 0, dp);
        // int ans  = mazepathjump_tab(arr,0,0,dp);
        // int ans = boardPath(0,10,dp);
        // int ans = boardPath_tab(0,10,dp);
        // int ans =boardPath_optimisedtab(0, n, dp);
        // int ans = boardPathmoves_tab(0,10,dp);
        int ans = ksubsetspartition_tab(10, 7,dp);
        // int ans = climbStairs_(0,n,dp);
        // display(dp);
        display2D(dp);
        System.out.println(ans);
    }
}
