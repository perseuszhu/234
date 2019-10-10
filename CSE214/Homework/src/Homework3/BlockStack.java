package Homework3;

/**
 * @author Junjian Zhu R05
 *    e-mail: junjian.zhu@Stonybrook.edu
 *    Stony Brook ID: 111384808
 **/
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * stack class with block objects works the same as Stack class
 */
public class BlockStack implements Cloneable {
    public final int Capacity = 100;
    public Block[] data;
    public int top;

    public BlockStack(){
        top = -1;
        data = new Block[Capacity];
    }
    public int getSize(){
        return top+1;
    }

    public boolean isEmpty(){
        return(top == -1);
    }

    public void push(Block item) throws FullStackException {
        if(top == Capacity-1)
        throw new FullStackException();
        top++;
        data[top] = item;
    }

    public Block pop(){
        Block answer;
        if(top == -1)
            throw new EmptyStackException();
        answer = data[top];
        top--;
        return answer;
    }
    public Block peek(){
        Block answer;
        if(top == -1)
            throw new EmptyStackException();
        answer = data[top];
        return answer;
    }
}
