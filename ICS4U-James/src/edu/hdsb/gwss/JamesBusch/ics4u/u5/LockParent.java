/*
 *To change this license header, choose License Headers in Project Properties.
 *To change this template file, choose Tools | Templates
 *and open the template in the editor.
 */
package edu.hdsb.gwss.JamesBusch.ics4u.u5;

/**
 *
 * @author jamers444
 */
public class LockParent implements LockInterface {

    private boolean lockState = false;
    private boolean lockedOut = false;
    private boolean comboSeen = false;
    private int[] combo;
    private int attempts = 0;
    private int maxNum;
    
    protected void setMaxNum(int maxNum){
        this.maxNum = maxNum;
    }

    protected void setComboSize(int size){
        combo = new int[size];
    }
    

    protected void setCombo(int[] combo) {
        if(inRange(combo))this.combo = combo;
        else System.out.println("Number in combo out of range");
    }

    @Override
    public boolean isLocked() {
        return lockState;
    }

    @Override
    public void lock() {
        lockState = true;
    }

    @Override
    public void unlock() {
        lockState = false;
    }

    @Override
    public void tryUnlock(int[] combo) {
        if (lockedOut); else if (lockState == false); else {
            if (combo.equals(this.combo)) {
                unlock();
            } else {
                attempts++;
            }
        }
    }

    private boolean lockOut() {
        boolean permantlyLocked = false;
        if (attempts == 3) {
            permantlyLocked = true;
        }
        return permantlyLocked;
    }

  
    protected void seeCombo() {
        String comboData = null;
            for (int i = 0; i < this.combo.length; i++) {
                comboData = comboData + this.combo[i] + " ";
            }
        System.out.println(comboData);
    }
    
    protected boolean inRange(int[] combo){
        for (int i = 0; i < combo.length; i++) {
            int j = combo[i];
            if(j >= 0 || j <= this.maxNum);
            else return false;
        }
        return true;
    }
}

    