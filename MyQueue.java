package com.company;

public class MyQueue<T extends Comparable<T>>{
    private MyLinkedList<T> list;
    public MyQueue(){
        list = new MyLinkedList<>();
    }

    public T enqueue(T item){
        if(list.size()==0){
            list.add(item);
        }else{
            list.add(item, list.size());
        }
        return item;
    }

    public T dequeue(){
        if(list.size()!=0){
            return list.remove(0);
        }else{
            throw new RuntimeException("Queue is empty");
        }
    }

    public int size() {
        return list.size();
    }

    public T peek(){
        return list.get(0);
    }

    public boolean empty(){
        if(list.size()==0){
            return true;
        }else{
            return false;
        }
    }

}
