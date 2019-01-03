package com.ittest.Iterator_DesignPattern.test;

public class Test {
    public static void main(String[] args) {
        /*ArrayList al = new ArrayList();
        for (int i = 0; i < 15; i++) {
            al.add(new Cat(i));
        }
        System.out.println(al.size());*/
//        LinkedList l = new LinkedList();
        Collection c = new LinkedList();
        for (int i = 0; i < 15; i++) {
            c.add(new Cat(i));
        }
        System.out.println(c.size());
//        ArrayList al = (ArrayList) c;
        Iterator it = c.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            System.out.println(o + " ");
        }

    }
}
