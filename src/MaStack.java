/**
 * Coursera - Algorithms Part I
 * Week 2 - Interview Questions - Stacks and Queues
 *
 * Question 2: Stack with max
 *
 * Create a data structure that efficiently supports the stack operations
 * (push and pop) and also a return-the-maximum operation. Assume the elements
 * are reals numbers so that you can compare them.
 *
 */

/**
 * Solution:
 * Use two stacks, one is to store actual stack elements, and the other auxiliary stack to store max values.
 * The idea is to do pop and push operations in such a way that the top of max stack is always the maximum
 * push: compare the new elements and the old elements
 * pop: always the same height(add new or old) in order to keep the maximum the max according to the height
 */
//Java implementation of SpecialStack
// Note : here we use Stack class for Stack implementation

import java.util.Stack;

/* A class that supports all the stack operations and one additional
operation getMin() that returns the minimum element from stack at
any time. This class inherits from the stack class and uses an
auxiliarry stack that holds ！！！！！！！minimum elements ！！！！！！！！ */

class SpecialStack extends Stack<Integer>
{
    Stack<Integer> min = new Stack<>();

    /* SpecialStack's member method to insert an element to it. This method
    makes sure that the min stack is also updated with appropriate minimum
    values */
    void push(int x){
        if(isEmpty()==true){
            super.push(x);
            min.push(x);
        }
        else{
            super.push(x);
            int y=min.pop();
            if(x<y)
                min.push(x);
            else
                min.push(y);
        }
    }


    /* SpecialStack's member method to insert an element to it. This method
    makes sure that the min stack is also updated with appropriate minimum
    values */
    public Integer pop()
    {
        int x=super.pop();
        min.pop();
        return x;
    }

    /* SpecialStack's member method to get minimum element from it. */
    int getMin()
    {
        int x=min.pop();
        min.push(x);
        return x;
    }

    /* Driver program to test SpecialStack methods */
    public static void main(String[] args)
    {
        SpecialStack s = new SpecialStack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.getMin());
        s.push(5);
        System.out.println(s.getMin());
    }
}

