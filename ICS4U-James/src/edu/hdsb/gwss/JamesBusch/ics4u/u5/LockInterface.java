/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.JamesBusch.ics4u.u5;

/**
 *
 * @author jamers444
 */
public interface LockInterface {
    
    
    public boolean isLocked();
    
    public void tryUnlock(int[] combo);
    
    public void lock();
    
    public void unlock();
    
}
