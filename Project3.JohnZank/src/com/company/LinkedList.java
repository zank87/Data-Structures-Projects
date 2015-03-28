package com.company;

/**
 *
 * @author John Zank. LinkedList class constructs a linked list utilizing the Link class.
 */

public class LinkedList {


    private Link first;
    private Link last;

    /**
     * LinkedList constructor. Initializes the first and last link variables
     */
    public LinkedList()
    {
        first = null;
        last = null;
    } // end LinkedList constructor

    /**
     * Checks to see if the list is empty
     * @return boolean
     */
    public boolean isEmpty()
    {
        return first == null;
    } // end isEmpty()

    /**
     * Inserts integer parameter to the front of the list.
     * @param dd integer
     */
    public void insertFirst(int dd)
    {
        Link newLink = new Link(dd);
        if( isEmpty() )
            last = newLink;
        else
        {
            first.setPrevious(newLink);
            newLink.setNext(first);
        } // end else
        first = newLink;
    }// end insertFirst()

    /**
     * Inserts integer parameter to the end of the list.
     * @param dd integer
     */
    public void insertLast(int dd)
    {
        Link newLink = new Link(dd);
        if( isEmpty() )
            first = newLink;
        else
        {
            last.setNext(newLink);
            newLink.setPrevious(last);
        } // end else
        last = newLink;
    } // end insertLast()


    /**
     * Searches for key value and creates a link with a new user input value after the key's link.
     * @param key integer
     * @param id integer
     * @return boolean
     */
    public boolean insertAfter(int key, int id)
    {
        Link current = first;
        while(current.getData() != key)
        {
            current = current.getNext();
            if(current == null)
                return false;
        }  // end while()

        Link newLink = new Link(id);

        if(current==last)
        {
            newLink.setNext(null);
            last = newLink;
        } // end if
        else
        {
            newLink.setNext(current.getNext());

            current.getNext().setPrevious(newLink);
        } // end else
        newLink.setPrevious(current);
        current.setNext(newLink);
        return true;
    } // end insertAfter()

    /**
     * Deletes the first link in the link list
     * @return Link
     */
    public Link deleteFirst()
    {
        Link temp = first;
        if(first.getNext() == null)
            last = null;
        else
            first.getNext().setPrevious(null);
        first = first.getNext();
        return temp;
    } // end deleteFirst()

    /**
     * Deletes last link in the link list
     * @return Link
     */
    public Link deleteLast()
    {
        Link temp = last;
        if(first.getNext() == null)
            first = null;
        else
            last.getPrevious().setNext(null);
        last = last.getPrevious();
        return temp;
    } // end deleteLast()

    /**
     * Deletes the link that matches the search key parameter
     * @param key integer
     * @return Link
     */
    public Link deleteKey(int key)
    {
        Link current = first;
        while(current.getData() != key)
        {
            current = current.getNext();
            if(current == null)
                return null;
        } // end while loop
        if(current==first)
            first = current.getNext();
        else
            current.getPrevious().setNext(current.getNext());
        if(current==last)
             last = current.getPrevious();
        else
            current.getNext().setPrevious(current.getPrevious());
        return current;
    } // end deleteKey()

    /**
     * Displays the link list in ascending order
     */
    public void displayForward()
    {
        Link current = first;
        int nodeCount = 1;
        System.out.printf("%-15s %10s", "Node Count", "Value");
        System.out.println("\n==========================");
        while(current != null)
        {
            System.out.printf("\n%-15d %10d", nodeCount, current.getData());
            current = current.getNext();
            nodeCount++;
        } // end while loop
        System.out.println("");
    } // end displayForward()

    public void displayBackward()
    {
        Link current = last;
        int nodeCount = 1;
        System.out.printf("%-15s %10s", "Node Count", "Value");
        System.out.println("\n==========================");
        while(current != null)
        {
            System.out.printf("\n%-15d %10d", nodeCount, current.getData());
            current = current.getPrevious();
            nodeCount++;
        } // end while
        System.out.println("");
    } // end displayBackward()
    /**
     * Displays the integer in the first link of the link list
     * @return int
     */
    public int displayFirstLink()
    {
        return first.getData();
    } // end displayFirstLink()

    /**
     * Displays the integer in the last link of the link list
     * @return int
     */
    public int displayLastLink()
    {
        return last.getData();
    } // end displayLastLink()
} // end LinkedList class
