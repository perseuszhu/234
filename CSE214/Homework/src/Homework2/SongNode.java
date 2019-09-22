package Homework2;
/**
 * @author Junjian Zhu R05
 *    e-mail: junjian.zhu@Stonybrook.edu
 *    Stony Brook ID: 111384808
 **/


public class SongNode {
    private Song data;
    private SongNode prev;
    private SongNode next;

    /**
     *
     * @param data a song object
     */
    public SongNode(Song data) {
        this.data = data;
    }

    /**
     * getters and setters. since this is a doubly linkedlist. so we need
     * both previous and next.
     * @return
     */
    public Song getData() {
        return data;
    }

    public void setData(Song data) {
        this.data = data;
    }

    public SongNode getPrev() {
        return prev;
    }

    public void setPrev(SongNode prev) {
        this.prev = prev;
    }

    public SongNode getNext() {
        return next;
    }

    public void setNext(SongNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "SongNode{" +
                "data=" + data +
                ", prev=" + prev +
                ", next=" + next +
                '}';
    }
}


