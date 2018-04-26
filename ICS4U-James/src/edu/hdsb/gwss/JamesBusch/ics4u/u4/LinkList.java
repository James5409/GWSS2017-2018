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
    private Node head;
    private Node tail;
    
    
    public LinkList(){
        this.head = null;
        this.tail = null;
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void makeEmpty() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public boolean isEmpty() {
        return(head == null);
    }

    @Override
    public void addAtFront(String str) {
        if(isEmpty()){
            this.head = new Node(str, null);
            this.tail = head;
        }else if(size() == 1){
            this.head = new Node(str, tail);
        }else{
            Node holder = new Node(str, head);
            head = holder;
        }
    }

    @Override
    public void addAtEnd(String str) {
        if(isEmpty()){
            this.tail = new Node(str, null);
            this.head = tail;
        }else{
            Node holder = new Node(str, null);
            this.tail.setNext(holder);
            this.tail = holder;
        }
    }

    @Override
    public void remove(String str) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String removeHead() {
       String str = null;
       if(!isEmpty()){
           str = head.getValue();
           Node holder = new Node();
           holder = head.getNext();
           head.setNext(null);
           head = holder;
       }  
      return str;
    }

    
    //Back <-----> Front
    @Override
    public String removeTail() {
        return null;
    }

    @Override
    public String head() {
        String str = null;
        if(!isEmpty()) str = head.getValue(); 
        return str;
    }

    @Override
    public String tail() {
        String str = null;
        if(!isEmpty()) str = tail.getValue();
        return str;
    }
}