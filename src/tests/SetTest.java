package tests;

import adt.Set;
import impl.Helper;
import impl.LLQueueSet;
import impl.LLStackSet;

public class SetTest {
    public static void main(String[] args) {
        Set<String> set1 = new LLStackSet<>();
        Set<String> set2 = new LLStackSet<>();

        set1.add("Alua");
        set1.add("Zhazira");
        set1.add("Saniya");
        set1.add("Alma");
        set1.add("Erzhan");

        set2.add("Zhazira");
        set2.add("Erzhan");
        set2.add("Timur");
        set2.add("Yerkin");
        set2.add("Denis");
        set2.add("Almas");

        System.out.println(set1);
        System.out.println(set2);

        System.out.println(Helper.union(set1, set2));

        System.out.println(set1);
        System.out.println(set2);
        Set<Integer> set3 = new LLStackSet<>();
        Set<Integer> set4 = new LLStackSet<>();
        for (int i = 5; i < 25; i++) {
            set3.add(i);
        }
        for (int i = 15; i < 35; i++) {
            set4.add(i);
        }
        System.out.println(set3);
        System.out.println(set4);
        System.out.println(Helper.intersection(set3, set4));
        System.out.println(set3);
        System.out.println(set4);
    }
}
