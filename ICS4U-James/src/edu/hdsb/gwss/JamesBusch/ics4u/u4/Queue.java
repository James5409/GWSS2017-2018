/*
 * James Busch
 * 20/4/18
 * Queue data type
 * This data type holds ints in a queue that is FIFO
 * The size is staticly defined at the start by the user and can not grow
 */
package edu.hdsb.gwss.JamesBusch.ics4u.u4;

/**
 *
 * @author jamers444
 */
public class Queue implements QueueInterface {

    private int[] queueArray;
    private int frontPointer = 0;
    private int backPointer = -1;

    public Queue() {
        queueArray = new int[5];
    }

    public Queue(int capacity) {
        queueArray = new int[capacity];
    }

    public int getFrontPointer() {
        return frontPointer;
    }

    public int getBackPointer() {
        return backPointer;
    }

    @Override
    public Integer front() {
        Integer r = null;
        if (!isEmpty()) {
            r = queueArray[frontPointer];
        }
        return r;
    }

    @Override
    public Integer back() {
        Integer r = null;
        if (!isEmpty()) {
            r = queueArray[backPointer];
        }
        return r;
    }

    @Override
    public void enqueue(Integer value) {//adds another num to the front pointer
        if (backPointer == queueArray.length - 1 && frontPointer == 0) {
            System.err.println("can not enqueue a full queue");
        } else if (backPointer == frontPointer - 1 && backPointer != -1) {
            System.err.println("can not enqueue a full queue");
        } else {
            if (backPointer == queueArray.length - 1) {
                backPointer = 0;
                queueArray[backPointer] = value;
            } else {
                backPointer++;
                queueArray[backPointer] = value;
            }
        }
    }

    @Override
    public Integer dequeue() {//pushes out front number
        Integer r = null;
        if (!isEmpty()) {
            r = queueArray[frontPointer];
            if (frontPointer != queueArray.length - 1) {
                frontPointer++;
            } else if (frontPointer == backPointer) {
                makeEmpty();
            } else {
                frontPointer = 0;
            }
        } else {
            System.err.println("Can't dequeue a empty queue");
        }

        return r;
    }

    @Override
    public int size() {
        int r;
        if (isEmpty()) {
            r = 0;
        } else if (isFull()) {
            r = 10;
        } else if (backPointer >= frontPointer) {
            r = ((backPointer - frontPointer) + 1);
        } else {
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
        return (backPointer == -1);
    }

    @Override
    public boolean isFull() {
        boolean r = false;
        if (backPointer == frontPointer - 1 && backPointer != -1) {
            r = true;
        } else if (frontPointer == 0 && backPointer == capacity() - 1) {
            r = true;
        }
        return r;
    }

    @Override
    public void makeEmpty() {
        frontPointer = 0;
        backPointer = -1;
    }

}
