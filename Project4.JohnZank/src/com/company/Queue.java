package com.company;


/**
 * @author John Zank on 6/17/14.
 *
 */
public class Queue {

    private Node[] treeObjects;
    private int rear, maxSize, nElems = 0;

    /**
     * Queue constructor. Creates an array of Nodes.
     * @param nElems int
     */
    public Queue(int nElems)
    {
        treeObjects = new Node[nElems];
        rear = -1;
    }

    /**
     * Inserts into the queue.
     * @param name String
     * @param capital String
     * @param population int
     */
    public void insertQ(String name, String capital, int population)
    {
        if(rear == maxSize-1)
            rear = -1;
        treeObjects[++rear] = new Node(name, capital, population);
        nElems++;
    }

    /**
     * Displays the queue.
     */
    public void displayQ()
    {
        for(int i=0; i< nElems; i++)
        {
            System.out.printf("%-20s %-10s %,14d\n", treeObjects[i].getCountryName(), treeObjects[i].getCountryCapital(), treeObjects[i].getCapitalPopulation());
        }
    }
}
