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
public class FixedCombo extends LockParent{
    private int[] holderCombo;
    
    
    public FixedCombo(){
        holderCombo = new int[3];
        setComboSize(3);
        setMaxNum(3);
        for(int i = 0; i < 3; i++){
            holderCombo[i] = (int)(Math.random() * 40);  
        }
        seeCombo();
    }
    
    public FixedCombo(int comboSize, int maxNum){
        holderCombo = new int[comboSize];
        setComboSize(comboSize);
        setMaxNum(maxNum);
         for(int i = 0; i < comboSize; i++){
            holderCombo[i] = (int)(Math.random() * (maxNum + 1));
        }
         seeCombo();
    }
    
  
    
}
