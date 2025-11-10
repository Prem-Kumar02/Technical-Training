import java.util.*; 
class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if(s2.size()!=0) {return s2.pop();}
        else{
            while(s1.size()>0){
                s2.push(s1.peek());
                s1.pop();
            }
            return s2.pop();
        }
    }
    
    public int peek() {
        if(s2.size()!=0){
            return s2.peek();
        }
        else{
            while(s1.size()>0){
                s2.push(s1.peek());
                s1.pop();
            }
            return s2.peek();
        }
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}