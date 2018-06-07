package com.corejava.miscellaneous;

import java.util.Arrays;

/**
 *
 * @author Ashutosh
 */
public class CustomArrayList<E> {
    private final int INITIAL_CAPACITY = 10;
    private Object []elementData;
    int size = 0;
    
    CustomArrayList(){
        elementData = new Object[INITIAL_CAPACITY];
    }
    public void reSize(){
        int newCapacity = (Integer)INITIAL_CAPACITY + INITIAL_CAPACITY * 3/2;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
    public void add(E obj){
        if(size == elementData.length)
            reSize();
        elementData[size++] = obj;
    }
    public E get(int index){
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index not found");
        return (E)elementData[index];
    }
    public E remove(int index){
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index not found");
        E temp = (E)elementData[index];
        for(int i= index; i< size; i++){
            elementData[i] = elementData[i+1];
        }
        size--;
        return temp;
    }
    public void diaplay(){
        for(Object o : elementData){
            if(o != null)
                System.out.println(" "+o+" ");
        }
    }
}


class CustomArrayListTest{
    public static void main(String[] args) {
        CustomArrayList carr = new CustomArrayList();
        carr.add("Manishaa");
        carr.add("Shivam");
        carr.add("Ashutosh");
        System.out.println("***********************************************");
       carr.diaplay();
       carr.remove(1);
        System.out.println("***********************************************");
       carr.diaplay();
       System.out.println("***********************************************");
        System.out.println("Returned List Obj::"+carr.get(0));
        System.out.println("***********************************************");
    }
}
