import java.util.*;
public class l001{
    public static int mazepath(int sr,int sc,int er,int ec,String psf){
        if(sr==er && sc==ec){
            System.out.println(psf);
            return 1;
        }
        int count = 0 ;
        if(sc+1<=ec){
            count+= mazepath(sr,sc+1,er,ec,psf+'H');
        }
        if(sr+1<=er){
            count+= mazepath(sr+1,sc,er,ec,psf+'V');
        }
        if(sr+1<=er && sc+1<=ec){
            count+= mazepath(sr+1,sc+1,er,ec,psf+'D');
        }
        return count;
    }
    public static int mazepathwj(int sr,int sc,int er,int ec,String ans){
        if(sr==er && sc==ec){
            System.out.println(ans);
            return 1;
        }
        int count = 0 ;
        for(int i = 1;sc+i<=ec;i++){
            count+= mazepathwj(sr,sc+i,er,ec,ans+"H"+i);
            }
        for(int i = 1;i+sr<=er;i++){
                count+= mazepathwj(sr+i,sc,er,ec,ans+"V"+i);
            }
        for(int i = 1;sr+i<=er && sc+i<=ec;i++){
                count+= mazepathwj(sr+i,sc+i,er,ec,ans+"D"+i);
            }
        return count;
    }

    public static int floodfill_(int sr,int sc,int er,int ec,boolean[][] visited,int[][] dir,String[] dirS,String ans){
        if(sr==er && sc == ec){
            System.out.println(ans);
            return 1;
        }
        visited[sr][sc] = true;
        int count = 0;
        for(int d = 0;d<4;d++){
            int r = sr+dir[d][0];
            int c = sc+dir[d][1];
            if(r>=0 && c>=0 && r<=er && c<=ec && visited[r][c]==false){
                count+=floodfill_(r, c, er, ec, visited, dir, dirS, ans+dirS[d]);
            }
        }
        visited[sr][sc]=false;
        return count;
    }
    public static void floodfill(){
        int sr =0,sc=0,er=4,ec=4;
        int[][] dirFour={{1,0},{-1,0},{0,1},{0,-1}};
        String[] dirFourS={"D","U","R","L"};
        boolean[][] vis = new boolean[er+1][ec+1];
        int ans = floodfill_(sr, sc, er, ec, vis, dirFour, dirFourS,"");  
        System.out.println(ans);
        return;
    }

    public static int allpermutations(String str,String ans){
        if(str.length()==0){
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            count+= allpermutations(str.substring(0, i)+str.substring(i+1),ans+ch);
        }
        return count;
    }
    public static int allpermutations_(String str,String ans){
        if(str.length()==0){
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        boolean[] vis = new boolean[26];
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!vis[ch-'a'])
            count+= allpermutations_(str.substring(0, i)+str.substring(i+1),ans+ch);
            vis[ch-'a']=true;
        }
        return count;
    }

    // public static int coinchangeinfinitepermutation(int[] arr,int idx,String ans){
        
    // }

    public static int coinchangeinfinitepermutation(int[] arr,int idx,int tar,String ans){
        if(tar==0){
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int i = idx;i<arr.length;i++){
            if(tar-arr[i]>=0){
                count+= coinchangeinfinitepermutation(arr, 0, tar-arr[i], ans+arr[i]);
            }
        }
        return count;
    }

    public static int coinchangeinfinitecombination(int[] arr,int idx,int tar,String ans){
        if(tar==0){
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int i = idx;i<arr.length;i++){
            if(tar-arr[i]>=0){
                count+= coinchangeinfinitecombination(arr, i, tar-arr[i], ans+arr[i]);
            }
        }
        return count;
    }

    public static int coinChangeSinglePermuatation(int[] arr,int idx,int tar,String ans){
        if(tar==0){
            System.out.println(ans);
            return 1;
        }

        int count=0;

        for(int i=idx;i<arr.length;i++){
            if(arr[i] > 0 && tar-arr[i] >= 0){
                int temp = arr[i];
                arr[i]=-arr[i];
                count += coinChangeSinglePermuatation(arr,0,tar-temp,ans + temp);
                arr[i]=-arr[i];
            }
        }
        return count;
    }

    public static int coinchangesinglecombination(int[] arr,int idx,int tar,String ans){
        if(tar==0){
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int i = idx;i<arr.length;i++){
            if(tar-arr[i]>=0){
                count+= coinchangesinglecombination(arr, i+1, tar-arr[i], ans+arr[i]);
            }
        }
        return count;
    }

    public static int coinchangesinglecombination_subseq(int[] arr,int idx,int tar,String ans){
        if(idx==arr.length){
            if(tar==0){
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;
            if(tar-arr[idx]>=0){
                count+= coinchangesinglecombination_subseq(arr, idx+1, tar-arr[idx], ans+arr[idx]);
            }
            count+=coinchangesinglecombination_subseq(arr, idx+1, tar, ans);
        return count;
    }
    
    public static int coinchangeinfinitecombination_subseq(int[] arr,int idx,int tar,String ans){
        if(idx==arr.length){
            if(tar==0){
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;
            if(tar-arr[idx]>=0){
                count+= coinchangeinfinitecombination_subseq(arr, idx, tar-arr[idx], ans+arr[idx]);
            }
            count+=coinchangeinfinitecombination_subseq(arr, idx+1, tar, ans);
        return count;
    }

    public static int coinchangesinglepermutation_subseq(int[] arr,int idx,int tar,String ans){
        if(idx==arr.length){
            if(tar==0){
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;
            if(arr[idx]>0 && tar-arr[idx]>=0){
                int temp = arr[idx];
                arr[idx]=-arr[idx];
                // count += coinChangeSinglePermuatation(arr,0,tar-temp,ans + temp);
                count+= coinchangesinglepermutation_subseq(arr,0, tar-temp, ans+temp);
                arr[idx]=-arr[idx];
            }
            count+=coinchangesinglepermutation_subseq(arr, idx+1, tar, ans);
        return count;
    }

    public static int coinchangeinfinitepermutation_subseq(int[] arr,int idx,int tar,String ans){
        if(idx==arr.length){
            if(tar==0){
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;
            if(tar-arr[idx]>=0){
                count+= coinchangeinfinitepermutation_subseq(arr,0, tar-arr[idx], ans+arr[idx]);
            }
            count+=coinchangeinfinitepermutation_subseq(arr, idx+1, tar, ans);
        return count;
    }


    public static void main(String[] args) {
        // int ans = mazepathwj(0,0,2,2,"");
        // floodfill();
        // int ans = allpermutations_("abc","");
        // System.out.println(ans);
        int[] arr = {2,3,5,7} ;
        // System.out.println(coinchangesinglecombination(arr,0,10,""));
        // System.out.println(coinchangesinglecombination_subseq(arr,0,10,""));
        // System.out.println(coinchangeinfinitecombination_subseq(arr,0,10,""));
        System.out.println(coinchangesinglepermutation_subseq(arr,0,10,""));
        // System.out.println(coinchangeinfinitepermutation_subseq(arr,0,10,""));
        
        // System.out.println(coinchangeinfinitepermutation(arr, 0, 10, ""));
        // System.out.println(coinchangeinfinitecombination(arr, 0, 10, ""));
        // System.out.println(coinChangeSinglePermuatation(arr, 0, 10, ""));
        
    }
}
