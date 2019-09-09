package Homework1;


/**
 * @author Junjian Zhu
 *    e-mail: junjian.zhu@Stonybrook.edu
 *    Stony Brook ID: 111384808
 **/


public class EmptyTableException extends Exception {
    private int MAX_APPLICANT;
    public EmptyTableException(int MAX_APPLICANT){
        this.MAX_APPLICANT = MAX_APPLICANT;
    }

    public int getMAX_APPLICANT() {
        return MAX_APPLICANT;
    }
}
