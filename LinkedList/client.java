import java.util.LinkedList;

public class client{
    public static void main(String[] args) throws Exception{
        linkedlist ll = new linkedlist();
        for(int i = 1;i<10;i++){
            ll.addFirst(i*10);
            // ll.addLast(i*10);
        }
        System.out.println(ll);
        System.out.println(ll.getLast());
        // System.out.println();
        ll.addAt(2,35);
        System.out.println(ll);
        ll.removeAt(3);
        // System.out.println(ll.RemoveLast());
        System.out.println(ll);
        System.out.println(ll.isEmpty());
    }
}