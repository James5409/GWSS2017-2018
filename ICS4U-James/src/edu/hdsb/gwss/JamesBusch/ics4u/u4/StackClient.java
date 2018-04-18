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
public class StackClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack stackTestOne = new Stack(10);
        assert stackTestOne.isEmpty() == true;
        for (int i = 0; i < stackTestOne.capacity(); i++) {
            stackTestOne.push(i);
            System.out.print(stackTestOne.top());
            System.out.print(" ");
            assert stackTestOne.isEmpty() == false;
        }
        System.out.println("");
        System.out.println("-is full test-");
        assert stackTestOne.isFull() == true;
        System.out.println("-capacity test-");
        assert stackTestOne.capacity() == 10;
        System.out.println("-top num test-");
        assert stackTestOne.top() == 9;
        System.out.println("-size test-");
        assert stackTestOne.size() == 0;
        System.out.println("-empty test-");
        assert stackTestOne.isEmpty() == false;
        
        for (int i = stackTestOne.capacity(); i > 0; i--) {
            assert stackTestOne.pop() == i - 1;
            System.out.print(i);
            System.out.print(" ");
        }
        assert stackTestOne.isEmpty() == true;  
        System.out.println("-should return error-");
        stackTestOne.pop();
        }
    }
    
