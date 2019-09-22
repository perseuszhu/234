package Homework2;

/**
 * @author Junjian Zhu R05
 *    e-mail: junjian.zhu@Stonybrook.edu
 *    Stony Brook ID: 111384808
 **/


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Random;

public class SongLinkedList {
    private SongNode head;
    private SongNode tail;
    private SongNode cursor;
    private int size;

    /**
     * a list of songnode objects
     */
    public SongLinkedList(){
        head = null;
        cursor = null;
        tail = null;
    }

    public SongNode getHead() { return head; }

    public void setHead(SongNode head) { this.head = head; }

    public SongNode getTail() { return tail; }

    public void setTail(SongNode tail) { this.tail = tail; }

    public SongNode getCursor() { return cursor; }

    public void setCursor(SongNode cursor) { this.cursor = cursor; }

    public void setSize(int size) { this.size = size; }

    /**
     * get the size of the list
     * @return the size of the list
     */

    public int getSize(){
        return size;
    }

    /**
     * generate a random number with in the boundries, then play the random
     * song.
     * @return the song object that was randomly selected.
     */
    public Song random(){
        if(head == null){
            return null;
        }
        SongNode tempcursor = head;
        Random rand = new Random();
        int rn = rand.nextInt(size+1);
        for(int i=0; i<rn; i++){
            tempcursor = tempcursor.getNext();
        }
        return tempcursor.getData();
    }

    /**
     * remove the song where the cursor now sits.
     *
     * @return the song that was removed
     */
    public Song removeCursor(){
        if(cursor == null){
            System.out.println("Empty playlist, please add first");
            return null;
        }
        Song removed = cursor.getData();
        if(cursor.getData().getName()==head.getData().getName()){
            head = cursor.getNext();
            cursor = cursor.getNext();
        }
        else if(cursor.getData().getName()==tail.getData().getName()){
            tail = cursor.getPrev();
            cursor = cursor.getPrev();
        }
        else{
            cursor.getPrev().setNext(cursor.getNext());
            cursor.getNext().setPrev(cursor.getPrev());
            cursor = cursor.getPrev();
        }
        System.out.println(removed.getName()+" is now removed from the playlist.");
        size--;
        return removed;
    }


    /**
     * play a song that was input via name
     * @param name the name of the song that was about to be played
     * @throws IllegalArgumentException file not found
     */
    public void play(String name) throws IllegalArgumentException{
        try {
            AudioInputStream AIS = AudioSystem.getAudioInputStream(
                    new File(name+".wav"));



// starting the clip

            Clip c = AudioSystem.getClip();

            c.open(AIS);

            c.start();
            System.out.println(name+" is now playing.");
        }

        catch (Exception ex) {
            System.out.println("File not found, please try again.");
        }


    }

    /**
     * move the cursor one position forward
     */
    public void cursorForward(){
        if(head == null){
            System.out.println("Empty Playlist, please add a song first");
        }
        else if(cursor == tail){
            System.out.println("This is already the last Song");
        }
        else {
            cursor = cursor.getNext();
            System.out.println("Cursor moved to next song");
        }
    }

    /**
     * move the cursor one position backward
     */
    public void cursorBackward(){
        if(head == null){
            System.out.println("Empty Playlist, please add a song first");
        }
        else if(cursor == head){
            System.out.println("This is already the first Song");
        }
        else {
            cursor = cursor.getPrev();
            System.out.println("Cursor moved to previous song.");
        }
    }

    /**
     * print out the current list. the cursor songnode will have a arrow at the end
     */
    public void printtPlayerList(){
        SongNode tempCursor = head;
        System.out.println("Playlist: ");
        System.out.printf("%-25s","Song");
        System.out.printf("%-30s","Artist");
        System.out.printf("%-28s","Album");
        System.out.printf("%-10s","Lengths");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------" +
                "--------------------------------");
        tempCursor = head;
        for(int i=0; i<size;i++) {
            if (tempCursor.getData().getName() == cursor.getData().getName()) {
                System.out.printf("%-25s", tempCursor.getData().getName());
                System.out.printf("%-30s", tempCursor.getData().getArtist());
                System.out.printf("%-28s", tempCursor.getData().getAlbum());
                System.out.printf("%-10s", tempCursor.getData().getLength());
                System.out.printf("%-15s", "<--");
                System.out.println();
                tempCursor = tempCursor.getNext();
            } else {
                System.out.printf("%-25s", tempCursor.getData().getName());
                System.out.printf("%-30s", tempCursor.getData().getArtist());
                System.out.printf("%-28s", tempCursor.getData().getAlbum());
                System.out.printf("%-30s", tempCursor.getData().getLength());
                System.out.println();
                tempCursor = tempCursor.getNext();

            }
        }

        }

    /**
     * delete all the songnode in the linked list.
     */
    public void deleteAll(){
        head = null;
        tail = null;
        cursor = null;
        System.out.println("Playlist cleared");
        size=0;
    }

    /**
     * shuffle the linked list.
     * @param head the first item in the list.
     */
    public void shuffle(SongNode head){
        if(head==null){
            System.out.println("Playlist is empty, please add first");
            return;
        }
        String name =cursor.getData().getName();
        SongNode tempcur = null;
        SongNode current = head;
        Song[] nodeArray = new Song[size];
        for(int i=0; i<size; i++){
            nodeArray[i] = current.getData();
            current = current.getNext();
        }
        Random rand = new Random();
        int choose = 0;
        Song temp;
        for(int i=0; i< size; i++){
            choose = rand.nextInt(i+1);
            temp = nodeArray[choose];
            nodeArray[choose] = nodeArray[i];
            nodeArray[i] = temp;
        }
        current = head;
        for(int i=0; i<size; i++){
            current.setData(nodeArray[i]);
            current = current.getNext();
        }
        tempcur = head;
        for(int i= 0 ;i<size; i++){
            if(tempcur.getData().getName().equals(name)){
                setCursor(tempcur);
            }
            tempcur = tempcur.getNext();
        }
        System.out.println("Playlist Shuffled. Cursor back to first song");
    }

    /**
     * add a new song after the current cursor
     * @param newSong the song that was about to be put into the linked list after
     *                the current cursor.
     */
    public void insertAfterCursor(Song newSong){
        SongNode temp = new SongNode(newSong);
        if(head==null){
            head = temp;
            tail = temp;
            cursor = temp;
            size++;
        }
        else if(cursor.getNext() == null){
            cursor.setNext(temp);
            cursor.getNext().setPrev(cursor);
            setTail(cursor.getNext());
            cursor = cursor.getNext();
            size++;
        }
        else{
            cursor.getNext().setPrev(temp);
            temp.setNext(cursor.getNext());
            temp.setPrev(cursor);
            cursor.setNext(temp);
            cursor = temp;
            size++;
        }
    }
}
