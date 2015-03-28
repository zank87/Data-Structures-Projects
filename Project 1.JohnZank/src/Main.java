/**
 * Created by John on 5/15/14.
 * Project 1
 */

import java.io.*;

public class Main
{

    public static void main(String[] args) throws IOException
    {
        int maxElems = 100, searchKeyIn = 0, regNum, capPop;
        String inputString, country, cap, regName;
        EcountryCollection europe = new EcountryCollection(maxElems);
        FileReader fr = new FileReader("Countries.txt");
        BufferedReader br1 = new BufferedReader(fr);
        inputString = br1.readLine();
        while (inputString != null)
        {
            country = inputString.substring(0, 13).trim();
            cap = inputString.substring(15, 36).trim();
            regName = inputString.substring(37, 58).trim();
            regNum = Integer.parseInt(inputString.substring(64, 66).trim());
            capPop = Integer.parseInt(inputString.substring(inputString.lastIndexOf(' ') + 1));
            europe.insert(country, cap, regName, regNum, capPop);
            inputString = br1.readLine();
        } //end while loop
        br1.close();

        FileReader fr2 = new FileReader("SearchTrans.Summer2014.txt");
        BufferedReader br2 = new BufferedReader (fr2);
        String[] searchKey =  new String[maxElems];
        inputString = br2.readLine();
        while (inputString != null)
        {
            searchKey[searchKeyIn] = inputString.trim();
            inputString = br2.readLine();
            searchKeyIn++;
        }

        europe.display();
        europe.selectionSort();
        europe.display();

        System.out.format("\n\n%-20s\n", " Results of Sequential Search\n");
        System.out.format("%-20s %-20s %-10s\n ", " Search Key", "Probes", "Found");
        System.out.println("----------------------------------------------");
        for(int i = 0; i < searchKeyIn; i++ )
            if(europe.binSearch(searchKey[i]) != europe.size() )
                System.out.format("%-20s %-20s %-10s\n", " "+searchKey[i], europe.getProbeCount(), "true");
            else
                System.out.format("%-20s %-20s %-10s\n", " " + searchKey[i], europe.getProbeCount(), "false");



        System.out.format("\n\n%-20s\n", " Results of Binary Search\n");
        System.out.format("%-20s %-20s %-10s\n ", " Search Key", "Probes", "Found");
        System.out.println("----------------------------------------------");
        for(int i = 0; i < searchKeyIn; i++ )
            if(europe.seqSearch(searchKey[i]) )
                System.out.format("%-20s %-20s %-10s\n", " "+searchKey[i], europe.getProbeCount(), "true");
            else
                System.out.format("%-20s %-20s %-10s\n", " " + searchKey[i], europe.getProbeCount(), "false");
    } // end main
} // end public class main
