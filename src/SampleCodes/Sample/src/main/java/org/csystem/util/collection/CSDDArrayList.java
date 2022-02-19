package org.csystem.util.collection;

public class CSDDArrayList<E> {
    private Node<E> m_head;
    private Node<E> m_tail;
    private int m_count;

    private static class Node<E> {
        E elem;
        Node<E> next;
        Node<E> prev;
    }

    //...
}
