/*
 *To change this license header, choose License Headers in Project Properties.
 *To change this template file, choose Tools | Templates
 *and open the template in the editor.
 */

package edu.hdsb.gwss.JamesBusch.ics4u.u4;

/**
 *
 * @author jamers444
 */
public class Queue implements QueueInterface{
    
    private int[] queueArray;
    private int frontPointer = -1;
    private int backPointer = -1;
    
    public Queue(){
        queueArray = new int[5];
    }
    
    public Queue(int capacity){
        queueArray = new int[capacity];
    }

    @Override
    public Integer front() {
        Integer r = null;
        if(!isEmpty()){
            r = queueArray[frontPointer];
        }
        return r;
    }

    @Override
    public Integer back() {
        Integer r = null;
        if(!isEmpty()){
            r = queueArray[backPointer];
        }
        return r;
    }

    @Override
    public void enqueue(Integer value) {//adds another num to the front pointer
        if(backPointer == queueArray.length - 1 && frontPointer == 0){
            System.err.println("can not enqueue a full queue");
        }else if(backPointer == frontPointer - 1){
            System.err.println("can not enqueue a full queue");
        }else{
            if(backPointer == queueArray.length - 1){
                backPointer = 0;
                queueArray[backPointer] = value;
            }//TODO REST OF CASES
            
        }
        
    }
    

    @Override
    public Integer dequeue() {//pushes out front number
        Integer r = null;
        if(!isEmpty()){
            r = queueArray[frontPointer];
        }
        if(frontPointer != queueArray.length - 1) frontPointer++;
        else frontPointer = 0;
        
        return r;
    }

    @Override
    public int size() {
        int r = 0;
        if(backPointer >= frontPointer) r = (backPointer - frontPointer) + 1;
        else{
           // r = (queueArray.length -backPointer) - frontPointer + 1;
           r = (queueArray.length - frontPointer) + backPointer + 1;
        }
        return r;
    }

    @Override
    public int capacity() {
        return queueArray.length;
    }

    @Override
    public boolean isEmpty() {
        return (backPointer == -1 || frontPointer == backPointer);
    }

    @Override
    public boolean isFull() {
        boolean r = false;
        if(frontPointer == backPointer + 1)r = true;
        if(frontPointer == 0 && backPointer == queueArray.length - 1) r = true;
        return r; 
    }

    @Override
    public void makeEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
