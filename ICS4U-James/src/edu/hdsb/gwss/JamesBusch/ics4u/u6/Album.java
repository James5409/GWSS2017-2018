/*
 *To change this license header, choose License Headers in Project Properties.
 *To change this template file, choose Tools | Templates
 *and open the template in the editor.
 */

package edu.hdsb.gwss.JamesBusch.ics4u.u6;

import java.util.Objects;

/**
 *
 * @author jamers444
 */
public class Album {
    private String albumName;
    private String artistName;
    private int albumSales = 0;
    private int amountOfTracks = 0;
    private double raiting = 0;
    private char longPlay = 'N';
    private boolean clean = false; 
    //private int id = -1;

    /**
     *
     */
    public static final int ALBUM_NAME_SIZE = 17;

    /**
     *
     */
    public static final int ARTIST_NAME_SIZE = 15;

    /**
     *
     */
    public static final int ALBUM_SIZE = 83;
    
    
    StringBuilder sb;
    
    /**
     *
     */
    public Album(){
        setAlbumName(null);
        setArtistName(null);
        setAlbumSales(0);
        setAmountOfTracks(0);
        setRaiting(0);
        setLongPlay('n');
        setClean(true);
    }
    
    /**
     *
     * @param albumName Name of the album 17 chars long
     * @param artistName Name of artist 15 chars long
     * @param albumSales Sales of the album
     * @param amountOfTracks Amounf of tracks
     * @param raiting
     * @param longPlay
     * @param clean
     */
    public Album(String albumName, String artistName, int albumSales, int amountOfTracks, double raiting, char longPlay, boolean clean){
        setAlbumName(albumName);
        setArtistName(artistName);
        setAlbumSales(albumSales);
        setAmountOfTracks(amountOfTracks);
        setRaiting(raiting);
        setLongPlay(longPlay);
        setClean(clean);
    }

    /**
     *
     * @return
     */
    public String getAlbumName() {
        return albumName;
    }

    /**
     *
     * @param albumName
     */
    public void setAlbumName(String albumName) {
        sb = new StringBuilder();
        if ( albumName != null ) {
            sb.append( albumName.trim() );
        } else {
            sb.append( "TBD".trim() );
        }

        // trucates or pads the string
        sb.setLength( ALBUM_NAME_SIZE );
        this.albumName = sb.toString();
    }

    /**
     *
     * @return
     */
    public String getArtistName() {
        return artistName;
    }

    /**
     *
     * @param artistName
     */
    public void setArtistName(String artistName) {
        sb = new StringBuilder();
        if ( artistName != null ) {
            sb.append( artistName.trim() );
        } else {
            sb.append( "TBD".trim() );
        }

        // trucates or pads the string
        sb.setLength( ARTIST_NAME_SIZE );
        this.artistName = sb.toString();
    }

    /**
     *
     * @return
     */
    public int getAlbumSales() {
        return albumSales;
    }

    /**
     *
     * @param albumSales
     */
    public void setAlbumSales(int albumSales) {
        this.albumSales = albumSales;
    }

    /**
     *
     * @return
     */
    public int getAmountOfTracks() {
        return amountOfTracks;
    }

    /**
     *
     * @param amountOfTracks
     */
    public void setAmountOfTracks(int amountOfTracks) {
        this.amountOfTracks = amountOfTracks;
    }

    /**
     *
     * @return
     */
    public double getRaiting() {
        return raiting;
    }

    /**
     *
     * @param raiting the raiting of the album
     */
    public void setRaiting(double raiting) {
        this.raiting = raiting;
    }

    /**
     *
     * @return
     */
    public char getLongPlay() {
        return longPlay;
    }

    /**
     *
     * @param longPlay if it is a LP or EP
     */
    public void setLongPlay(char longPlay) {
        this.longPlay = longPlay;
    }

    /**
     *
     * @return if the album is clean
     */
    public boolean isClean() {
        return clean;
    }

    /**
     *
     * @param clean if the album is clean or explicit
     */
    public void setClean(boolean clean) {
        this.clean = clean;
    }   
    
    public boolean isValid(){
        boolean valid = true;
        if(this.albumName.trim().equals("TBD") || this.artistName.trim().equals("TBD"))valid = false;
        return valid;
    }

    @Override
    public String toString() {
        return "Album{" + "albumName=" + albumName + ", artistName=" + artistName + ", albumSales=" + albumSales + ", amountOfTracks=" + amountOfTracks + ", raiting=" + raiting + ", longPlay=" + longPlay + ", clean=" + clean + '}';
    }
    
    
    
    public boolean equals(Album album) {
        if(this.isValid() && album.isValid()){
            if(this.albumName.equals(album.getAlbumName())){
                if(this.artistName.equals(album.getArtistName())){
                    if(this.amountOfTracks == album.getAmountOfTracks()){
                        if(this.albumSales == album.getAlbumSales()){
                            if(this.raiting == album.getRaiting()){
                                if(this.longPlay == album.getLongPlay()){
                                    if(this.clean == album.isClean()) return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    
    
}
