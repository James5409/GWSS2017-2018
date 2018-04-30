/*
 * James Busch
 * 30/04/18
 * LinkList data type
 * This data type holds a infinate amount of data where each peice of data
 * looks at the next in the line
 */
package edu.hdsb.gwss.JamesBusch.ics4u.u4;

/**
 *
 * @author jamers444
 */
public class LinkList implements LinkListInterface {
    //object varibles
    private Node head;
    private Node tail;

    /**
     * empty link list defaults to no data
     */
    public LinkList() {
        this.head = null;
        this.tail = null;
    }
    
    /**
     * Constructor that takes in first piece of data
     * 
     * @param data sets first part of data for list
     */
    public LinkList(String data){
        this.head = new Node(data, null);
        this.tail = this.head;
    }
    

    /**
     * Gets the amount of data stored in the link list
     * 
     * @return the size that the data takes up
     */
    @Override
    public int size() {
        int i = 0;
        boolean cont = true;
        Node holder = new Node();
        holder = head;
        do {
            if (isEmpty()) {
                cont = false;
            } else if (holder.getNext() == null) {
                i++;
                cont = false;
            } else {
                holder = holder.getNext();
                i++;
            }
        } while (cont == true);
        return i;
    }

    /**
     * makes the link list empty
     */
    @Override
    public void makeEmpty() {
        this.head = null;
        this.tail = null;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return (head == null);
    }

    @Override
    public void addAtFront(String str) {
        if (isEmpty()) {
            this.head = new Node(str, null);
            this.tail = head;
        } else if (size() == 1) {
            this.head = new Node(str, tail);
        } else {
            Node holder = new Node(str, head);
            head = holder;
        }
    }

    @Override
    public void addAtEnd(String str) {
        if (isEmpty()) {
            this.tail = new Node(str, null);
            this.head = tail;
        } else {
            Node holder = new Node(str, null);
            this.tail.setNext(holder);
            this.tail = holder;
        }
    }

    @Override
    public void remove(String str) {
        if (isEmpty()); 
        else if (head.getValue().equals(str)) {
            removeHead();
        } else if (tail.getValue().equals(str)) {
            removeTail();
        } else {
            Node holder = head;
            do{
                holder = holder.getNext();
            }while(!holder.getNext().getValue().equals(str));
            Node holderTwo = holder.getNext();
            holder.setNext(holderTwo.getNext());
            holderTwo.setNext(null);
            
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String removeHead() {
        String str = null;
        if (!isEmpty()) {
            str = head.getValue();
            Node holder = new Node();
            holder = head.getNext();
            head.setNext(null);
            head = holder;
        }
        return str;
    }

    //Back <-----> Front

    /**
     *
     * @return
     */
    @Override
    public String removeTail() {
        String str = null;
        Node holder = this.head;
        if (!isEmpty()) {
            str = tail.getValue();
            if (size() == 1) {
                makeEmpty();
            } else {
                do {
                    holder = holder.getNext();
                } while (holder.getNext() != tail);
                holder.setNext(null);
                tail = holder;
            }
        }
        return str;
    }

    /**
     *
     * @return
     */
    @Override
    public String head() {
        String str = null;
        if (!isEmpty()) {
            str = head.getValue();
        }
        return str;
    }

    /**
     *
     * @return returns the string at the tail, if empty return null
     */
    @Override
    public String tail() {
        String str = null;
        if (!isEmpty()) {
            str = tail.getValue();
        }
        return str;
    }
}