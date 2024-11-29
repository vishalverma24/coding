package org.example;

import org.w3c.dom.Node;

public class LinkedList {

    Node head;

    public static class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
            this.next = null;
        }
    }


    public LinkedList insertInLinkedList(LinkedList list, int d) {

        Node newNode = new Node(d);

        if (list.head == null) {
            list.head = newNode;
        } else {

            Node curr = list.head;
            while (curr.next != null) {
                curr = curr.next;
            }

            curr.next = newNode;
        }

        return list;
    }


    public void printLinkedList(LinkedList list){

        Node curr = list.head;

        while(curr!=null){
            System.out.print(curr.data + "->");
            curr = curr.next;
        }

        System.out.println("null");
    }


    public LinkedList reverseLinkedList(LinkedList list){
        Node curr = list.head;
        Node prev = null;
        Node next = null;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        list.head = prev;

        return list;
    }


    public boolean detectLoop (LinkedList list) {
        Node slow = list.head;
        Node fast = list.head;

        while(slow!=null || fast!=null || fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }

        return false;
    }

}
