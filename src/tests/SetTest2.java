package tests;

import adt.Set;
import impl.BST2Set;

public class SetTest2 {
    public static void main(String[] args) {
        Set<Integer> setBst2 = new BST2Set<Integer>();
        for (int i = 0; i < 50; i++) {
            setBst2.add(i * i);
            setBst2.add(-i);
        }
        System.out.println(setBst2.remove(49));
        System.out.println(setBst2);
        System.out.println(setBst2.getSize());
        for (int i = 0; i < 98; i++) {
            try {
                System.out.println(setBst2.removeAny());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(setBst2.getSize());
        System.out.println(setBst2);
    }
}
