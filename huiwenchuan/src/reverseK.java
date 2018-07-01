import static java.sql.Types.NULL;

/**
 * Created by xixi on 2018/4/16.
 */
public class reverseK {
    ListNode reverseKGroup(ListNode head, int k) {
        if(head==null){
            return null;
        }

        ListNode t[]=new ListNode[k+1];

        t[0]=head;
        for(int i=1;i<k;i++){
            t[i]=t[i-1].next;
            if(t[i]==null){
                return head;
            }
        }
        t[k]=t[k-1].next;
        head=t[k-1];
        ListNode temp;
        do{
            //倒置
            for(int i=k-1;i>0;i--){
                t[i].next=t[i-1];
            }
            temp=t[0];
            t[0]=t[k];
            if(t[k]==null){
                temp.next=t[k];
                break;
            }
            //重置t数组
            for(int i=1;i<k;i++){
                t[i]=t[i-1].next;
                if(t[i]==null){
                    temp.next=t[0];
                    return head;
                }
            }
            if(t[k-1]==null){
                break;
            }
            t[k]=t[k-1].next;
            temp.next=t[k-1];

        }while(true);
        return head;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
//        ListNode l3=new ListNode(3);
//        ListNode l4=new ListNode(4);
//        ListNode l5=new ListNode(5);
        l1.next=l2;
//        l2.next=l3;
//        l3.next=l4;
//        l4.next=l5;

        reverseK rk=new reverseK();

        ListNode l=rk.reverseKGroup(l1,2);
        while(l!=null){
            System.out.println(l.val);
            l=l.next;
        }
    }
}
