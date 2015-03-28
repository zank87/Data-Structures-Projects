package com.company;

import java.io.*;
import java.util.StringTokenizer;

class Link
{
    public Link next;
    private String cName, cCap;

    public Link(String count, String cap)
    {
        cName = count;
        cCap = cap;
    } // end Link constructor

    public void displayLink()
    {
        System.out.printf("%-5s   ", cName);
    } // end displayLink()

    public String getcName()
    {
        return cName;
    } // end getcName()
}  // end class Link

class SortedList
{
    private Link first;

    public SortedList()
    {
        first = null;
    } // end SortedList()

    public void insert(Link theLink)
    {
        String key = theLink.getcName();
        Link previous = null;
        Link current = first;
        while(current != null && key.compareTo(current.getcName()) > 0)
        {
            previous = current;
            current = current.next;
        } // end while loop
        if(previous==null)
            first = theLink;
        else
            previous.next = theLink;
        theLink.next = current;
    }  // end insert()

    public void delete(String key)
    {
        Link previous = null;
        Link current = first;

        while(current != null && !key.equals(current.getcName()))
        {
            previous = current;
            current = current.next;
        } // end while loop
        if(previous==null)
            first = first.next;
        else
            previous.next = current.next;
    }  // end delete()

    public Link find(String key)
    {
        Link current = first;
        // until end of list,
        while(current != null &&  current.getcName().compareTo(key) <= 0)
        {
            if(current.getcName().equals(key))
                return current;
            current = current.next;
        } // end while loop
        return null;
    }  // end find()

    public void displayList()
    {
        Link current = first;
        while(current != null)
        {
            current.displayLink();
            current = current.next;
        } // end while loop
        System.out.println("");
    } // end displayList
}  // end class SortedList

class HashTable
{
    private SortedList[] hashArray;
    private int arraySize;

    public HashTable(int size) throws IOException
    {
        arraySize = size;
        hashArray = new SortedList[arraySize];
        for(int j=0; j<arraySize; j++)
            hashArray[j] = new SortedList();
    } // end HashTable constructor

    public void displayTable()
    {
        System.out.println("      Hash Table ");
        System.out.printf("%-9s %-10s", "Index", "Country Name");
        System.out.println("\n======================");
        for(int j=0; j<arraySize; j++) // for each cell,
        {
            System.out.printf("%2s        ", j);
            hashArray[j].displayList();
        } // end for loop
    } // end displayTable()

    public int hashFunc3(String key)
    {
        String temp = key;
        key = temp.toLowerCase();
        int hashVal = 0;
        for(int j=0; j<key.length(); j++)
        {
            int letter = (key.charAt(j)-96);
            hashVal = (hashVal * 27 + letter) % arraySize;
        } // end for loop
        return hashVal;
    }  // end hashFunc3()

    public void insert(Link theLink)
    {
        String key = theLink.getcName();
        int hashVal = hashFunc3(key);
        hashArray[hashVal].insert(theLink);
    }  // end insert()

    public void delete(String key)
    {
        int hashVal = hashFunc3(key);
        hashArray[hashVal].delete(key);
    }  // end delete()

    public Link find(String key)
    {
        int hashVal = hashFunc3(key);
        Link theLink = hashArray[hashVal].find(key);
        return theLink;
    } // end find()

    public void readFile(String textFile, String io) throws IOException
    {
        String inputString, temp;
        FileReader fr = new FileReader(textFile);
        BufferedReader br = new BufferedReader(fr);
        inputString = br.readLine();
        if(io.equals("r"))
            while (inputString != null)
            {
                temp = inputString.substring(0);
                tokenStr(temp);
                inputString = br.readLine();
            }// end while loop
        else
            while (inputString != null)
            {
                System.out.println(inputString);
                inputString = br.readLine();
            }// end while loop
        br.close();
    } // end readFile()

    public void tokenStr (String input)
    {
        Link theLink;
        String countryName, countryCapital,update, garbage;
        StringTokenizer st = new StringTokenizer(input, ",");
        while (st.hasMoreTokens()) {
            update = st.nextToken();
            if(update.equalsIgnoreCase("a") || update.equalsIgnoreCase("d"))
            {
                if(update.equalsIgnoreCase("a"))
                {
                    countryName = st.nextToken();
                    theLink = new Link(countryName, update);
                    if(find(countryName) == null)
                        insert(theLink);
                    else
                        writeError("Duplicate Add: ", countryName);
                } // end if
                else
                {
                    countryName = st.nextToken();
                    if(find(countryName) != null)
                        delete(countryName);
                    else
                        writeError("Unable to find: ", countryName);
                } // end else
            } // end if
            else
            {
                countryName = update;
                countryCapital = st.nextToken();
                garbage = st.nextToken();
                theLink = new Link(countryName, countryCapital);
                insert(theLink);
            } // end else
        } // end while loop
    } // end tokenStr()

    public void writeError(String error, String country)
    {
        try
        {
            File file = new File("error_file.txt");
            BufferedWriter output = new BufferedWriter(new FileWriter(file, true));
            output.write(error + " " + country);
            output.newLine();
            output.close();
        } // end try
        catch ( IOException e )
        {
            e.printStackTrace();
        } // end catch
    } // end writeError

    public void deleteErrorFile()
    {
        File f = new File("error_file.txt");
        try
        {
            f.delete();
        } // end try
        catch(Exception e)
        {
            e.printStackTrace();
        } // end catch
    } // end deleteErrorFile()
}  // end class HashTable

