package LeetCode42;

import java.util.LinkedList;

public class MyHashSet {

    /**
     * Initialize your data structure here.
     */
    LinkedList<Integer>[] table;

    public MyHashSet() {
        this.table = new LinkedList[1000];
    }

    public void add(int key) {
        int index = key % 1000;
        if (table[index] == null) {
            table[index] = new LinkedList<Integer>();
        }
        if (!table[index].contains((Object) key)) {
            table[index].add(key);
        }
    }

    public void remove(int key) {
        int index = key % 1000;
        if (table[index] != null) {
            table[index].remove((Object) key);
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int index = key % 1000;
        if (table[index] == null) {
            return false;
        }
        return table[index].contains(key);
    }

    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();
        obj.add(100);
        obj.remove(100);
        boolean param_3 = obj.contains(100);
        System.out.println(param_3);
    }
}
