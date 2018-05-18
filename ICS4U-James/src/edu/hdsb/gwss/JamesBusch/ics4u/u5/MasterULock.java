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
public class MasterULock extends ConfigurableCombo{
    private final int COMBO_SIZE = 4;
    
    private int[] comboHolder = new int[COMBO_SIZE];
   
    public MasterULock(){
        setComboSize(COMBO_SIZE);
        setCombo(comboHolder);
    }
    
    public MasterULock(int x1, int x2, int x3, int x4){
        setComboSize(COMBO_SIZE);
        comboHolder[0] = x1;
        comboHolder[1] = x2;
        comboHolder[2] = x3;
        comboHolder[3] = x4;
        if(inRange(comboHolder)) setCombo(comboHolder);
        else setCombo(comboHolder = new int[COMBO_SIZE]);
    }
    
    public MasterULock(int[] combo){
        setComboSize(COMBO_SIZE);
        if(inRange(combo)) setCombo(combo);
        else setCombo(comboHolder);
    } 
    
    
}