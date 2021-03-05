package com.jworks.queues;

public class MyCircularQueue {

    private int[] internalQueue;

    private int size;

    private int headPointer;

    private int tailPointer;

    public MyCircularQueue(int size) {
        this.internalQueue = new int[size];
        this.size = size;
        headPointer =- 1;
        tailPointer = -1;
    }

    public boolean isEmpty(){
        return headPointer == -1 && tailPointer == -1;
    }

    public boolean isFull(){

        if(tailPointer == size -1){
            return headPointer == 0;
        }

        return false;
    }

    public int front(){
        return isEmpty() ? -1 : headPointer;
    }
}
