package com.company;

/**
 *
 * Created by John on 6/19/14.
 */
public class Stack {
    private int maxSize;
    private Node[] stackArray;
    private int top;

    /**
     * Stack constructor.
     * @param s int
     */
    public Stack(int s)
    {
        maxSize = s;
        stackArray = new Node[maxSize];

        top = -1;
    } // end Stack()

    /**
     * Pushes the top of the stack.
     * @param j Node
     */
    public void push(Node j)
    {
        stackArray[++top] = j;
    } // end push()

    /**
     * Pops the top of the stack.
     * @return Node
     */
    public Node pop()
    {
        return stackArray[top--];
    }// end pop ()

    /**
     * Checks to see if there are any nodes on top.
     * @return Node
     */
    public boolean isEmpty()
    {
        return (top == -1);
    } // end isEmpty()
}// end class Stack
