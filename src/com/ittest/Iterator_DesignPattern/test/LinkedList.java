package com.ittest.Iterator_DesignPattern.test;

public class LinkedList implements Collection{
    Node head = null;
    int size = 0;
    Node tail = null;
    public void add(Object o) {
        Node n = new Node(o, null);
        if (head == null) {
            tail = n;
            head = n;
        }else {
            tail.setNext(n);
            tail = n;
        }
        size++;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return new LinkedlistIterator();
    }

    private class LinkedlistIterator implements Iterator {
        Node n = head;
        @Override
        public Object next() {
            Object m = n.getData();
            n = n.getNext();
            return m;
        }

        @Override
        public boolean hasNext() {
            return n != null;
        }
    }
}
