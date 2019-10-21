package Homework4;

import java.util.Scanner;
/**
 * @author Junjian Zhu R05
 *    e-mail: junjian.zhu@Stonybrook.edu
 *    Stony Brook ID: 111384808
 **/

public class PlayfairEncryptionEngine {
    /**
     * the main method
     * @param args
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean status = false;
        boolean initiate = false;
        String keyphrase = new String();
        /**
         * a loop that make sure unless selected, the program will continue working.
         */
        while(!status){
            while(!initiate){
                keyphrase = "";
                System.out.println("Enter key phrase");
                keyphrase = in.nextLine();
                if(keyphrase.equals("")){
                    System.out.println("Key Phrase empty, try again");
                }
                else{
                    System.out.println("Generation Success!");
                    System.out.println();
                    initiate = true;
                }

            }
            System.out.println("(CK) - Change key\n" +
                    "(PK) - Print key\n" +
                    "(EN) - Encrypt\n" +
                    "(DE) - Decrypt\n" +
                    "(Q) - Quit");
            System.out.println();
            System.out.println("Please select an option: ");
            String command = in.nextLine();
            if(command.equalsIgnoreCase("CK")){
//                System.out.println("Enter key phrase");
//                keyphrase = in.nextLine();
//                System.out.println("Generation Success!");
//                System.out.println();
                initiate = false;
            }
            if(command.equalsIgnoreCase("PK")){
                    KeyTable kt = new KeyTable();
                    kt.buildFromString(keyphrase);
                    kt.print();
                    System.out.println();
            }
            if(command.equalsIgnoreCase("EN")){
                System.out.println("Please enter a phrase to encrypt: ");
                String ph = in.nextLine();
                Phrase phrase = Phrase.buildPhraseFromStringforEnc(ph);
                KeyTable kt = new KeyTable();
                kt.buildFromString(keyphrase);
                phrase = phrase.encrypt(kt);
                System.out.println("Encrypted text is: "+phrase.toString());
                System.out.println();
            }
            if(command.equalsIgnoreCase("DE")){
                System.out.println("Please enter a phrase to decrypt: ");
                String ph = in.nextLine();
                Phrase phrase = Phrase.buildPhraseFromStringforEnc(ph);
                KeyTable kt = new KeyTable();
                kt.buildFromString(keyphrase);
                phrase = phrase.decrypt(kt);
                System.out.println("Decrypted text is: "+phrase.toString());
                System.out.println();
            }
            if(command.equalsIgnoreCase("Q")){
                status =true;
            }

        }

    }
}
