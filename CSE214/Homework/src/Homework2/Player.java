package Homework2;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * @author Junjian Zhu R05
 *    e-mail: junjian.zhu@Stonybrook.edu
 *    Stony Brook ID: 111384808
 **/
public class Player {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SongLinkedList list = new SongLinkedList();
        boolean status = true;                     //Control when to quit the system
        while (status) {
            /**
             * print main menu
             */
            System.out.println();
            System.out.println("(A)   Add Song to Playlist" + "\n" +
                    "(F)   Go to Next Song\n" + "(B)   Go to Previous Song\n"
                    + "(R)   Remove Song from Playlist\n" + "(L)   Play a Song\n" + "(C)   Clear the playlist\n" +
                    "(S)   Shuffle Play list\n" + "(Z)   Random Song\n" + "(P)   Print Playlist\n" +"(T)   Get the total amount" +
                            "of songs in the Playlist\n"+
                    "(Q)   Exit the Playlist");
            System.out.println();
            System.out.println("Please Enter a Command: ");                           // Create the First menu.
            String command = in.nextLine();
            /**
             * append a song in the list after the cursor
             */
            if(command.equalsIgnoreCase("A")){
                boolean validInput = false;
                Song temp = new Song();
                System.out.println("Enter Song name: ");
                temp.setName(in.nextLine());
                System.out.println("Enter artist(s) of the song: ");
                temp.setArtist(in.nextLine());
                System.out.println("Enter Album: ");
                temp.setAlbum(in.nextLine());
                System.out.println("Enter length (In seconds): ");
                while (!validInput) {           //repeat try process if an exception is caught
                    try {
                        temp.setLength(in.nextInt());
                        validInput = true;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Length can't be smaller then 0");
                        System.out.println("Enter length (In seconds): ");
                    } catch (InputMismatchException ex) {
                        System.out.println("Length should be a Numeric value");
                        System.out.println("Enter length (In seconds): ");
                        in.next();
                    }
                }
                in.nextLine();
                list.insertAfterCursor(temp);
                System.out.println("'"+temp.getName()+"'"+" by "+temp.getArtist()+" is added to your playlist.");
            }
            /**
             * quit program
             *
             */
            if (command.equalsIgnoreCase("Q")) {
                System.out.println("Quitting program. . .");
                status = false;
            }
            /**
             * play a song via name that was input
             */
            if(command.equalsIgnoreCase("L")) {
                System.out.println("Please enter the name of the song:");
                String name = in.nextLine();
                list.play(name);
            }
            /**
             * shuffle the list
             */
            if (command.equalsIgnoreCase("S")) {
                list.shuffle(list.getHead());
            }
            /**
             * print out the current list with notation next to the cursor
             */
            if (command.equalsIgnoreCase("P")) {
                list.printtPlayerList();
            }
            /**
             * remove the current song from the list where the cursor lies, then move the cursor
             * to the previous song. if the one removed is the head, then move the cursor one
             * position back.
             */
            if (command.equalsIgnoreCase("R")) {
                list.removeCursor();
            }
            /**
             * move the cursor one position fowrard
             */
            if (command.equalsIgnoreCase("F")) {
                list.cursorForward();
            }
            /**
             * move the cursor one position backward
             */
            if (command.equalsIgnoreCase("B")) {
                list.cursorBackward();
            }
            /**
             * play a random song from the list
             */
            if (command.equalsIgnoreCase("Z")) {
                if(list.random()==null){
                    System.out.println("Empty table! Please add first");
                }
                else{
                    list.play(list.random().getName());
                }

            }
            /**
             * get the size of the list
             */
            if (command.equalsIgnoreCase("T")) {
                System.out.println("Your playlist contains "+list.getSize()+" songs");
            }
            /**
             * delete all the file in the list
             */
            if (command.equalsIgnoreCase("C")) {
                list.deleteAll();
            }
        }
    }
}
