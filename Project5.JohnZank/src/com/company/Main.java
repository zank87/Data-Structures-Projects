package com.company;

import java.io.IOException;

public class Main
{

    public static void main(String[] args) throws IOException
    {
        HashTable theTable = new HashTable(23);
        theTable.readFile("ECountriesTrees.txt", "r");
        theTable.displayTable();
        theTable.readFile("ECountries.Summer2014.txt", "r");
        System.out.println("\n        Updated ");
        theTable.displayTable();
        System.out.println("\n       Error List ");
        System.out.println("=======================");
        theTable.readFile("error_file.txt", "d");
        theTable.deleteErrorFile();
    }
}
