package com.company;

import sun.net.www.content.text.Generic;

public class MyHeap<T extends  Comparable<T>> {
    private MyArrayList<T> list;
    public MyHeap(){
        list = new MyArrayList<>();
    }
    public boolean empty(){
        if(list.size()!=0){
            return false;
        }else{
            return true;
        }
    }

    public int size(){
        return list.size();
    }

    public T getMin(){
        return list.get(0);
    }

    public void insert(T item){
        list.add(item);
        int currentIndex = size()-1;
        while (list.get(currentIndex).compareTo(list.get(parent(currentIndex)))>0) {
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }
    }

    public T removeRoot(){
        Object temp = list.get(0);
        list.remove(0);//delete first element, after that move array and minHeapify it
        minHeapify(0);
        return (T)temp;
    }

    public boolean remove(T item){
        boolean result = false;
        if(list.contains(item)){
            list.remove(list.indexOf(item));
            minHeapify(0);
        }
        return result;
    }

    //private methods

    private int parent(int index) {
        return index/ 2;
    }

    private int leftChildOf(int Index) {
        return (2 * Index);
    }

    private int rightChildOf(int Index)
    {
        return (2 * Index) + 1;
    }

    private void swap(int index1, int index2){
        Object temp1 = list.get(index1);
        Object temp2 = list.get(index2);

        list.remove(index2);
        list.add((T)temp1, index2);

        list.remove(index1);
        list.add((T)temp2, index1);
    }

    private void minHeapify(int Index){
        Index = Index-1;

        if (list.get(Index).compareTo(list.get(leftChildOf(Index)))>0
                || list.get(Index).compareTo(list.get(rightChildOf(Index)))>0) {

            if (list.get(leftChildOf(Index)).compareTo(list.get(rightChildOf(Index)))<0){
                swap(Index, leftChildOf(Index));
                minHeapify(leftChildOf(Index));
            }
            else {
                swap(Index, rightChildOf(Index));
                minHeapify(rightChildOf(Index));
            }
        }
    }
}

