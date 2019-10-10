package Homework3;



/**
 * @author Junjian Zhu R05
 *    e-mail: junjian.zhu@Stonybrook.edu
 *    Stony Brook ID: 111384808
 **/

public class Block {
    private static int MAX_VARIABLE = 10;
    private Variable[] variables = new Variable[MAX_VARIABLE];
    private int size = 0;

    public static int getMaxVariable() {
        return MAX_VARIABLE;
    }

    public static void setMaxVariable(int maxVariable) {
        MAX_VARIABLE = maxVariable;
    }

    /**
     * empty constructor
     */
    public Block(){}

    /**
     *
     * @param variables block is an object that consists variable arrays
     */

    public Block(Variable[] variables){
        this.variables = variables;
    }

    public Variable[] getVariables() {
        return variables;
    }

    public int getSize() {
        return size;
    }

    public void addVariable(Variable var){
        variables[size] = var;
        size++;
    }

    /**
     * print all the variables with in the block
     */
    public void print(){
        System.out.printf("%-30s","Variable name");
        System.out.printf("%-30s","Initial Value");
        System.out.println();
        for(int i=0; i<size; i++){
            System.out.printf("%-30s",variables[i].getName());
            System.out.printf("%-30s",variables[i].getInitialValue());
            System.out.println();
            if(i==size-1)
            System.out.println();
        }
    }

    /**
     * if found the variable within the block with the same name, return a true boolean value
     * and print that variable
     * @param name go through all the variable names and find out whether this variable exists
     * @return print out the variable if exist and return true; if not exist, return false.
     */
    public boolean psVar(String name){
        for(int i=0; i<size; i++){
            if(variables[i].getName().equals(name)){
                System.out.printf("%-30s","Variable name");
                System.out.printf("%-30s","Initial Value");
                System.out.println();
                System.out.printf("%-30s",variables[i].getName());
                System.out.printf("%-30s",variables[i].getInitialValue());
                System.out.println();
                System.out.println();
                return true;
            }
        }
        return false;
    }
}
