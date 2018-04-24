/*
 * James Busch
 * 12/04/18
 * Stack data type
 * This data type holds ints >= 0 in a LIFO stack
 * The capacity is defined at the start by the user and can not grow
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
        int r = -1;
        if(!isEmpty())r = stackArray[pointer];
        return r;
    }

    @Override
    public int pop() {
        int returnNum = -1;
        if(isEmpty() == false){ 
            returnNum = stackArray[pointer];
            pointer--;
            }
        else System.err.println("Can't pop stack with no data in it");
        return returnNum;
    }

    @Override
    public void push(int value) {
        if(value < 0){
            System.out.println("Can not take value less than 0");
        }else if(!isFull()){
            pointer++;
            stackArray[pointer] = value;
        }else{
            System.err.println("Index outofbounds can't push anymore data");
        }
    }

    @Override
    public int size() {
        //return stackArray.length - (pointer + 1); 
        return pointer + 1;
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
        return (pointer + 1 == capacity());
      
    }

    @Override
    public void makeEmpty() {
        pointer = -1;
    }
}
