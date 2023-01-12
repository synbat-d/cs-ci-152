package impl;

import adt.Deque;
import adt.Queue;
import adt.Set;
import adt.Stack;

public class Helper {
    public static boolean isIncreasing(Stack<Double> st) throws Exception {
        boolean result = true;
        Stack<Double> tempStack = new LinkedListStack<>();
        int size = st.getSize();
        if (size == 0) {
            return false;
        } else if (size == 1) {
            return true;
        } else {
            Double temp1 = st.pop();
            Double temp2;
            tempStack.push(temp1);
            while (st.getSize() != 0) {
                temp2 = st.pop();
                tempStack.push(temp2);
                if (temp2 > temp1) {
                    result = false;
                    break;
                } else {
                    temp1 = temp2;
                }
            }
            while (tempStack.getSize() != 0) {
                st.push(tempStack.pop());
            }
            return result;
        }
    }

    public static boolean isBalanced(Queue<Character> q) throws Exception {
        int count = 0;
        char temp1;
        char temp2;
        char temp3;
        boolean result = true;
        int size = q.getSize();
        if (size == 0) {
            return true;
        }
        if (size % 2 != 0) {
            return false;
        }
        Stack<Character> tempStack = new LinkedListStack<>();
        Stack<Character> reversedStack = new LinkedListStack<>();
        Stack<Character> normalStack = new LinkedListStack<>();
        for (int i = 0; i < size; i++) {
            Character temp = q.dequeue();
            if (!(temp == '(' || temp == ')' || temp == '[' || temp == ']' || temp == '{' || temp == '}')) {
                throw new Exception("There are characters that are not brackets");
            }
            q.enqueue(temp);
            reversedStack.push(temp);
            tempStack.push(temp);
        }
        for (int i = 0; i < size; i++) {
            normalStack.push(tempStack.pop());
        }
        while (normalStack.getSize() != 0) {
            if (count == size / 2) {
                break;
            }
            temp1 = normalStack.pop();
            temp2 = normalStack.pop();
            if (!doesSecondBracketCloseFirst(temp1, temp2)) {
                temp3 = reversedStack.pop();
                if (!doesSecondBracketCloseFirst(temp1, temp3)) {
                    result = false;
                    break;
                }
                normalStack.push(temp2);
            }
            count++;
        }
        return result;
    }

    private static boolean doesSecondBracketCloseFirst(char firsBracket, char secondBracket) {
        switch (firsBracket) {
            case ('('): {
                if (secondBracket == ')') {
                    return true;
                } else {
                    return false;
                }
            }
            case ('['): {
                if (secondBracket == ']') {
                    return true;
                } else {
                    return false;
                }
            }
            case ('{'): {
                if (secondBracket == '}') {
                    return true;
                } else {
                    return false;
                }
            }
            default: {
                return false;
            }

        }
    }

    public static Deque<Integer> merge(Deque<Integer> d1, Deque<Integer> d2) throws Exception {
	/* assuming d1 and d2 are sorted, merge their contents
       into a single sorted Deque, and return it */
        Deque<Integer> result = new LinkedListDeque<>();
        int temp1;
        int temp2;
        int size1 = d1.getSize();
        int size2 = d2.getSize();
        while (result.getSize() != size1 + size2) {
            temp1 = d1.popFromFront();
            temp2 = d2.popFromFront();
            if (temp1 <= temp2) {
                result.pushToBack(temp1);
                d2.pushToFront(temp2);
                if (d1.getSize() == 0) {
                    int biggestValue = d2.popFromBack();
                    d2.pushToBack(biggestValue);
                    d1.pushToFront(biggestValue + 10);
                }
            } else {
                result.pushToBack(temp2);
                d1.pushToFront(temp1);
                if (d2.getSize() == 0) {
                    int biggestValue = d1.popFromBack();
                    d1.pushToBack(biggestValue);
                    d2.pushToFront(biggestValue + 10);
                }
            }
        }
        return result;
    }

