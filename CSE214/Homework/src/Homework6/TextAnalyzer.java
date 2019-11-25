package Homework6;
/**
 * @author Junjian Zhu R05
 *    e-mail: junjian.zhu@Stonybrook.edu
 *    Stony Brook ID: 111384808
 **/
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextAnalyzer {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        boolean status = false;
        while(!status) {
            System.out.println("Enter the directory of a folder of text files: ");
            String directoryPath = in.nextLine();
            File[] directoryOfFiles = new File(directoryPath).listFiles();
            ArrayList<Passage> filearray = new ArrayList<>();
            try {
                for (File i : directoryOfFiles) {
                    Passage pas = new Passage(i.getName(), i);
                    filearray.add(pas);
                }
                status = true;
            } catch (NullPointerException e) {
                System.out.println("File not found try again");
                System.out.println();

            }

            if (directoryOfFiles!= null) {
                filearray.get(0).parseFile(directoryOfFiles[0]);
            }

        }


    }
}
