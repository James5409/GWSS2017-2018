/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.JamesBusch.ics4u.u4;

/**
 *
 * @author jamers444
 */
public interface PacmanInterface {
    public void moveUp();
    public void die();
    public void powerUp();
    public int getXLoc();
    public int getYLoc();
    public int reset();
}
