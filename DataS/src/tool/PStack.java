package tool;

import java.util.Stack;

/**
 * Created by xixi on 2017/9/1.
 */
public class PStack {
    Stack<Car> stack;
    int MAXSIZE;
    int nowSize;

    public PStack(int MAXSIZE) {
        stack=new Stack<>();
        this.MAXSIZE = MAXSIZE;
        nowSize=0;
    }

    public boolean isFull(){
        if(nowSize==MAXSIZE){
            return true;
        }
        return false;
    }


    public void push(Car item) {
        nowSize++;
        stack.push(item);
    }


    public synchronized Car pop() {
        nowSize--;
        return stack.pop();
    }

    public Car peek(){
        return stack.peek();
    }

    public boolean empty(){
        return stack.empty();
    }
}
