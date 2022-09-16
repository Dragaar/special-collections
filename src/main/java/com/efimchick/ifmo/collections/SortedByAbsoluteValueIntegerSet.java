package com.efimchick.ifmo.collections;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.stream.Stream;


class SortedByAbsoluteValueIntegerSet<E> extends TreeSet {


    TreeSet<E> sortedSet = new TreeSet<>(new Comparator<E>() {
        @Override
        public int compare(E o1, E o2) {
            int ret = 0;
            if(Math.abs( (int)o1 ) > Math.abs( (int)o2 )) ret = 1; else ret = -1;
            return ret;
        }
    });

    @Override
    public int size() {
        return sortedSet.size();
    }

    @Override
    public boolean add(Object o) {
        return sortedSet.add((E)o);
    }


    @Override
    public boolean remove(Object o) {

        Iterator<E> iterator = sortedSet.iterator();
        while (iterator.hasNext()) {
            if(iterator.next().equals(o)) {
                //System.out.println("1111");
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return sortedSet.iterator();
    }

    @Override
    public boolean contains(Object o) {
        Iterator<E> iterator = sortedSet.iterator();
        while (iterator.hasNext()) {
            if(iterator.next().equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Stream stream() {
        return sortedSet.stream();
    }

    @Override
    public boolean equals(Object o) {
        return sortedSet.equals(o);
    }

    @Override
    public int hashCode() {
        return sortedSet.hashCode();
    }
}

