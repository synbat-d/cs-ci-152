package impl;

import adt.HashTableSet;
import adt.Set;

public class LLQHashTableSet<T> implements HashTableSet<T> {
    private int numberOfBuckets;
    private LinkedListQueue<T>[] bucket;
    private int size;

    public LLQHashTableSet(int numberOfBuckets) {
        this.numberOfBuckets = numberOfBuckets;
        bucket = new LinkedListQueue[numberOfBuckets];
        size = 0;
    }
    @Override
    public void add(T value) {
        int bucketNumber = Math.abs(value.hashCode())%bucket.length;
        if(!containsHelper(bucketNumber, value)) {
            size++;
            if(bucket[bucketNumber]==null) {
                bucket[bucketNumber] = new LinkedListQueue<T>();
            }
            bucket[bucketNumber].enqueue(value);
        }
    }

    private boolean containsHelper(int bucketNumber, T value) {
        if(bucket[bucketNumber]==null) {
            return false;
        }
        LinkedListQueue<T> element = bucket[bucketNumber];
        for(int i=0; i< element.getSize(); i++) {
            T temp = null;
            try {
                temp = element.dequeue();
            } catch (Exception e) {
            }
            element.enqueue(temp);
            if(temp.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(T value) {
        int bucketNumber = Math.abs(value.hashCode())%bucket.length;
        return containsHelper(bucketNumber, value);
    }

    @Override
    public boolean remove(T value) {
        int bucketNumber = Math.abs(value.hashCode())%bucket.length;
        if(!containsHelper(bucketNumber, value)) {
            return false;
        }
        else {
            LinkedListQueue<T> element = bucket[bucketNumber];
            T temp = null;
            for(int i=0; i<element.getSize(); i++) {
                try {
                    temp = element.dequeue();
                } catch (Exception e) {
                }
                if(!temp.equals(value)) {
                    element.enqueue(temp);
                }
            }
            size--;
            return true;
        }
    }

    @Override
    public T removeAny() throws Exception {
        if(size==0) {
            throw new Exception("Set is empty, nothing to remove");
        }
        T temp = null;
        for(int i=0; i<bucket.length; i++) {
            if(bucket[i]==null) {
                continue;
            }
            LinkedListQueue<T> element = bucket[i];
            if(element.getSize()==0) {
                continue;
            }
            temp = element.dequeue();
            size--;
            break;
        }
        return temp;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        bucket = new LinkedListQueue[numberOfBuckets];
        size = 0;
    }

    @Override
    public String toString() {
        String result;
        if (size==0) {
            result = "Empty set";
        }
        result = "";
        for (int i=0; i<bucket.length; i++) {
            if(bucket[i]==null) {
                continue;
            }
            if (bucket[i].getSize()==0) {
                continue;
            }
            LinkedListQueue<T> element = bucket[i];
            result = result + element.toString();
        }
        return result;
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
        LinkedListQueue<T> element = bucket[index];
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
            LinkedListQueue<T> element = bucket[i];
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
            LinkedListQueue<T> element = bucket[i];
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
        for (int i=0; i<bucket.length; i++) {
            if(bucket[i]==null) {
                continue;
            }
            if (bucket[i].getSize()==0) {
                continue;
            }
            LinkedListQueue<T> element = bucket[i];
            result = result + element.toString() + "\n";
        }
        result = result + "end";
        return result;
    }
}
