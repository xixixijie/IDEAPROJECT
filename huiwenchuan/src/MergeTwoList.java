import com.sun.org.apache.bcel.internal.generic.LNEG;

/**
 * Created by xixi on 2018/4/11.
 */
public class MergeTwoList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1==null&&l2==null){
            return null;
        }
        ListNode temp=head;


        while(l1!=null&&l2!=null){
            if(l1.val>l2.val){
                temp.next=l2;
                l2=l2.next;

            }else{
                temp.next=l1;
                l1=l1.next;

            }
            temp=temp.next;
        }

        if(l1==null){
            temp.next=l2;
        }
        if(l1==null){
            temp.next=l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(4);
        ListNode l4=new ListNode(1);
        ListNode l5=new ListNode(3);
        ListNode l6=new ListNode(4);
        //ListNode l7=new ListNode(1);
        l1.next=l2;
        l2.next=l3;
        l4.next=l5;
        l5.next=l6;
        MergeTwoList mergeTwoList=new MergeTwoList();

        ListNode temp=mergeTwoList.mergeTwoLists(l1,l4);

        while(temp!=null){
            System.out.println(temp.val);
            temp=temp.next;
        }

    }
}
