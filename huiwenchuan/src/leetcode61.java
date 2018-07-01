/**
 * Created by xixi on 2018/5/8.
 */
public class leetcode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null)
            return head;
        ListNode temp=head;

        int size=0;

        while(temp!=null){
            size++;
            temp=temp.next;
            if(temp.next==null){
                temp.next=head;
                size++;
                break;
            }
        }
        k=k%size;
        temp=head;
        for(int i=0;i<size-k;i++){
            temp=temp.next;
        }
        head=temp;

        for(int i=0;i<size-1;i++){
            temp=temp.next;
        }
        temp.next =null;
        return head;

    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;

        new leetcode61().rotateRight(n1,2);
    }
}
