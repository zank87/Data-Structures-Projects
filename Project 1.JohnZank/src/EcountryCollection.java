
/**
 * Created by John on 5/15/14
 *
 *
 * Class Description: EcountryCollection creates and stores an array of Ecountry objects. It contains
 *                    methods that sort, search, and display the array.
 */
public class EcountryCollection
{
    private Ecountry[] ecountries;  // ref to array ecountries
    private int nElems=0;
    private int probeCount;

    public EcountryCollection(int maxSize)
    {
        ecountries = new Ecountry[maxSize];

    } // end EcountryCollection constructor


    /**
     * Reads data from input stream that is passed into insert method, initialize a new
     * ecountry object and passes parameters for the constructor to assign to each
     * respective variable
     * @param country
     * @param capital
     * @param region
     * @param regionNum
     * @param pop
     */
    public void insert(String country, String capital, String region, int regionNum, int pop)
    {
        ecountries[nElems] = new Ecountry(country, capital, region, regionNum, pop);
        nElems++;
    } // end insert()
    /**
     * Displays array contents
     */
    public void display()
    {
        System.out.format("\n\n%-20s %-20s %-15s %15s %20s\n", "Country", "Capital", "Region", "Region_Nmbr", "Capital Population");//Formats headers for information
        System.out.println("------------------------------------------------------------------------------------------------------");
        for(int j=0; j<nElems; j++)
            System.out.format("\n%-20s %-20s %-15s %15s %20s\n", ecountries[j].getCountryName(), ecountries[j].getCapitalName(), ecountries[j].getregName(), ecountries[j].getRegionNbr(), ecountries[j].getCapitalPop() + "\n");  // display it
    } //end display()

    /**
     * Sorts array by passing through the array and picking the smallest variable and assigns it to the first index
     */
    public void selectionSort()
    {
        int out, in, min;

        for(out=0; out<nElems-1; out++)   // outer loop
        {
            min = out;                     // minimum
            for(in=out+1; in<nElems; in++) // inner loop
                if(ecountries[in].getCountryName().compareTo(ecountries[min].getCountryName()) < 0 )
                    min = in;               // new min
            swap(out, min);                // swap them
        }  // end for(out)
    }  // end selectionSort()

    /**
     * Used during selection sort to swap variables index positions.
     * @param one
     * @param two
     */
    private void swap(int one, int two)
    {
        Ecountry temp  = ecountries[one];
        ecountries[one] = ecountries[two];
        ecountries[two] = temp;
    } // end swap()

    /**
     * Returns the amount of elements
     * @return int
     */
    public int size() // passing size of array
    {
        return nElems;
    } // end size()

    /**
     * Returns the number of probes counted after a search
     * @return int
     */
    public int getProbeCount()
    {
        return probeCount;
    } // end getProbeCount()

    /**
     * Searches by cutting array in half and determining whether the search key is greater or less than the mid range
     * index, then searches in either the upperbound or lowerbound. If searchKey is found it returns the index found it, else it returns
     * the total number of elements which means the search key was not found.
     * @param searchKey
     * @return int
     */
    public int binSearch (String searchKey)
    {
        probeCount = 0;
        int lowerBound = 0;
        int upperBound = nElems-1;		                  // if array size is 50, bounds = 0, 49
        int curIn;				  	// ‘curIn’ = current index
        while (true)
        {
            curIn = (lowerBound + upperBound) / 2;	//set curIn to middle of range.
            if (ecountries[curIn].getCountryName().compareTo(searchKey) == 0)
            {
                probeCount++;
                return  curIn;		// found target,  Great!
            } // end if
            else
                if (lowerBound > upperBound)
                {
                    return nElems;	// can’t find it.  End of routine.
                } // end if
                else			// adjust bounds of ‘array.’
                    {
                    if (ecountries[curIn].getCountryName().compareTo(searchKey) < 0)
                    {
                        probeCount++;
                        lowerBound = curIn + 1;  // look in upper half
                    } // end if
                    else
                    {
                        probeCount++;
                        upperBound = curIn - 1;  // look in lower half
                    } // end else
                }  // end else divide range
        } // end while
    } // end find()

    /**
     * Searches the array at one index at a time until the entire index has been searched. If
     * the searchKey has been found then it will return true otherwise it will return false.
     * @param searchKey
     * @return boolean
     */
    public boolean seqSearch (String searchKey)
    {
        probeCount = 0;
        int i;
        for(i = 0; i < nElems; i++)
        {
            probeCount++;
            if(ecountries[i].getCountryName().equals(searchKey))
                break;
        } // end for loop
        if(i == nElems) // reached the end of array, item not found
            return false;
        else
            return true; // did not reach end of array, item found
    } // end seqSearch()
} // end CountryCollection class
