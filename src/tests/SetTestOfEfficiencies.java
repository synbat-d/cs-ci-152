package tests;

import adt.Set;
import impl.LLQHashTableSet;

public class SetTestOfEfficiencies {
    public static void main(String[] args) {
        Set<Integer> set = new LLQHashTableSet(5000);
        System.out.println("Starting timing tests...");
        long time1, time2, duration;
        time1 = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            set.add(i);
        }
        time2 = System.currentTimeMillis();
        duration = time2 - time1;
        System.out.println("Time taken in ms: " + duration);
    }
}
