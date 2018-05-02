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
public class HashTable implements HashTableInterface{
    
    //class varibles
    private final int DEFUALT_SIZE = 53;
    //object varibles
    private Student[] hashTable;
    
    public HashTable(){
        hashTable = new Student[DEFUALT_SIZE];
    }
    
    public HashTable(int size){
        hashTable = new Student[size];
    }
    
    
    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int capacity() {
        return hashTable.length;
    }

    @Override
    public double loadFactor() {
       return (double)size() / capacity()  * 100;
    }

    @Override
    public void makeEmpty() {
        hashTable = new Student[hashTable.length];
    }

    @Override
    public boolean isEmpty() {
       return(size() == 0);
    }

    @Override
    public void rehash() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student get(int key) {
        int position = hash(key);
        int positionChecker = position;
        boolean found = false;
        Student student = null;
        
        if(position < 0);
        else{
            while(!found){
                if(hashTable[position].hashCode() == key){
                    found = true;
                    student = hashTable[position];
                }else{
                    if(position == capacity())position = 0;
                    else position++;
                }
                if(position == positionChecker)found = true;
            }
        }
        return student;
    }

    @Override
    public void put(int key, Student value) {
        int position = hash(key);
        boolean placed = false;
        if(loadFactor() > 75)rehash();
        
        if(position < 0);
        else{
            while(!placed){
                if(hashTable[position] == null){
                    hashTable[position] = value;
                    placed = true;
                }
                else{
                    if(position == capacity())position = 0;
                    else position++;
                }
            }
        }
    }

    @Override
    public boolean contains(Student value) {
        
        for (int i = 0; i < hashTable.length; i++) {
            if(hashTable[i].equals(value))return true;
        }
        return false;
    }

    @Override
    public boolean containsKey(int key) {
       
        int position = hash(key);
        
        boolean contain = false;
        if(!isEmpty()){
            for (int i = 0; i < hashTable.length; i++) { 
                if(hashTable[i].getId() == key)contain = true;  
            }
        }
        return contain;
        
    }

    @Override
    public int hash(int key) {
        return key % capacity();
    }

}
