/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.JamesBusch.ics4u.u6;

/**
 *
 * @author jamers444
 */
import java.io.*;

public class AlbumStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        
        File file = new File(".//data//Album//album.dat");
        
        RandomAccessFile recordFile = new RandomAccessFile(file, "rw");
        
        recordFile.seek(0);
        
        
        
    }
    
}
