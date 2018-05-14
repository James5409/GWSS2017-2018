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
public class MasterLock extends LockParent{
    private static int MAX_NUM = 39;
    private static int COMBO_LENGTH = 3;
    private static int[] holderCombo;
    
    
    public MasterLock(){
        holderCombo = new int[COMBO_LENGTH];
        setComboSize(COMBO_LENGTH);
        setMaxNum(MAX_NUM);
        for(int i = 0; i < holderCombo.length; i++){
            holderCombo[i] = (int)(Math.random() * (MAX_NUM + 1));
        }
        setCombo(holderCombo);
    }
}
