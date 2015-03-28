/**
 * Created by John on 5/23/14.
 *
 * Class Name: Queue
 */
public class Queue
{
    private Ecountry[] ecountry;
    private int front, rear, maxSize, nItems;

    /**
     * Queue constructor. Creates an array of Ecountry
     * based on the parameter passed into the constructor.
     * Initializes pointer variables
     * @param nElems
     */
    public Queue(int nElems)
    {
        maxSize = nElems;
        ecountry = new Ecountry[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    } // end Queue constructor

    /**
     * Inserts an Ecountry object at the rear of the queue
     * @param country
     */
    public void insert(Ecountry country)
    {
        if(rear == maxSize-1)
            rear = -1;
        ecountry[++rear] = new Ecountry(country.getqVar(), country.getCountryName(), country.getCapitalName(), country.getregName(), country.getRegionNbr(), country.getCapitalPop());
        nItems++;
    } // end insert()

    /**
     * Removes an Ecountry object from the front of the queue
     * @return Ecountry
     */
    public Ecountry remove()
    {
        Ecountry temp = ecountry[front++];
        if (front == maxSize)
            front = 0;
        nItems--;
        return temp;
    } // end remove()

    /**
     * Checks to see if the queue is empty
     * @return boolean
     */
    public boolean isEmpty()
    {  // true if queue is empty
        return (nItems==0);
    } // end isEmpty()
} // end Queue class