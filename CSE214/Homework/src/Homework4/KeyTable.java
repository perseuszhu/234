package Homework4;

/**
 * @author Junjian Zhu R05
 *    e-mail: junjian.zhu@Stonybrook.edu
 *    Stony Brook ID: 111384808
 **/

public class KeyTable {
    private static char[][] key = new char[5][5];
    public KeyTable(){}
    public KeyTable(char[][] key){
        this.key = key;
    }

    /**
     *
     * @param keyphrase a String that will later form the keytable
     * @return a KeyTable variable that will be used for future decryption and encryption.
     * @throws IllegalArgumentException
     */
    public static KeyTable buildFromString(String keyphrase) throws IllegalArgumentException{
        if(keyphrase==null)
            return null;
        String rmdup = removeDuplicate(keyphrase); //The rebulid String that contains no Duplicate characters
        String alph = "abcdefghiklmnopqrstuvwxyz";
        /**
         * a method that can append all the other characters that haven't appear in the keyphrase.
         */
        for(int i = 0; i<alph.length(); i++){
            while(!rmdup.contains(String.valueOf(alph.charAt(i)))){
                rmdup += String.valueOf(alph.charAt(i));
            }
        }
        rmdup = rmdup.toUpperCase();
        int index = 0;
        for(int i=0; i<5; i++) {
            for (int j = 0; j < 5; j++) {
                key[i][j] = rmdup.charAt(index++);
            }
        }
        KeyTable kt = new KeyTable(key);
        return kt;
    }

    /**
     * a method that can remove all the duplicated characters in the KeyPhrase string
     * @param keyphrase the string that will be used to create a KeyTable
     * @return a refined String that have no duplicated characters.
     */
    public static String removeDuplicate(String keyphrase){
        /**
         * remove all illegal characters such as numbers or spaces.
         */
        keyphrase = keyphrase.replaceAll(" ","");
        keyphrase = keyphrase.replaceAll("\\p{Punct}","");
        keyphrase = keyphrase.replaceAll("\\d","");
        keyphrase = keyphrase.toLowerCase();
        String str = new String();
        for(int i = 0; i < keyphrase.length(); i++){
            char c = keyphrase.charAt(i);
            if(str.indexOf(c) < 0){
                str += c;
            }
        }
        return str;
    }
    public char[][] getTable(){return  key;}

    public static char[][] getKeyTable() {
        return key;
    }

    /**
     * print the table out once the table is already prepared.
     */
    public void print(){
        char[][] table = KeyTable.getKeyTable();
        for(int i=0; i<5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(table[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * find which row a certain character is located in the keytable
     * @param c the character that we are going to looking for
     * @return the integer that present the vertical location of the character c
     */
    public int findRow(char c){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
             if (key[i][j]== c){
                 return i;
             }
            }
        }
        return 0;
    }

    /**
     * find which column a certain character is located in the keytable
     * @param c the character that we are going to looking for
     * @returnthe integer that present the horizontal location of the character c
     */
    public int findCol(char c){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if (key[i][j]== c){
                    return j;
                }
            }
        }
        return 0;
    }

}
