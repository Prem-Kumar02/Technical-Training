import java.util.*;
class Solution{
    static class Stack{
        int top;
        int maxSize;
        int[] arr;

        Stack(int size){
            this.maxSize = size;
            this.arr = new int[maxSize];
            this.top = -1;
        }

        void push(int x){
            if(top == maxSize - 1){
                System.out.println("Stack Overflow");
                return;
            }
            arr[++top] = x;
        }

        int pop(){
            if(top == -1){
                System.out.println("Stack Underflow");
                return -1;
            }
            return arr[top--];
        }

        int peek(){
            if(top == -1){
                System.out.println("Stack is empty");
                return -1;
            }
            return arr[top];
        }

        boolean isEmpty(){
            return top == -1;
        }
    }

    public static void main(String[] args){
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.peek());
        System.out.println(stack.pop());  
        System.out.println(stack.isEmpty()); 
    }
}
