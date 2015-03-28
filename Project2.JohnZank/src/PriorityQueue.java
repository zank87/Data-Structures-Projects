/**
 * Created by John on 5/23/14.
 *
 * Class Name: Priority Queue
 */
public class PriorityQueue
{
    private Ecountry[] ecountry;
    private int maxSize, nItems;

    /**
     * Priority queue constructor.
     * Creates an Ecountry array the size of the passed parameter.
     * Initializes nItems to 0;
     * @param nElems
     */
    public PriorityQueue(int nElems)
    {
        maxSize = nElems;
        ecountry = new Ecountry[maxSize];
        nItems = 0;
    } // end PriorityQueue constructor

    /**
     * Inserts an Ecountry object into the priority queue.
     * It's position within the queue is based on the population.
     * @param country
     */
    public void insert(Ecountry country)
    {
        int j;
        if (nItems==0)
            ecountry[nItems++] = new Ecountry(null, country.getCountryName(), country.getCapitalName(), country.getregName(), country.getRegionNbr(), country.getCapitalPop());
        else
        {
            for (j=nItems-1; j>=0; j--)
            {
                if (country.getCapitalPop() > ecountry[j].getCapitalPop() )
                    ecountry[j+1] = ecountry[j];
                else
                    break;
            } // end for loop
        ecountry[j+1]= new Ecountry(null, country.getCountryName(), country.getCapitalName(), country.getregName(), country.getRegionNbr(), country.getCapitalPop());
        nItems++;
        } // end else
    } // end insert()

    /**
     * Removes the first element of the priority queue
     * @return Ecountry
     */
    public Ecountry remove()
    {
        return ecountry[--nItems];
    } // end remove()

    /**
     * Displays all elements within the priority queue
     */
    public void display()
    {
        System.out.println("\n\nRegion "+ecountry[0].getRegionNbr()+": "+ecountry[0].getregName());
        for(int j=0; j<nItems; j++)
            System.out.format("\n%-20s %-20s"+"%,20d", ecountry[j].getCapitalName(), ecountry[j].getCountryName(), ecountry[j].getCapitalPop());  // display it
    } // end display()
} // end PriorityQueue class