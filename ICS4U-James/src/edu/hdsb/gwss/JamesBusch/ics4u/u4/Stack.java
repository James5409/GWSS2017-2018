/*
 * Stack object
 * James Busch
 * 12/04/18
 */

package edu.hdsb.gwss.JamesBusch.ics4u.u4;

/**
 *
 * @author jamers444
 */
public class Stack implements StackInterface{
    
    //object varible
    private int[] stackArray;
    private int pointer = -1;
    
    public Stack(){
        stackArray = new int[5];
        System.err.println("");
    }
    
    public Stack(int size){
        stackArray = new int[size];
    }

    @Override
    public int top() {
        if(!isEmpty())return stackArray[pointer];
        System.err.println("Can not check top of array with no data");
        return -1;
    }

    @Override
    public int pop() {
        int returnNum = -1;
        if(isEmpty() == false){ 
            returnNum = stackArray[pointer];
            pointer--;
            }
        else System.err.println("Can not pop stack with no data in it");
        return returnNum;
    }

    @Override
    public void push(int value) {
        if(!isFull()){
            pointer++;
            stackArray[pointer] = value;
        }else{
            System.err.println("Index outofbounds can not push anymore data");
        }
    }

    @Override
    public int size() {
        return stackArray.length - (pointer + 1); 
    }

    @Override
    public int capacity() {
        return stackArray.length;
    }

    @Override
    public boolean isEmpty() {
        return (pointer == -1);
    }

    @Override
    public boolean isFull() {
        return (pointer + 1 == stackArray.length);
    }

    @Override
    public void makeEmpty() {
        pointer = -1;
    }
}
