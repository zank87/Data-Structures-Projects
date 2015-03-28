package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *@author John Zank.
 * IO class handles the majority of the input and output of Project 3.
 */
public class IO
{
    private String sInput;
    private int iInput, choice, nodeCount;

    /**
     * IO Class constructor. Initializes variables
     */
    public IO()
    {
        iInput = choice = nodeCount = 0;
    } // end IO constructor

    /**
     * Takes user's input of integers and constructs a linked list.
     * @param list LinkedList
     * @return LinkedList
     */
    public LinkedList buildList(LinkedList list)
    {
        Scanner scan = new Scanner(System.in);
        while(iInput != -1 || list.isEmpty()) // Loop to ensure proper input
        {
            try
            {
                System.out.println("Please enter any integer (except -1) and the press enter.");
                iInput = scan.nextInt();
                if(iInput != -1)
                {
                    list.insertLast(iInput);
                    nodeCount++;
                } // end if
                System.out.println();
            } // end try 
            catch (InputMismatchException e)
            {
                System.out.println("ERROR: Input not an integer.\n");
                scan.nextLine();
            } // end catch
        } // end while loop
        return list;
    } // end buildList()

    /**
     * Displays a menu that the user utilizes to manipulate or display the linked list.
     * @param list LinkedList
     */
    public void displayMenu(LinkedList list)
    {
        Scanner scan = new Scanner(System.in);
        do // Menu selection
        {
            System.out.println("Update Menu");
            System.out.println("1. Delete First");
            System.out.println("2. Delete Last");
            System.out.println("3. Insert First");
            System.out.println("4. Insert Last");
            System.out.println("5. Delete Any Arbitrary Node");
            System.out.println("6. Insert Node After");
            System.out.println("7. Display Updated Linked List");
            System.out.println("8. Terminate");
            try
            {
                choice = scan.nextInt();
                switch(choice)
                {
                    case 1: // Delete First
                        System.out.println("You have deleted the first item: "+list.displayFirstLink());
                        list.deleteFirst();
                        System.out.println("Do you wish to continue? (Y/N)");
                        scan.nextLine(); // clears last input
                        sInput = scan.nextLine().substring(0).toLowerCase();
                        while(sInput.compareTo("y") != 0 && sInput.compareTo("n") != 0)
                        {
                            System.out.println("Invalid choice.");
                            System.out.println("Do you wish to continue? (Y/N)");
                            sInput = scan.nextLine().substring(0).toLowerCase();
                        } // end while loop
                        if(sInput.compareTo("n") == 0)
                            choice = 8;
                        break;
                    case 2: // Delete Last
                        System.out.println("You have deleted the last item: "+list.displayLastLink());
                        list.deleteLast();
                        System.out.println("Do you wish to continue? (Y/N)");
                        scan.nextLine(); // clears last input
                        sInput = scan.nextLine().substring(0).toLowerCase();
                        while(sInput.compareTo("y") != 0 && sInput.compareTo("n") != 0)
                        {
                            System.out.println("Invalid choice.");
                            System.out.println("Do you wish to continue? (Y/N)");
                            sInput = scan.nextLine().substring(0).toLowerCase();
                        } // end while loop
                        if(sInput.compareTo("n") == 0)
                            choice = 8;
                        break;
                    case 3: // Insert First
                        try
                        {
                            System.out.println("What integer do you wish to insert to front of the list?");
                            iInput = scan.nextInt();
                            if(iInput <= list.displayFirstLink())
                            {
                                System.out.println(iInput+" has been inserted to the front of the list.");
                                list.insertFirst(iInput);
                            } // end if
                            else
                                System.out.println("The number you wish to insert is larger than node 1: "+list.displayFirstLink());
                            System.out.println("Do you wish to continue? (Y/N)");
                            scan.nextLine(); // clears last input
                            sInput = scan.nextLine().substring(0).toLowerCase();
                            while(sInput.compareTo("y") != 0 && sInput.compareTo("n") != 0)
                            {
                                System.out.println("Invalid choice.");
                                System.out.println("Do you wish to continue? (Y/N)");
                                sInput = scan.nextLine().substring(0).toLowerCase();
                            } // end while loop
                            if(sInput.compareTo("n") == 0)
                                choice = 8;
                        } // end try
                        catch (InputMismatchException e)
                        {
                            System.out.println("ERROR: Input not an integer.");
                            scan.nextLine();
                        } // end catch
                        break;
                    case 4: // Insert Last
                        try
                        {
                            System.out.println("What integer do you wish to insert to end of the list?");
                            iInput = scan.nextInt();
                            if(iInput != -1)
                            {
                                if(iInput >= list.displayLastLink())
                                {
                                    System.out.println(iInput+" has been inserted to the end of the list.");
                                    list.insertLast(iInput);
                                } // end if
                                else
                                    System.out.println("The number you wish to insert is smaller than the last node: "+list.displayLastLink());
                            } // end if
                            System.out.println("Do you wish to continue? (Y/N)");
                            scan.nextLine(); // clears last input
                            sInput = scan.nextLine().substring(0).toLowerCase();
                            while(sInput.compareTo("y") != 0 && sInput.compareTo("n") != 0)
                            {
                                System.out.println("Invalid choice.");
                                System.out.println("Do you wish to continue? (Y/N)");
                                sInput = scan.nextLine().substring(0).toLowerCase();
                            } // end while
                            if(sInput.compareTo("n") == 0)
                                choice = 8;
                        } // end try
                        catch (InputMismatchException e)
                        {
                            System.out.println("ERROR: Input not an integer.");
                            scan.nextLine();
                        } // end catch
                        break;
                    case 5: // Delete any arbitrary node
                        try
                        {
                            System.out.println("What is the value of the node you wish to delete?");
                            iInput = scan.nextInt();
                            if(list.deleteKey(iInput) != null)
                            {
                                System.out.println("Deleting node with the value: "+iInput+".\n");
                                list.deleteKey(iInput);
                            } // end if
                            else
                                System.out.println("A node with that value can not be found.\n");
                            System.out.println("Do you wish to continue? (Y/N)");
                            scan.nextLine(); // clears last input
                            sInput = scan.nextLine().substring(0).toLowerCase();
                            while(sInput.compareTo("y") != 0 && sInput.compareTo("n") != 0)
                            {
                                System.out.println("Invalid choice.");
                                System.out.println("Do you wish to continue? (Y/N)");
                                sInput = scan.nextLine().substring(0).toLowerCase();
                            } // end while loop
                            if(sInput.compareTo("n") == 0)
                                choice = 8;
                        } // end try
                        catch (InputMismatchException e)
                        {
                            System.out.println("ERROR: Input not an integer.");
                            scan.nextLine();
                        } // end catch
                        break;
                    case 6: // Insert node after
                        try
                        {
                            int key;
                            boolean insert;
                            System.out.println("What is the value of the node you wish to insert after?");
                            key = scan.nextInt();
                            System.out.println("What integer do you wish to insert?");
                            iInput = scan.nextInt();
                            insert = list.insertAfter(key, iInput);
                            if(insert)
                                System.out.println("You have inserted "+iInput+" after the node containing "+key+".");
                            else
                                System.out.println(key+" was not found. "+iInput+" was not inserted into the list.");
                            System.out.println("Do you wish to continue? (Y/N)");
                            scan.nextLine(); // clears last input
                            sInput = scan.nextLine().substring(0).toLowerCase();
                            while(sInput.compareTo("y") != 0 && sInput.compareTo("n") != 0)
                            {
                                System.out.println("Invalid choice.");
                                System.out.println("Do you wish to continue? (Y/N)");
                                sInput = scan.nextLine().substring(0).toLowerCase();
                            } // end while loop
                            if(sInput.compareTo("n") == 0)
                                choice = 8;
                        } // end try
                        catch (InputMismatchException e)
                        {
                            System.out.println("ERROR: Input not an integer.");
                            scan.nextLine();
                        } // end catch
                        break;
                    case 7: // Display updated list
                        System.out.println("\nUpdated Linked List\n");
                        System.out.println("   Forward Linked List");
                        list.displayForward();
                        System.out.println("\n   Reversed Linked List");
                        list.displayBackward();
                        System.out.println();
                        break;
                    case 8: // Terminate
                        System.out.println("Exiting program. Goodbye.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid option.");
                        break;
                } // end switch
            } // end try
            catch(InputMismatchException e)
            {
                System.out.println("ERROR: Invalid input.");
                scan.nextLine();
            } // end catch
        }while(choice !=8 ); // end while loop
    }

    /**
     * Returns the value of nodeCount
     * @return int
     */
    public int getNodeCount()
    {
        return nodeCount;
    } // end getNodeCount()
}
