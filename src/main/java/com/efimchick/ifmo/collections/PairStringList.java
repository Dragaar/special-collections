package com.efimchick.ifmo.collections;

import java.util.*;

class PairStringList<E> extends AbstractList {

    LinkedList<E> list = new LinkedList<>();

    @Override
    public boolean add(Object o) {
        return list.add((E)o) & list.add((E)o);
    }

    @Override
    public void add(int index, Object element){
        int n = checkEvenOdd(index);
        list.add(n, (E)element);
        list.add(n, (E)element);

        //System.out.println(n + " / ");
    }

    @Override
    public boolean addAll(int index, Collection c) {
        boolean modified = false;
        int ex = 0;
        for (Object e : c) {
            //System.out.println(e + " / ");
            add(index+ex, e);
            ex+=2;
            modified = true;
        }
        return modified;
    }

    @Override
    public Object set(int index, Object element) {

       int n = checkEvenOdd2(index);

                   list.set(n , (E)element);
        Object r = list.set(n+1 , (E)element);

        //System.out.println("n = " + n + " / " + list);
        return r;

    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o) & list.remove(o);
    }
    @Override
    public E remove(int index) {
        E r = list.get(index);
        list.remove(index-1);
        list.remove(index-1);
        return r;
    }

    @Override
    public void clear() {
        Iterator<E> iterator =  list.iterator();
        while (iterator.hasNext()) {iterator.next(); iterator.remove();}
    }

    @Override
    public Object get(int index) {
        return list.get(index);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(E e : list) { builder.append(e);}
        return builder.toString();

    }
    private int checkEvenOdd(int index){
        if(index%2==0) return index; else return index+1;
    }
    private int checkEvenOdd2(int index){
        if(index%2==0) return index; else return index-1;
    }

    public static void main(String[] args) {
        List<String> list = new PairStringList();
        list.add("a");
        list.add("a");
        list.add("a");
        list.add(0, "b");
        list.add(3, "c");
        list.add(4, "d");

        list.set(0, "e");
        list.set(9, "f");
        list.set(6, "g");
        System.out.println("size = " +  list.size());
        System.out.println(String.join(" ", list));

    }
}
