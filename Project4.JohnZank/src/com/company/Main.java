package com.company;

import java.io.IOException;

/**
 * @author John Zank on 6/17/14.
 *
 */
public class Main {

    public static void main(String[] args) throws IOException
    {
        IO io = new IO(21);
        io.readFile();
        io.display();
        io.displayTreeLNR();
        io.displayTreeRNL();
        io.displayTreeItLNR();
        io.displayTreeItRNL();
        io.deleteTreeNode("Belarus");
        io.deleteTreeNode("Ukraine");
        io.deleteTreeNode("Latvia");
        io.displayTreeLNR();
        io.deleteTreeNode("Denmark");
        io.deleteTreeNode("Norway");
        io.displayTreeLNR();
        io.deleteTreeNode("Sweden");
        io.deleteTreeNode("Estonia");
        io.displayTreeLNR();
    }
}
