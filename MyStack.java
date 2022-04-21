package com.company;

public class MyStack<T extends Comparable<T>>{
    private MyArrayList<T> list;
    public MyStack(){
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

    public T peek(){
        return list.get(list.size()-1);
    }

    public T push(T item){
        list.add(item);
        return item;
    }

    public T pop(){
        return list.remove(list.size()-1);
    }
}
