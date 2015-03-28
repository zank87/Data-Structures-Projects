package com.company;

/**
 *
 * @author John Zank on 6/19/14.
 */
public class Node {

    private String countryName;
    private String countryCapital;
    private int capitalPopulation;
    public Node leftChild;
    public Node rightChild;

    /**
     * Node constructor. Passes parameters to initialize the node.
     * @param cName String
     * @param cCap String
     * @param cPop int
     */
    public Node(String cName, String cCap, int cPop)
    {
        countryName = cName;
        countryCapital = cCap;
        capitalPopulation = cPop;
    }

    /**
     * Returns the private string variable countryName.
     * @return String
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Returns the private string variable countryCapital.
     * @return String
     */
    public String getCountryCapital() {
        return countryCapital;
    }

    /**
     * Returns the private int variable capitalPopulation.
     * @return int
     */
    public int getCapitalPopulation() {
        return capitalPopulation;
    }
}