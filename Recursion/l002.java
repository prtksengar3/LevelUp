import java.util.*;
public class l002{

    public static int oneDQueenCombination(boolean[] box,int idx,int tq,int qpsf,String ans){
        if(tq==qpsf){
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for(int i = idx;i<box.length;i++){
                count+=oneDQueenCombination(box,i+1,tq,qpsf+1,ans+"b"+i+"q"+qpsf+" ");
        }
        return count;
    }

    public static int oneDQueenPermutation(boolean[] box,int idx,int tq,int qpsf,String ans){
        if(tq==qpsf){
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for(int i = idx;i<box.length;i++){
            if(!box[i]){
                box[i] = true;
                count+=oneDQueenPermutation(box,0,tq,qpsf+1,ans+"b"+i+"q"+qpsf+" ");
                box[i] = false;
            }
        }
        return count;
    }

    public static int twoDQueenCombination(boolean[][] box,int idx,int tq,int qpsf,String ans){
        if(tq==qpsf){
            System.out.println(ans);
            return 1;
        }
        int m = box.length;
        int count = 0;
        for(int i = idx;i<m*m;i++){
            int r = i/m;
            int c = i%m; 
                count+=twoDQueenCombination(box,i+1,tq,qpsf+1,ans+"("+r+", "+c+") ");
        }
        return count;
    }

    public static int twoDQueenPermutation(boolean[][] box,int idx,int tq,int qpsf,String ans){
        if(tq==qpsf){
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        int m = box.length;
        for(int i = idx;i<m*m;i++){
            int r = i/m;
            int c = i%m; 
            if(!box[r][c]){
                box[r][c] = true;
                count+=twoDQueenPermutation(box,0,tq,qpsf+1,ans+"("+r+", "+c+") ");
                box[r][c] = false;
            }
        }
        return count;
    }

    // public static twoD

    public static void main(String[] args) {
    //    System.out.println(oneDQueenCombination(new boolean[6],0,3,0,""));
    //    System.out.println(oneDQueenPermutation(new boolean[6],0,3,0,""));
    //    System.out.println(twoDQueenPermutation(new boolean[4][4],0,4,0,""));
       System.out.println(twoDQueenCombination(new boolean[4][4],0,4,0,""));
        
    }
}