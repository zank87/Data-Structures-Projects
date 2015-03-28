package com.company;

/**
 * @author John Zank. Link class provides the blueprint for each individual link in a linked list.
 */

class Link
{
    private int iData;
    private Link next;
    private Link previous;

    /**
     * Link class constructor. Creates a link object with the integer parameter that was passed.
     * @param id integer
     */
    public Link (int id)	// Constructor
    {
    iData = id;
    }  // end Constructor

    /**
     * Returns integer variable iData
     * @return int
     */
    public int getData()
    {
        return iData;
    } // end getDataIO

    /**
     * Access next variable.
     * @return Link
     */
    public Link getNext()
    {
        return next;
    }

    /**
     * Access previous variable.
     * @return Link
     */
    public Link getPrevious()
    {
        return previous;
    }

    /**
     * Set next variable.
     * @param lNext Link
     */
    public void setNext(Link lNext)
    {
        next = lNext;
    }

    /**
     * Set previous variable.
     * @param lPrevious Link
     */
    public void setPrevious(Link lPrevious )
    {
        previous = lPrevious;
    }
 } // end class Link
