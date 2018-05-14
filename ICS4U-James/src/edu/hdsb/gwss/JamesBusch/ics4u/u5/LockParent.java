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
public abstract class LockParent implements LockInterface {

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
        if(lockState == false){
            if(inRange(combo))this.combo = combo;
            else System.out.println("Number in combo out of range");
        }else{
            System.out.println("Must unlock before setting combo");
        }
    }

    @Override
    public boolean isLocked() {
        System.out.println("Checking lock state");
        return lockState;
    }

    @Override
    public void lock() {
        System.out.println("Locking lock");
        lockState = true;
    }

    
    private void unlock() {
        System.out.println("unlocked");
        lockState = false;
    }

    @Override
    public void tryUnlock(int[] combo) {
        System.out.println("trying unlock");
        if (lockedOut)System.out.println("LOCKED OUT CAN'T ACCSESS LOCK"); 
        else if (lockState == false)System.out.println("Already unlocked"); 
        else if(inRange(combo)){
            if (combo.equals(this.combo)) {
                unlock();
                attempts = 0;
                System.out.println("Unlocked");
            } else {
                attempts++;
                System.out.println("inccorect code you have failed" + attempts + "times");
            }
        }else{
            System.out.println("N");
        }
    }

    private boolean lockOut() {
        boolean permantlyLocked = false;
        if (attempts == 3) {
            permantlyLocked = true;
        }
        return permantlyLocked;
    }

  
    protected int[] seeCombo() {
        if(comboSeen == false) return this.combo;
        else{
            System.out.println("Combo already seen returning null");
            return null;
        }
    }
    
    private boolean inRange(int[] combo){
        for (int i = 0; i < combo.length; i++) {
            int j = combo[i];
            if(j >= 0 || j <= this.maxNum);
            else{
                System.out.println("Number at index" + i + "out of range");
                return false;
            }
        }
        return true;
    }
}

    