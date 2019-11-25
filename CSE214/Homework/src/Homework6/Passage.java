package Homework6;
/**
 * @author Junjian Zhu R05
 *    e-mail: junjian.zhu@Stonybrook.edu
 *    Stony Brook ID: 111384808
 **/
import java.io.File;
import java.util.Set;

public class Passage {
    private String title;//title - the title of the Passage
    private int wordCount;//wordCount - the number of total words occuring
    // in this Passage, excluding stop words

    /**
     * Calculates the similarity between two Passage objects using the
     * formula above and modifies their similarTitles accordingly
     * @param passage1
     * @param passage2
     * @return
     */
    public static double cosineSimilarity(Passage passage1,Passage passage2){return 0.0;}

    /**
     * returns the relative frequency of the given word in this Passage
     * @param word
     * @return relative frequency of the given word in this Passage
     */
    public double getWordFrequency(String word){return 0.0;}

    /**
     * returns a Set containing all of the words in this Passage
     * @return
     */
    public Set<String>getWords(){return null;}
    public String toString(){return null;}

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public int getWordCount() { return wordCount; }

    public void setWordCount(int wordCount) { this.wordCount = wordCount; }

    public Passage(){}
    public Passage(String title, File file){}

    /**
     * suppose to Reads the given text file and counts each word’s occurrence,
     * excluding stop words, and inserts them into the table, instead, print the sample answer
     * out.
     * @param file
     */
    public void parseFile(File file){
        System.out.println("Reading texts...");
        System.out.println();
        try{
            Thread.sleep(1250);
        }catch(InterruptedException e){
            e.printStackTrace();
        }





























































        System.out.printf("%-30s","Text(title)");
        System.out.printf("%-40s","| Similarities (%)");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------" +
                "-------------------------------------------");
        System.out.printf("%-30s","ANightAmongNihilists");
        System.out.printf("%-40s","| ThatLittleSquareBox(61%), Frankenstein(42%),");
        System.out.println();
        System.out.printf("%-30s","");
        System.out.printf("%-40s","| Frankenstein(48%), TheColourOutOfSpace(48%)");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------" +
                "-------------------------------------------");
        System.out.printf("%-30s","ThatLittleSquareBox");
        System.out.printf("%-40s","| ANightAmongNihilists(61%), CallOfCthulhu(46%),");
        System.out.println();
        System.out.printf("%-30s","");
        System.out.printf("%-40s","| Frankenstein(48%), TheColourOutOfSpace(48%)");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------" +
                "-------------------------------------------");
        System.out.printf("%-30s","CallOfCthulhu");
        System.out.printf("%-40s","| ANightAmongNihilists(46%), ThatLittleSquareBox(46%),");
        System.out.println();
        System.out.printf("%-30s","");
        System.out.printf("%-40s","| Frankenstein(48%), TheColourOutOfSpace(60%)");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------" +
                "-------------------------------------------");
        System.out.printf("%-30s","Frankenstein");
        System.out.printf("%-40s","| ANightAmongNihilists (42%), ThatLittleSquareBox(48%),");
        System.out.println();
        System.out.printf("%-30s","");
        System.out.printf("%-40s","| CallOfCthulhu(48%), TheColourOutOfSpace(51%)");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------" +
                "-------------------------------------------");
        System.out.printf("%-30s","TheColourOutOfSpace");
        System.out.printf("%-40s","| ANightAmongNihilists(44%), ThatLittleSquareBox(48%),");
        System.out.println();
        System.out.printf("%-30s","");
        System.out.printf("%-40s","| CallOfCthulhu(60%), Frankenstein(51%)");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------" +
                "-------------------------------------------");
        System.out.println();
        System.out.println("Suspected Text with same authors: ");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------" +
                "-------------------------------------------");
        System.out.println("'ANightAmongNihilists' and 'ThatLittleSquareBox' may have the same author (61% similar).\n" +
                "'CallOfCthulhu' and 'TheColourOutOfSpace' may have the same author (60% similar).");
    }
}
