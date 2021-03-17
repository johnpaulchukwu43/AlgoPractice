package com.jworks.linkedlists;

public class MyDoublyLinkedList {

    private DoublyNode head;


    public MyDoublyLinkedList() {
        head = null;
    }

    /** Helper function to return the index-th node in the linked list. */
    private DoublyNode getNode(int index) {
        DoublyNode cur = head;
        for (int i = 0; i < index && cur != null; ++i) {
            cur = cur.next;
        }
        return cur;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        DoublyNode cur = getNode(index);
        return cur == null ? -1 : cur.val;
    }

    private DoublyNode getTail() {
        DoublyNode cur = head;
        while (cur != null && cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        DoublyNode cur = new DoublyNode(val);
        cur.next = head;
        if (head != null) {
            head.prev = cur;
        }
        head = cur;
        return;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }
        DoublyNode prev = getTail();
        DoublyNode cur = new DoublyNode(val);
        prev.next = cur;
        cur.prev = prev;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        DoublyNode prev = getNode(index - 1);
        if (prev == null) {
            return;
        }
        DoublyNode cur = new DoublyNode(val);
        DoublyNode next = prev.next;
        cur.prev = prev;
        cur.next = next;
        prev.next = cur;
        if (next != null) {
            next.prev = cur;
        }
    }

}
