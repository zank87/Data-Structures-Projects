package com.company;

/**
 * @author John Zank
 *
 */

public class Main
{
    public static void main(String[] args)
    {
        LinkedList theList = new LinkedList();
        IO userInput = new IO();

        System.out.println("\nThis program will take your input of integers and build a linked list.");
        System.out.println("Once you are done entering your integers please enter -1 to build your list.");

        userInput.buildList(theList);

        System.out.println("Initial Double Linked List\n");;
        theList.displayForward();
        System.out.println("\nNumber of Nodes in List: "+userInput.getNodeCount()+".\n");

        userInput.displayMenu(theList);
    } // end main
} // End Main class