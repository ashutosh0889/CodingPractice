package com.corejava.miscellaneous;

public class HashSetCustom<E>{
    
    
    private CustomHashMap<E, Object> hashMapCustom;
 
    public HashSetCustom(){
        hashMapCustom=new CustomHashMap<>();
    }
    
    /**
     * add objects in SetCustom.
     */
    public void add(E value){
           hashMapCustom.put(value, null);
    }
 
    /**
     * Method returns true if set contains the object.
     * @param key
     */
    public boolean contains(E obj){
           return hashMapCustom.contains(obj) !=null ? true :false;
    }
    
    /**
     * Method displays all objects in setCustom.
     * insertion order is not guaranteed, for maintaining insertion order refer LinkedHashSet.
     */
    public void display(){
       hashMapCustom.print();
    }
   
    /**
     * Method removes object from setCustom.
     * @param obj
     */
    public boolean remove(E obj){
       return hashMapCustom.remove(obj);
    } 
   
}
