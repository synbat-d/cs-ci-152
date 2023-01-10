package tests;

import adt.Deque;
import adt.Queue;
import adt.SortedQueue;
import adt.Stack;

import impl.*;
import instances.Student;

public class test1 {
    public static void main(String[] args) {
        Student s1 = new Student("Akhmet", "Yassaui", 23, 2);
        Student s4 = new Student("Timur", "Zhanibek", 22, 5);
        Student s2 = new Student("Akerke", "Assetova", 21, 3);
        Student s3 = new Student("Symbat", "Dulatuly", 23, 4);
        Deque<Student> deq = new LinkedListDeque<>();
        deq.pushToBack(s1);
        deq.pushToFront(s2);
        deq.pushToFront(s3);
        System.out.println(deq);
        try {
            deq.popFromFront();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(deq);
        deq.pushToFront(s4);
        System.out.println(deq);
        try {
            deq.popFromBack();
        } catch (Exception e) {
            e.printStackTrace();
        }
        deq.pushToBack(s3);
        System.out.println(deq);
        System.out.println(deq.getSize());
        try {
            System.out.println(deq.popFromFront());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(deq.getSize());
        try {
            System.out.println(deq.popFromBack());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(deq.getSize());
        try {
            System.out.println(deq.popFromFront());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(deq.getSize());
    }
}