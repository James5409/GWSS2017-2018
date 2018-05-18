/*
 *To change this license header, choose License Headers in Project Properties.
 *To change this template file, choose Tools | Templates
 *and open the template in the editor.
 */

package edu.hdsb.gwss.JamesBusch.ics4u.u6;

/**
 *
 * @author jamers444
 */
public class Album {
    private String albumName;
    private String artistName;
    private int albumSales;
    private int amountOfTracks;
    private double raiting;
    private char longPlay;
    private boolean clean; 
    private final int ALBUM_NAME_SIZE = 17;
    private final int ARTIST_NAME_SIZE = 15;
    protected final int ALBUM_SIZE = 83;
    
    
    StringBuilder sb;
    
    public Album(){
    
    }
    
    public Album(String albumName, String artistName, int albumSales, int amountOfTracks, double raiting, char longPlay, boolean clean){
        setAlbumName(albumName);
        setArtistName(artistName);
        setAlbumSales(albumSales);
        setAmountOfTracks(amountOfTracks);
        setRaiting(raiting);
        setLongPlay(longPlay);
        setClean(clean);
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        sb = new StringBuilder();
        if ( albumName != null ) {
            sb.append( albumName.trim() );
        } else {
            sb.append( "TBD" );
        }

        // trucates or pads the string
        sb.setLength( ALBUM_NAME_SIZE );
        this.albumName = sb.toString();
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        sb = new StringBuilder();
        if ( artistName != null ) {
            sb.append( artistName.trim() );
        } else {
            sb.append( "TBD" );
        }

        // trucates or pads the string
        sb.setLength( ARTIST_NAME_SIZE );
        this.artistName = sb.toString();
    }

    public int getAlbumSales() {
        return albumSales;
    }

    public void setAlbumSales(int albumSales) {
        this.albumSales = albumSales;
    }

    public int getAmountOfTracks() {
        return amountOfTracks;
    }

    public void setAmountOfTracks(int amountOfTracks) {
        this.amountOfTracks = amountOfTracks;
    }

    public double getRaiting() {
        return raiting;
    }

    public void setRaiting(double raiting) {
        this.raiting = raiting;
    }

    public char getLongPlay() {
        return longPlay;
    }

    public void setLongPlay(char longPlay) {
        this.longPlay = longPlay;
    }

    public boolean isClean() {
        return clean;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }
    
    
    
    
    
}
