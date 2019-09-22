package Homework2;

/**
 * @author Junjian Zhu R05
 *    e-mail: junjian.zhu@Stonybrook.edu
 *    Stony Brook ID: 111384808
 **/

public class Song {
    private String name;
    private String artist;
    private String album;
    private int length;

    /**
     * empty constructor
     */

    public Song(){}

    /**
     *
     * @param name name of the song
     * @param artist artist of the song
     * @param album album of the song
     * @param length length of the song(in seconds)
     */
    public Song(String name, String artist, String album, int length) {
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.length = length;
    }


    /**
     * getters and setters
     * @return getters
     */


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getLength() { return length; }

    /**
     *
     * @param length length of the song
     * @exception  IllegalArgumentException length should be a positive integer.
     */
    public void setLength(int length) {
        if(length < 0){
            throw new IllegalArgumentException("Length can't be smaller then 0");
        }
        this.length = length;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", length=" + length +
                '}';
    }
}
