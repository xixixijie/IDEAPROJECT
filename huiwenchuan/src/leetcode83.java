/**
 * Created by xixi on 2018/5/12.
 */
public class leetcode83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp=head;
        ListNode now=head;
        while(temp!=null){
            if(temp.val==now.val){
                temp=temp.next;
            }else {
                now.next=temp;
                now=temp;
                temp=temp.next;
            }
        }
        now.next=temp;


        return head;
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(2);

        n1.next=n2;
        n2.next=n3;
        new leetcode83().deleteDuplicates(n1);

    }
}
