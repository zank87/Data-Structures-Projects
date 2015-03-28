import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by John on 5/23/14.
 *
 */
public class Main {
    public static void main(String[] args) throws IOException
    {
        int maxElems = 100,  regNum, capPop;
        String inputString, country, cap, regName, inputVar;
        Queue transQ = new Queue(maxElems);
        PriorityQueue pQ1, pQ2, pQ3, pQ4;
        pQ1 = new PriorityQueue(maxElems);
        pQ2 = new PriorityQueue(maxElems);
        pQ3 = new PriorityQueue(maxElems);
        pQ4 = new PriorityQueue(maxElems);
        boolean modPQ1 = false;
        boolean modPQ2 = false;
        boolean modPQ3 = false;
        boolean modPQ4 = false;

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
            Ecountry temp = new Ecountry(null, country, cap, regName, regNum, capPop);
            if(regNum == 1)
                pQ1.insert(temp);
            if(regNum == 2)
                pQ2.insert(temp);
            if(regNum == 3)
                pQ3.insert(temp);
            if(regNum == 4)
                pQ4.insert(temp);
            inputString = br1.readLine();
        } //end while loop
        br1.close();

        pQ1.display();
        pQ2.display();
        pQ3.display();
        pQ4.display();

        FileReader fr1 = new FileReader("PQTrans.Summer2014.txt");
        BufferedReader br2 = new BufferedReader(fr1);
        inputString = br2.readLine();
        while (inputString != null)
        {
            int strLeng = inputString.length();
            inputVar = inputString.substring(0,1).trim();
            if(inputVar.equals("R"))
            {
                regNum = Integer.parseInt(inputString.substring(2, strLeng).trim());
                Ecountry temp = new Ecountry(inputVar ,null, null, null, regNum, 0);
                transQ.insert(temp);
            } // end if loop
            if(inputVar.equals("I"))
            {
                country = inputString.substring(6, 15).trim();
                cap = inputString.substring(18, 23).trim();
                regName = inputString.substring(28, 44).trim();
                regNum = Integer.parseInt(inputString.substring(47, 48).trim());
                capPop = Integer.parseInt(inputString.substring(inputString.lastIndexOf(' ') + 1));
                Ecountry temp = new Ecountry(inputVar, country, cap, regName, regNum, capPop);
                transQ.insert(temp);
            } // end if loop
            inputString = br2.readLine();
        }// end while loop
        br2.close();
        System.out.println("\n");

        while(!transQ.isEmpty())
        {
            Ecountry transItem =  transQ.remove();
            if(transItem.getqVar().equals("I"))
            {
                if(transItem.getRegionNbr() == 1)
                {
                    System.out.println("Object "+transItem.getCapitalName()+" has been added to Priority Queue "+transItem.getRegionNbr());
                    pQ1.insert(transItem);
                    modPQ1 = true;
                }
                if(transItem.getRegionNbr() == 2)
                {
                    System.out.println("Object "+transItem.getCapitalName()+" has been added to Priority Queue "+transItem.getRegionNbr());
                    pQ2.insert(transItem);
                    modPQ2 = true;
                }
                if(transItem.getRegionNbr() == 3)
                {
                    System.out.println("Object "+transItem.getCapitalName()+" has been added to Priority Queue "+transItem.getRegionNbr());
                    pQ3.insert(transItem);
                    modPQ3 = true;
                }
                if(transItem.getRegionNbr() == 4)
                {
                    System.out.println("Object "+transItem.getCapitalName()+" has been added to Priority Queue "+transItem.getRegionNbr());
                    pQ4.insert(transItem);
                    modPQ4 = true;
                }
            }// end if("I")
            if(transItem.getqVar().equals("R"))
            {
                if(transItem.getRegionNbr() == 1)
                {
                    System.out.println("Object "+pQ1.remove().getCapitalName()+" has been removed from Priority Queue 1");
                    modPQ1 = true;
                }
                if(transItem.getRegionNbr() == 2)
                {
                    System.out.println("Object "+pQ2.remove().getCapitalName()+" has been removed from Priority Queue 2");
                    modPQ2 = true;
                }
                if(transItem.getRegionNbr() == 3)
                {
                    System.out.println("Object " + pQ3.remove().getCapitalName() + " has been removed from Priority Queue 3");
                    modPQ3 = true;
                }
                if(transItem.getRegionNbr() == 4)
                {
                    System.out.println("Object "+pQ4.remove().getCapitalName()+" has been removed from Priority Queue 4");
                    modPQ4 = true;
                }
            } // end if("R")
        } // end while loop

        if(modPQ1)
            pQ1.display();
        if(modPQ2)
            pQ2.display();
        if(modPQ3)
            pQ3.display();
        if(modPQ4)
            pQ4.display();
    } // end main method
} // end main class
