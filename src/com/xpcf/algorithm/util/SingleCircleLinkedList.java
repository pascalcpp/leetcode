package com.xpcf.algorithm.util;

/**
 * single circle linked list
 *
 * @author XPCF
 * @version 1.0
 * @date 4/10/2021 11:23 PM
 */
public class SingleCircleLinkedList<E> {


    /**
     * linked list head
     */
    private Node<E> head;

    /**
     * linked list tail
     */
    private Node<E> tail;

    /**
     * point to current node
     */
    public Node<E> curNode;


    /**
     * linked list nodes size
     */
    private int size;

    /**
     * add element to linked list tail
     *
     * @param element
     */
    public void addLast(E element) {

        Node<E> newNode = new Node<>(element);

        if (tail == null) {
            head = newNode;
            tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
            tail = newNode;
        }


    }

    /**
     * remove curNode at linked list
     */
    public E remove() {

        E element = curNode.element;
        if (head == tail) {
            head = null;
            tail = null;
            curNode = null;
        } else {
            Node<E> prev = curNode.prev;
            Node<E> next = curNode.next;
            prev.next = next;
            next.prev = prev;

            if (curNode == head) {
                head = next;
            }

            if (curNode == tail) {
                tail = prev;
            }
            curNode = curNode.next;
        }
        return element;
    }

    /**
     * point curNode to next node
     */
    public void next() {
        curNode = curNode.next;
    }

    /**
     * point curNode to head
     */
    public void reset() {
        curNode = head;
    }

    public static class Node<E> {

        Node<E> next;
        Node<E> prev;
        public E element;

        Node(Node<E> next, Node<E> prev, E element) {
            this.next = next;
            this.prev = prev;
            this.element = element;
        }

        Node(E element) {
            this.element = element;
        }

    }

}
