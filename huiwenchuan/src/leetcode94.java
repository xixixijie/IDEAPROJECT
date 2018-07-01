import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xixi on 2018/5/14.
 */
public class leetcode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;

        while(cur!=null||!stack.empty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{

                ans.add(stack.peek().val);
                cur=stack.peek().right;
                stack.pop();

            }
        }
        return ans;
    }
}