    public static Deque<Integer> mergeSort(Deque<Integer> deq) throws Exception {
     /* Step 0:  base case???
        Step 1:  split deq into two Deques of relatively equal size
        Step 2:  pass both of these Deques into mergeSort
        Step 3:  pass the resulting Deques into merge, and return the result
     */
        if (deq.getSize() == 1) {
            return deq;
        }
        int size = deq.getSize();
        int size1 = size / 2;
        int size2 = size - size1;
        Deque<Integer> firstHalf = new LinkedListDeque<>();
        Deque<Integer> secondHalf = new LinkedListDeque<>();
        for (int i = 0; i < size1; i++) {
            int temp = deq.popFromFront();
            firstHalf.pushToBack(temp);
            deq.pushToBack(temp);
        }
        for (int i = 0; i < size2; i++) {
            int temp = deq.popFromFront();
            secondHalf.pushToBack(temp);
            deq.pushToBack(temp);
        }
        firstHalf = mergeSort(firstHalf);
        secondHalf = mergeSort(secondHalf);
        Deque<Integer> sortedDeq = merge(firstHalf, secondHalf);
        return sortedDeq;
    }

    public static boolean isSubset(Set<Integer> set1, Set<Integer> set2) {
        int set1Size = set1.getSize();
        if (set1Size == 0) {
            return true;
        }
        Set<Integer> tempSet = new LLStackSet<>();
        Set<Integer> copyOftempSet = new LLStackSet<>();
        for (int i = 0; i < set1Size; i++) {
            try {
                int tempVal = set1.removeAny();
                tempSet.add(tempVal);
                copyOftempSet.add(tempVal);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < set1Size; i++) {
            try {
                set1.add(copyOftempSet.removeAny());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            for (int i = 0; i < set1Size; i++) {
                if (!set2.contains(tempSet.removeAny())) {
                    return false;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }

    public static Set<String> copySetForString(Set<String> set) {
        int size = set.getSize();
        if (size == 0) {
            return new LLStackSet<String>();
        }
        Set<String> copyWhichWillBeReturned = new LLStackSet<>();
        Set<String> copyWhichWillBeEmtied = new LLStackSet<>();
        try {
            for (int i = 0; i < size; i++) {
                String temp = set.removeAny();
                copyWhichWillBeEmtied.add(temp);
                copyWhichWillBeReturned.add(temp);
            }
            for (int i = 0; i < size; i++) {
                set.add(copyWhichWillBeEmtied.removeAny());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return copyWhichWillBeReturned;
    }

    public static Set<Integer> copySetForInteger(Set<Integer> set) {
        int size = set.getSize();
        if (size == 0) {
            return new LLStackSet<Integer>();
        }
        Set<Integer> copyWhichWillBeReturned = new LLStackSet<>();
        Set<Integer> copyWhichWillBeEmtied = new LLStackSet<>();
        try {
            for (int i = 0; i < size; i++) {
                Integer temp = set.removeAny();
                copyWhichWillBeEmtied.add(temp);
                copyWhichWillBeReturned.add(temp);
            }
            for (int i = 0; i < size; i++) {
                set.add(copyWhichWillBeEmtied.removeAny());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return copyWhichWillBeReturned;
    }

    public static Set<String> union(Set<String> set1, Set<String> set2) {
        int set1Size = set1.getSize();
        int set2Size = set2.getSize();
        Set<String> copy1 = copySetForString(set1);
        Set<String> copy2 = copySetForString(set2);
        try {
            for (int i = 0; i < set2Size; i++) {
                copy1.add(copy2.removeAny());
            }
        } catch (Exception ex) {
        }
        return copy1;
    }

    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> copy1 = copySetForInteger(set1);
        Set<Integer> copy2 = copySetForInteger(set2);
        Set<Integer> result = new LLStackSet<>();
        try {
            while (!(copy1.getSize() == 0 || copy2.getSize() == 0)) {
                int temp1 = copy1.removeAny();
                if (copy2.contains(temp1)) {
                    result.add(temp1);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
