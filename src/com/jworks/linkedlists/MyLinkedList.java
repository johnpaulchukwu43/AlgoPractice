package com.jworks.linkedlists;

class MyLinkedList {

    private final Node head;

    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new Node(null);
        size = 0;
    }

    public static void main(String[] args) {
        // write your code here
        MyLinkedList myLinkedList = new MyLinkedList();
        System.out.println(myLinkedList.get(0));
        myLinkedList.addAtHead(10);
        myLinkedList.addAtTail(5);
        System.out.println(myLinkedList.get(0));
        myLinkedList.deleteAtIndex(1);
        myLinkedList.deleteAtIndex(10);
        System.out.println(myLinkedList.get(0));
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node current = head;

        if (index < 0 || index >= size) return -1;

        for (int i = 0; i < index+1; ++i) {
            current = current.getNext();
        }

        return current.getValue();
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        Node current = head;
        if(index > size) return;

        if (index < 0) index = 0;

        for (int i = 0; i < index; ++i) {
            current = current.getNext();
        }

        Node newNode = new Node(val);
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        size++;

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        Node current = head;
        if (index < 0 || index >= size) return;

        for (int i = 0; i < index; ++i) {
            current = current.getNext();
        }

        current.setNext(current.getNext().getNext());

        size--;

    }
}

