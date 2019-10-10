package Homework3;

/**
 * @author Junjian Zhu R05
 *    e-mail: junjian.zhu@Stonybrook.edu
 *    Stony Brook ID: 111384808
 **/

/**
 * Variable class.
 */
public class Variable {
    private String name;
    private int initialValue;

    /**
     * Empty constructor
     */
    public Variable(){}

    /**
     *
     * @param name variable name
     * @param initialValue variable initial value
     */
    public Variable(String name, int initialValue){
        this.name = name;
        this.initialValue = initialValue;
    }

    /**
     * getter and setters
     * @return requested value
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(int initialValue) {
        this.initialValue = initialValue;
    }

    public void print(Variable variables){
        System.out.printf("%-30s","Variable name");
        System.out.printf("%-30s","Initial Value");
        System.out.println();
        System.out.printf("%-30s",variables.getName());
        System.out.printf("%-30s",variables.getInitialValue());
        System.out.println();
    }
}
