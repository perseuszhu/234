package Homework4;

/**
 * @author Junjian Zhu R05
 *    e-mail: junjian.zhu@Stonybrook.edu
 *    Stony Brook ID: 111384808
 **/

public class Bigram {
    private char first;
    private char second;

    /**
     * Empty constructor
     */
    public Bigram(){}

    /**
     *
     * @param first first character in the Bigram
     * @param second Second character in the Bigram
     */
    public Bigram(char first, char second){
        this.first = first;
        this.second = second;
    }

    /**
     * getters and setters
     * @return the value within a Bigram and set the value of a Bigram
     */
    public char getFirst() {
        return first;
    }

    public void setFirst(char first) {
        this.first = first;
    }

    public char getSecond() {
        return second;
    }

    public void setSecond(char second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Bigram{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
