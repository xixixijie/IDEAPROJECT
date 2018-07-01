import java.util.Stack;

/**
 * Created by xixi on 2018/4/10.
 */
public class Parenth {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        char temp;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }
            if(s.charAt(i)==')'){
                if(stack.empty())
                    return false;
                temp=stack.pop();
                if(temp!='('){
                    return false;
                }
            }

            if(s.charAt(i)==']'){
                if(stack.empty())
                    return false;
                temp=stack.pop();
                if(temp!='['){
                    return false;
                }
            }

            if(s.charAt(i)=='}'){
                if(stack.empty())
                    return false;
                temp=stack.pop();
                if(temp!='{'){
                    return false;
                }
            }

        }
        if(!stack.empty()){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Parenth pa=new Parenth();
        System.out.println(pa.isValid("()[]{}"));
    }
}
