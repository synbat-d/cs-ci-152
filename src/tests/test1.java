package tests;

import adt.Deque;
import adt.Queue;
import adt.SortedQueue;
import adt.Stack;

import impl.*;
import instances.Student;

public class test1 {
    public static void main(String[] args) {
        Deque<Integer> deq = new LinkedListDeque<>();
        deq.pushToFront(2000);
        deq.pushToFront(2);
        deq.pushToFront(200);
        deq.pushToFront(3000);
        deq.pushToFront(1);
        deq.pushToFront(500);
        deq.pushToFront(0);
        deq.pushToFront(45);
        deq.pushToFront(10000);
        deq.pushToFront(10000);
        System.out.println(deq);
        try {
            Deque<Integer> sortedDeq = Helper.mergeSort(deq);
            System.out.println(sortedDeq);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(deq);

    }
}