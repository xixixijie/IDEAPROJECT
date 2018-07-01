/**
 * Created by xixi on 2018/5/12.
 */
public class leetcode84 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode temp=head;
        ListNode now;
        ListNode newHead=new ListNode(0);
        newHead.next=head;
        now=newHead;

        while(temp!=null){

            if(temp.next!=null&&temp.val==temp.next.val){
                int tempval=temp.val;
                while(temp!=null&&temp.val==tempval){
                    temp=temp.next;
                }
            }else{
                now.next=temp;
                now=now.next;
                temp=temp.next;
            }



        }
        now.next=temp;


        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(1);
//        ListNode n3=new ListNode(3);
//        ListNode n4=new ListNode(3);
//        ListNode n5=new ListNode(4);
//        ListNode n6=new ListNode(4);
//        ListNode n7=new ListNode(5);
        n1.next=n2;
//        n2.next=n3;
//        n3.next=n4;
//        n4.next=n5;
//        n5.next=n6;
//        n6.next=n7;

        ListNode temp=new leetcode84().deleteDuplicates(n1);
        while(temp!=null){
            System.out.println(temp.val);
        }



    }
}
