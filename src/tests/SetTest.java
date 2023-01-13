package tests;

import adt.Set;
import impl.BSTSet;
import instances.Student;

public class SetTest {
    public static void main(String[] args) {
        Set<Integer> bstSet = new BSTSet<>();
        bstSet.add(5);
        bstSet.add(12);
        bstSet.add(3);
        bstSet.add(-6);
        bstSet.add(8);
        bstSet.add(0);
        System.out.println(bstSet);
        System.out.println(bstSet.getSize());
        bstSet.add(14);
        bstSet.add(-6);
        bstSet.add(5);
        System.out.println(bstSet);
        System.out.println(bstSet.getSize());
        System.out.println(bstSet.contains(12));
        System.out.println(bstSet.contains(7));
        System.out.println(bstSet.contains(2));
        System.out.println(bstSet.contains(-8));
        System.out.println(bstSet.contains(5));
        System.out.println(bstSet);
        System.out.println(bstSet.getSize());
        System.out.println(bstSet.remove(0));
        System.out.println(bstSet.remove(6));
        System.out.println(bstSet.remove(3));
        System.out.println(bstSet);
        System.out.println(bstSet.getSize());
        System.out.println(bstSet.remove(12));
        System.out.println(bstSet);
        System.out.println(bstSet.getSize());
        System.out.println(bstSet.remove(5));
        System.out.println(bstSet);
        System.out.println(bstSet.getSize());
        try {
            System.out.println(bstSet.removeAny());
            System.out.println(bstSet.removeAny());
            System.out.println(bstSet.removeAny());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(bstSet);
        System.out.println(bstSet.getSize());




    }
}
