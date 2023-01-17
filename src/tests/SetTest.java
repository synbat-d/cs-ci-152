package tests;

import adt.Set;
import impl.BST2Set;
import impl.BSTSet;
import instances.Student;

public class SetTest {
    public static void main(String[] args) {
        Set<Integer> bstSet = new BST2Set<>();
        bstSet.add(5);
        bstSet.add(12);
        bstSet.add(3);
        bstSet.add(-6);
        bstSet.add(8);
        bstSet.add(0);
        System.out.println(bstSet);
        System.out.println(bstSet.getSize());
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println(bstSet.remove(3));
        System.out.println(bstSet);
        System.out.println(bstSet.getSize());
        System.out.println("-------------------------------------------------------------------------------------");
        try {
            System.out.println(bstSet.removeAny());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(bstSet);
        System.out.println(bstSet.getSize());
        System.out.println("-------------------------------------------------------------------------------------");
        try {
            System.out.println(bstSet.removeAny());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(bstSet);
        System.out.println(bstSet.getSize());
        System.out.println("-------------------------------------------------------------------------------------");
        try {
            System.out.println(bstSet.removeAny());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(bstSet);
        System.out.println(bstSet.getSize());
        System.out.println("-------------------------------------------------------------------------------------");
        try {
            System.out.println(bstSet.removeAny());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(bstSet);
        System.out.println(bstSet.getSize());
        System.out.println("-------------------------------------------------------------------------------------");
        try {
            System.out.println(bstSet.removeAny());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(bstSet);
        System.out.println(bstSet.getSize());

    }
}
