package impl;

import adt.HashTableSet;

public class BSTHashTableSet<T extends Comparable> implements HashTableSet<T> {
    private BSTSet<T>[] buckets;
    private int size;
    private int numberOfBuckets;

    public BSTHashTableSet(int numberOfBuckets) {
        size = 0;
        this.numberOfBuckets = numberOfBuckets;
        buckets = new BSTSet[numberOfBuckets];
    }

    @Override
    public int getNumberOfBuckets() {
        return numberOfBuckets;
    }

    @Override
    public int getBucketSize(int index) throws Exception {
        if(index >= numberOfBuckets && index<0) {
            throw new IllegalArgumentException("Not correct index");
        }
        BSTSet<T> element = buckets[index];
        if(element==null) {
            return 0;
        }
        return element.getSize();
    }

    @Override
    public double getLoadFactor() {
        return (double)size/(double)numberOfBuckets;
    }

    @Override
    public double getBucketSizeStandardDev() {
        int averageBucketSize=0;
        for (int i=0; i<numberOfBuckets; i++) {
            BSTSet<T> element = buckets[i];
            if(element==null) {
                averageBucketSize = averageBucketSize + 0;
            }
            else {
                averageBucketSize = averageBucketSize + element.getSize();
            }
        }
        averageBucketSize = averageBucketSize/numberOfBuckets;
        int squareSum = 0;
        for (int i=0; i<numberOfBuckets; i++) {
            BSTSet<T> element = buckets[i];
            if(element==null) {
                squareSum = squareSum + averageBucketSize*averageBucketSize;
            }
            else {
                squareSum =
                    squareSum + (averageBucketSize-element.getSize())*(averageBucketSize-element.getSize());
            }
        }
        double result = Math.sqrt((double)squareSum/(double)(numberOfBuckets-1));
        return result;
    }

    @Override
    public String bucketsToString() {
        String result;
        if (size==0) {
            result = "Empty set";
        }
        result = "Start of set: \n";
        for (int i=0; i<buckets.length; i++) {
            if(buckets[i]==null) {
                continue;
            }
            if (buckets[i].getSize()==0) {
                continue;
            }
            BSTSet<T> element = buckets[i];
            result = result + element.toString() + "\n";
        }
        result = result + "end";
        return result;
    }

    @Override
    public void add(T value) {
        int bucketNumber = Math.abs(value.hashCode())%buckets.length;
        if(buckets[bucketNumber]==null) {
            buckets[bucketNumber] = new BSTSet<>();
        }
        if(!buckets[bucketNumber].contains(value)) {
            buckets[bucketNumber].add(value);
            size++;
        }
    }

    @Override
    public boolean contains(T value) {
        int bucketNumber = Math.abs(value.hashCode())%buckets.length;
        if(buckets[bucketNumber]==null) {
            return false;
        }
        return buckets[bucketNumber].contains(value);
    }

    @Override
    public boolean remove(T value) {
        int bucketNumber = Math.abs(value.hashCode())%buckets.length;
        if(buckets[bucketNumber]==null) {
            return false;
        }
        if(buckets[bucketNumber].contains(value)) {
            size--;
            return buckets[bucketNumber].remove(value);
        }
        return false;
    }

    @Override
    public T removeAny() throws Exception {
        if(size==0) {
            throw new Exception("Set is empty, nothing to remove");
        }
        BSTSet<T> element = buckets[0];
        for (int i=0; i<buckets.length; i++) {
            element = buckets[i];
            if(element==null) {
                continue;
            }
            if(element.getSize()==0) {
                continue;
            }
            break;
        }
        size--;
        return element.removeAny();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        buckets = new BSTSet[numberOfBuckets];
        size=0;
    }

    @Override
    public String toString() {
        String result;
        if (size==0) {
            result = "Empty set";
        }
        result = "";
        for (int i=0; i<buckets.length; i++) {
            if(buckets[i]==null) {
                continue;
            }
            if (buckets[i].getSize()==0) {
                continue;
            }
            BSTSet<T> element = buckets[i];
            result = result + element.toString();
        }
        return result;
    }
}
