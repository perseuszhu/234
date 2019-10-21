package Homework4;

import java.util.Arrays;
import java.util.Queue;

public class Phrase {
    private int maxSize;
    private int front;
    private int rear;
    private int nItems;
    private Bigram[] phrasearr;

    /**
     * Empty Constructor
     */
    public Phrase(){}

    /**
     * constructor of object phrase stating the maxsize of this phrase.
     * @param s the max number of Bigram object can be store within the phrase object.
     */
    public Phrase(int s){
        maxSize = s;
        phrasearr = new Bigram[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    /**
     * the method that can add a new element into the phrase object.
     * @param b The Bigram which is about the be added to the queue
     */
    public void enqueue(Bigram b){
        if(rear == maxSize-1)
          rear = -1;
          phrasearr[++rear] = b;
          nItems++;

    }
    public Bigram dequeue(){
        Bigram temp = phrasearr[front++];
        if(front==maxSize)
            front = 0;
        nItems--;
        return temp;
    }
    public Bigram peek(){
        return phrasearr[front];
    }
    public int size(){
        return nItems;
    }
    public boolean isEmpty(){
        return (nItems == 0);
    }

    /**
     * create a phrase and turn it into multiple Bigram then create a phrase object to store all
     * of them
     * @param s the String that is about to be covert in to Phrase
     * @return the phrase that have been created from the String s
     */
    public static Phrase buildPhraseFromStringforEnc(String s){
        /**
         * remove illegal characters and switching all 'j' into 'i'.
         */
        s = s.replaceAll(" ","");
        s = s.replaceAll("\\p{Punct}","");
        s = s.replaceAll("j","i");
        s = s.toUpperCase();
        int i=0;
        /**
         * add x in between a bigram that have the same character
         */
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(i+1)){
                StringBuffer newString = new StringBuffer(s);
                newString.insert(i+1,"X");
                s = newString.toString();
                i=i+2;
                if(i+1==s.length()){
                    s +="x";
                }
            }
            /**
             * adding x to the end of the string if the final result contains odd
             * numbers of characters.
             */
            else{
                i=i+2;
                if(i+1==s.length()){
                    s +="X";
                }
            }
        }
        /**
         * creating a phrase object to store all the Bigram that will be created by the
         * string that we just construct.
         */
        Phrase phrase = new Phrase(s.length()/2);
        for(int j=0; j<s.length(); j=j+2){
            Bigram temp = new Bigram();
            temp.setFirst(s.charAt(j));
            temp.setSecond(s.charAt(j+1));
            phrase.enqueue(temp);
        }
        return phrase;
    }

    /**
     * Encrypt method to covert that phrase which we just created to a code based on the keytable
     * that is already created.
     * @param key the keytable for the encryption
     * @return a phrase that have been encrpyted by another phrase.
     */
    public Phrase encrypt(KeyTable key){
        char ch1;
        char ch2;
        Phrase encrypted = new Phrase(this.phrasearr.length);
        for(int i=0; i<this.phrasearr.length; i++){
            Bigram temp = new Bigram();
            temp = this.phrasearr[i];
            int r1 = key.findRow(temp.getFirst());
            int c1 = key.findCol(temp.getFirst());
            int r2 = key.findRow(temp.getSecond());
            int c2 = key.findCol(temp.getSecond());
            /**
             * find out whether the two element in the Bigram shares the same row.
             */
            if(r1==r2){
                /**
                 * check whether they share the same column
                 */
                if(c1==c2){
                    /**
                     * check whether they are on the edge of the table.
                     */
                    if(c1==4){
                        ch1 = key.getKeyTable()[r1][0];
                        ch2 = ch1;
                        temp.setFirst(ch1);
                        temp.setSecond(ch2);
                        encrypted.enqueue(temp);
                    }
                    else{
                        ch1 = key.getKeyTable()[r1][c1+1];
                        ch2 = key.getKeyTable()[r2][c2+1];
                        temp.setFirst(ch1);
                        temp.setSecond(ch2);
                        encrypted.enqueue(temp);
                    }
                }
                else if(c1==4){
                    ch1 = key.getKeyTable()[r1][0];
                    ch2 = key.getKeyTable()[r2][c2+1];
                    temp.setFirst(ch1);
                    temp.setSecond(ch2);
                    encrypted.enqueue(temp);
                }
                else if(c2==4){
                    ch1 = key.getKeyTable()[r1][c1+1];
                    ch2 = key.getKeyTable()[r2][0];
                    temp.setFirst(ch1);
                    temp.setSecond(ch2);
                    encrypted.enqueue(temp);
                }
                else if(c1!=4&&c2!=4){
                    ch1 = key.getKeyTable()[r1][c1+1];
                    ch2 = key.getKeyTable()[r2][c2+1];
                    temp.setFirst(ch1);
                    temp.setSecond(ch2);
                    encrypted.enqueue(temp);
                }
            }
            else if(c1==c2){
               if(r1==r2){
                   if(r1==4){
                       ch1 = key.getKeyTable()[0][c1];
                       ch2 = ch1;
                       temp.setFirst(ch1);
                       temp.setSecond(ch2);
                       encrypted.enqueue(temp);
                   }
                   else{
                       ch1 = key.getKeyTable()[r1+1][c1];
                       ch2 = key.getKeyTable()[r2+1][c2];
                       temp.setFirst(ch1);
                       temp.setSecond(ch2);
                       encrypted.enqueue(temp);
                   }
               }
               else if(r1==4){
                   ch1 = key.getKeyTable()[0][c1];
                   ch2 = key.getKeyTable()[r2+1][c2];
                   temp.setFirst(ch1);
                   temp.setSecond(ch2);
                   encrypted.enqueue(temp);
               }
               else if(r2==4){
                   ch1 = key.getKeyTable()[r1+1][c1];
                   ch2 = key.getKeyTable()[0][c2];
                   temp.setFirst(ch1);
                   temp.setSecond(ch2);
                   encrypted.enqueue(temp);
               }
               else if(r1!=4&&r2!=4){
                   ch1 = key.getKeyTable()[r1+1][c1];
                   ch2 = key.getKeyTable()[r2+1][c2];
                   temp.setFirst(ch1);
                   temp.setSecond(ch2);
                   encrypted.enqueue(temp);
               }
            }
            else{
                ch1 = key.getKeyTable()[r1][c2];
                ch2 = key.getKeyTable()[r2][c1];
                temp.setFirst(ch1);
                temp.setSecond(ch2);
                encrypted.enqueue(temp);
            }
        }
        return encrypted;
    }

