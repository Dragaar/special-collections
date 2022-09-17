package com.efimchick.ifmo.collections;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

class MedianQueue extends LinkedList<Integer> {

    @Override
    public Integer poll() {
        Integer toRemove = peek();
        remove(toRemove);
        return toRemove;
    }

    @Override
    public Integer peek() {
        return median();
    }

    private Integer median(){

        int medianIndex = (this.size()-1)/2;
        //сортування в нормальному порядку
        this.sort(null);

        return (Integer) this.toArray()[medianIndex];
    }
}
