/*
 *To change this license header, choose License Headers in Project Properties.
 *To change this template file, choose Tools | Templates
 *and open the template in the editor.
 */

package edu.hdsb.gwss.JamesBusch.ics4u.u6;

import java.io.File;
import java.io.RandomAccessFile;

/**
 *
 * @author jamers444
 */
public class AlbumDatabase{
    
    File file = new File(".//data//albumDatabase//albumdata.dat");
    RandomAccessFile recordFile = new RandomAccessFile(file, "rw");
    
    private long pointer;
    
    
    public AlbumDatabase() throws Exception{
        pointer = recordFile.length();
    }
    
    public AlbumDatabase(int id)throws Exception{
        pointer = (id - 1) * Album.ALBUM_SIZE;
    }
    
    
    
    public void closeDatabase()throws Exception{
        recordFile.close();
    }

    
    
}
