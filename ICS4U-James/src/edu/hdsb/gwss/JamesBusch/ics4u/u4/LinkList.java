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
public class LinkList implements LinkListInterface{
    private Node front;
    private Node back;
    
    
    public LinkList(){
        this.front = null;
        this.back = null;
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void makeEmpty() {
        this.front = null;
        this.back = null;
    }

    @Override
    public boolean isEmpty() {
        return(front == null);
    }

    @Override
    public void addAtFront(String str) {
        if(isEmpty()){
            this.front = new Node(str, null);
            this.back = front;
        }else if(size() == 1){
            this.front = new Node(str, back);
        }else{
            Node holder = new Node(str, front);
            front = holder;
        }
        
    }

    @Override
    public void addAtEnd(String str) {
        if(isEmpty()){
            this.back = new Node(str, null);
            this.front = back;
        }else{
            Node holder = new Node(str, null);
            this.back.setNext(holder);
            this.back = holder;
        }
    }

    @Override
    public void remove(String str) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String removeHead() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String removeTail() {
        String str = null;
        if(!isEmpty()){
            Node holder = new Node();
            holder = back.getNext();
            str = back.getValue();
            back.setNext(null);
            back = holder;  
        }
        return str;
    }

    @Override
    public String head() {
        String str = null;
        if(!isEmpty()) str = front.getValue(); 
        return str;
    }

    @Override
    public String tail() {
        String str = null;
        if(!isEmpty()) str = back.getValue();
        return str;
    }
}