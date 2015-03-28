/**
 * Created by John on 5/15/14.
 *
 * Class Description: Basic template for countries read from the Countries.txt file.
 *                    Stores 5 basic variables: Country name, capital name, region name
 *                    region number, and capital population.
 */
public class Ecountry
{
    private String qVar;
    private String countryName;
    private String capName;
    private String regName;
    private int regNum;
    private int capPop;


    /**
     * Constructs Ecountry object by passing each respective parameter to the private variables
     * @param country
     * @param capital
     * @param region
     * @param regionNum
     * @param pop
     */
    public Ecountry(String pVar, String country, String capital, String region, int regionNum, int pop)
    {
        qVar = pVar;
        countryName = country;
        capName = capital;
        regName = region;
        regNum = regionNum;
        capPop = pop;
    } // closes Ecountry() constuctor

     /**
     * Returns all variables attached to the ecountry object in string format
     * @return String
     */
    @Override
    public String toString()
    {
        return countryName + " " + capName +  " " + regName +  " " + regNum + " " + capPop;
    } // closes toString()

    /**
     * Returns the qVariable
     * @return String
     */
    public String getqVar()
    {
        return qVar;
    }

     /**
     * Returns the Country Name
     * @return String
     */
    public String getCountryName()
    {
        return countryName;
    } // closes getCountryName()

    /**
     * Returns the Capital Name
     * @return String
     */
    public String getCapitalName()
    {
        return capName;
    } // closes getCapitalName()

    /**
     * Returns the Region Name
     * @return String
     */
    public String getregName()
    {
        return regName;
    } // closes getregName()

    /**
     * Returns the Region Number
     * @return int
     */
    public int getRegionNbr()
    {
        return regNum;
    } // closes getRegionNbr()

    /**
     * Returns the Capital Population
     * @return int
     */
    public int getCapitalPop()
    {
        return capPop;
    } // closes getCapitalPop()

    /**
     * Sets the qVariable
     * @param theVariable
     */
    public void setqVar(String theVariable)
    {
        qVar = theVariable;
    }

     /**
     * Sets the Country Name
     * @param country
     */
    public void setCountry(String country)
    {
        countryName = country;
    } // closes setCountry()

    /**
     * Sets the Capital Name
     * @param capital
     */
    public void setCapital(String capital)
    {
        capName = capital;
    } // closes setCapital()

    /**
     * Sets the Region Name
     * @param region
     */
    public void setRegionName(String region)
    {
        regName = region;
    } // closes setRegionName()

    /**
     * Sets the RegionNumber
     * @param regionNbr
     */
    public void setRegionNumber(int regionNbr)
    {
        regNum = regionNbr;
    } // closes setRegionNumber()

    /**
     * Sets the Capital Population
     * @param capitalPop
     */
    public void setCapitalPopulation(int capitalPop)
    {
        capPop = capitalPop;
    } // closes setCapitalPopulation()
} // end Ecountry class
