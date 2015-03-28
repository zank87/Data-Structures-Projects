package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * @author John Zank on 6/17/14.
 *
 */
public class IO
{
    private int nElems = 0, rear, maxSize;
    private String[] data;
    private Queue qArray;
    private TreeCollection theTree;

    /**
     * IO constructor. Initializes the string array, queue, and binary tree.
     * @param nItems int
     */
    public IO(int nItems)
    {
        theTree = new TreeCollection();
        data = new String[nItems];
        qArray = new Queue(nItems);
        rear = -1;
    }

    /**
     * Reads input file and passes it into the insert method.
     * @throws IOException
     */
    public void readFile() throws IOException
    {
        String inputString, temp;
        FileReader fr = new FileReader("ECountriesTrees.txt");
        BufferedReader br1 = new BufferedReader(fr);
        inputString = br1.readLine();

        while (inputString != null)
        {
            temp = inputString.substring(0);
            insert(temp);
            inputString = br1.readLine();
        }// end while loop
        br1.close();
    }// end readFile()

    /**
     * Constructs string array.
     * @param input String
     */
    public void insert(String input)
    {
        if(rear == maxSize-1)
            rear = -1;
        data[++rear] = input;
        nElems++;
    }

    /**
     * Displays the queue.
     */
    public void display()
    {
        for(int j=0; j<nElems; j++)
        {
            parseInsertQ(data[j]);
        }
        System.out.println("\n              Queue of Tree Objects ");
        System.out.printf("%-20s %-10s %14s", "Country Name", "Capital", "Population");
        System.out.println("\n==============================================");
        qArray.displayQ();
    }

    /**
     * Parses the input string with a string tokenizer and passes it into the insert queue and insert tree methods.
     * @param input String
     */
    public void parseInsertQ (String input)//parse and insert into traditional queue
    {
        String countryName, countryCapital;
        int capitalPopulation;
        StringTokenizer st = new StringTokenizer(input, ",");

        while(st.hasMoreTokens())
        {
            countryName = st.nextToken();
            countryCapital = st.nextToken();
            capitalPopulation = Integer.parseInt(st.nextToken());
            qArray.insertQ(countryName, countryCapital, capitalPopulation);
            theTree.insertT(countryName, countryCapital, capitalPopulation);
        }
    }

    /**
     * Displays the binary tree LNR.
     */
    public void displayTreeLNR()
    {
        System.out.println("\n       Recursive LNR Scan ");
        System.out.printf("%-20s %-10s", "Country Name", "Capital");
        System.out.println("\n===============================");
        theTree.lnr(theTree.root);
        System.out.println();
    }

    /**
     * Displays the binary tree RNL.
     */
    public void displayTreeRNL()
    {
        System.out.println("\n       Recursive RNL Scan ");
        System.out.printf("%-20s %-10s", "Country Name", "Capital");
        System.out.println("\n===============================");
        theTree.rnl(theTree.root);
        System.out.println();
    }

    /**
     * Displays the binary iteratively LNR.
     */
    public void displayTreeItLNR()
    {
        System.out.println("\n       Iterative LNR Scan ");
        System.out.printf("%-20s %-10s", "Country Name", "Capital");
        System.out.println("\n===============================");
        theTree.lnrIterative();
        System.out.println();
    }

    /**
     * Displays the binary tree iteratively RNL.
     */
    public void displayTreeItRNL()
    {
        System.out.println("\n       Iterative RNL Scan ");
        System.out.printf("%-20s %-10s", "Country Name", "Capital");
        System.out.println("\n===============================");
        theTree.rnlIterative();
        System.out.println();
    }

    /**
     * Invokes the delete method from the Tree Collections class
     * @param key String
     */
    public void deleteTreeNode(String key)
    {
        theTree.delete(key);
    }
}
