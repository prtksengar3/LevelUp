public class client{
    public static void main(String[] args) throws Exception {
        DStack st = new DStack();
        for(int i = 1;i<120;i++){
         st.push((int)(Math.random()*100));   
        }

        System.out.println(st);
        st.pop();
        st.pop();
        System.out.println(st.isEmpty());
        // System.out.println(st);
        // System.out.println(st.top());
    }
}