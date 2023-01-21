package tests;

import adt.HashTableSet;
import adt.Set;
import impl.BSTHashTableSet;
import impl.LLQHashTableSet;

public class HashTableSetTest {
    public static void main(String[] args) {
        HashTableSet testSet = new BSTHashTableSet(20);
        for (int i=1; i<21; i++) {
            testSet.add(i);
        }
        for (int i=2; i<21; i=i+2) {
            testSet.remove(i);
        }
        for(int i=10; i<101; i++) {
            testSet.remove(i);
        }
        for(int i=1; i<31; i++) {
            testSet.add(i);
        }
        System.out.println(testSet.getSize());
        try {
            for(int i=0; i<10; i++) {
                System.out.println(testSet.removeAny());
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        testSet.clear();
        System.out.println(testSet.getSize());
        System.out.println(testSet);
        System.out.println("-------------------------------------------");
        for (int i=51; i<80; i=i+2) {
            testSet.add(i);
        }
        System.out.println(testSet);
        System.out.println(testSet.getSize());
        System.out.println("Here will be stats displayed");
        System.out.println("Bucket number "+testSet.getNumberOfBuckets());
        System.out.println("Load factor: " + testSet.getLoadFactor());
        System.out.println("Spread"+ testSet.getBucketSizeStandardDev());
        System.out.println(testSet.bucketsToString());
    }
}
