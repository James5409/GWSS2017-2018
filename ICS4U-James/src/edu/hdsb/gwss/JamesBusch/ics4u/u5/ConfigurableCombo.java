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
public abstract class ConfigurableCombo extends LockParent{
    private int[] holderCombo;
    private int comboSize;
        
    public ConfigurableCombo(int[] combo){
        setCombo(holderCombo);
        setMaxNum(9);
        setComboSize(combo.length);
        comboSize = combo.length;
    }
    
    public void reConfigureCode(int[] combo){
        System.out.println("Reconfiguring combo");
        if(combo.length == comboSize)setCombo(combo);
        else System.out.println("combo not right size");
    }
    
}
