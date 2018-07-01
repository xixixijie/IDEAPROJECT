import java.util.Stack;

/**
 * Created by xixi on 2018/6/4.
 */
public class leetcode114 {
    public void flatten(TreeNode root) {
        Stack<TreeNode> s=new Stack<>();
        s.push(root);
        TreeNode cur;
        while(!s.empty()){
            cur=s.peek();
            s.pop();
            System.out.println(cur.val);
            if(cur.right!=null)
                s.push(cur.right);
            if(cur.left!=null)
                s.push(cur.left);
        }
    }
    public static void main(String[] args) {
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(5);
        TreeNode n6=new TreeNode(6);
        n1.left=n2;
        n1.right=n5;
        n2.left=n3;
        n2.right=n4;
        n5.right=n6;

        new leetcode114().flatten(n1);
    }
}