    /**
     * reverse method of the encrypt method. Everything is the same except switching everyting back.
     * @param key the table we are about to use to decrypt
     * @return the phrase that will be decrypted.
     */
    public Phrase decrypt(KeyTable key){
        char ch1;
        char ch2;
        Phrase encrypted = new Phrase(this.phrasearr.length);
        for(int i=0; i<this.phrasearr.length; i++){
            Bigram temp = new Bigram();
            temp = this.phrasearr[i];
            int r1 = key.findRow(temp.getFirst());
            int c1 = key.findCol(temp.getFirst());
            int r2 = key.findRow(temp.getSecond());
            int c2 = key.findCol(temp.getSecond());
            if(r1==r2){
                if(c1==c2){
                    if(c1==0){
                        ch1 = key.getKeyTable()[r1][4];
                        ch2 = ch1;
                        temp.setFirst(ch1);
                        temp.setSecond(ch2);
                        encrypted.enqueue(temp);
                    }
                    else{
                        ch1 = key.getKeyTable()[r1][c1-1];
                        ch2 = key.getKeyTable()[r2][c2-1];
                        temp.setFirst(ch1);
                        temp.setSecond(ch2);
                        encrypted.enqueue(temp);
                    }
                }
                else if(c1==0){
                    ch1 = key.getKeyTable()[r1][4];
                    ch2 = key.getKeyTable()[r2][c2-1];
                    temp.setFirst(ch1);
                    temp.setSecond(ch2);
                    encrypted.enqueue(temp);
                }
                else if(c2==0){
                    ch1 = key.getKeyTable()[r1][c1-1];
                    ch2 = key.getKeyTable()[r2][4];
                    temp.setFirst(ch1);
                    temp.setSecond(ch2);
                    encrypted.enqueue(temp);
                }
                else if(c1!=0&&c2!=0){
                    ch1 = key.getKeyTable()[r1][c1-1];
                    ch2 = key.getKeyTable()[r2][c2-1];
                    temp.setFirst(ch1);
                    temp.setSecond(ch2);
                    encrypted.enqueue(temp);
                }
            }
            else if(c1==c2){
                if(r1==r2){
                    if(r1==0){
                        ch1 = key.getKeyTable()[4][c1];
                        ch2 = ch1;
                        temp.setFirst(ch1);
                        temp.setSecond(ch2);
                        encrypted.enqueue(temp);
                    }
                    else{
                        ch1 = key.getKeyTable()[r1-1][c1];
                        ch2 = key.getKeyTable()[r2-1][c2];
                        temp.setFirst(ch1);
                        temp.setSecond(ch2);
                        encrypted.enqueue(temp);
                    }
                }
                else if(r1==0){
                    ch1 = key.getKeyTable()[4][c1];
                    ch2 = key.getKeyTable()[r2-1][c2];
                    temp.setFirst(ch1);
                    temp.setSecond(ch2);
                    encrypted.enqueue(temp);
                }
                else if(r2==0){
                    ch1 = key.getKeyTable()[r1-1][c1];
                    ch2 = key.getKeyTable()[4][c2];
                    temp.setFirst(ch1);
                    temp.setSecond(ch2);
                    encrypted.enqueue(temp);
                }
                else if(r1!=0&&r2!=0){
                    ch1 = key.getKeyTable()[r1-1][c1];
                    ch2 = key.getKeyTable()[r2-1][c2];
                    temp.setFirst(ch1);
                    temp.setSecond(ch2);
                    encrypted.enqueue(temp);
                }
            }
            else{
                ch1 = key.getKeyTable()[r1][c2];
                ch2 = key.getKeyTable()[r2][c1];
                temp.setFirst(ch1);
                temp.setSecond(ch2);
                encrypted.enqueue(temp);
            }
        }
        return encrypted;
    }

    /**
     * print out a phrase
     * @return phrase to String
     */
    public String toString() {
        String encrypted = new String();
        for(int i=0; i<phrasearr.length; i++){
            encrypted += String.valueOf(phrasearr[i].getFirst())+String.valueOf(phrasearr[i].getSecond());
        }
        encrypted = encrypted.toUpperCase();
        return encrypted;
    }
}
