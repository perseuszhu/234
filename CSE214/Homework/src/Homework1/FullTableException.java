package Homework1;


/**
 * @author Junjian Zhu
 *    e-mail: junjian.zhu@Stonybrook.edu
 *    Stony Brook ID: 111384808
 **/


public class FullTableException extends Exception {
    private int MAX_APPLICANT;
    public FullTableException(int MAX_APPLICANT){
        this.MAX_APPLICANT = MAX_APPLICANT;
        System.out.println("Full Table Exception!");
    }

    public int getMAX_APPLICANT() {
        return MAX_APPLICANT;
    }
}
