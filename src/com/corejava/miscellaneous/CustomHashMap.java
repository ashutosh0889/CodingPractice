package com.corejava.miscellaneous;

/**
 *
 * @author Ashutosh
 */
public class CustomHashMap<K,V> {
    private final int INITIAL_CAPACITY = 10;
    private Entry<K,V> []table;
    class Entry<K,V>{
        K key;
        V value;
        Entry<K,V> next;
        Entry(K key, V value,Entry<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    CustomHashMap(){
        table = new Entry[INITIAL_CAPACITY];
    }
    private int hash(K key){
        return Math.abs(key.hashCode())%INITIAL_CAPACITY;
    }
    public void put(K key, V value){
        if(key == null)
            return;
        int hash = hash(key);
        Entry<K,V> newEntry = new Entry(key,value,null);
        if(table[hash]==null){
            table[hash] = newEntry;
            return;
        }else{
            Entry<K,V> pre = null;
            Entry<K,V> current = table[hash];
            while(current != null){
                if(current.key.equals(key)){
                    if(pre == null){
                        newEntry.next = current.next;
                        table[hash] = newEntry;
                        return;
                    }else{
                        newEntry.next = current.next;
                        pre.next = newEntry;
                        return;
                    }
                }
                pre = current;
                current = current.next;
            }
            pre.next= newEntry;
        }
    }
    public V get(K key){
        if(key == null)
            return null;
        int hash = hash(key);
        if(table[hash] == null)
            return null;
        else{
           Entry<K,V> current = table[hash];
           while(current!=null){
               if(current.key.equals(key))
                   return current.value;
           current = current.next;
           }
        }
        return null;
    }
    public boolean remove(K key){
        int hash = hash(key);
        if(table[hash]==null)
            return false;
        else{
            Entry<K,V> pre = null;
            Entry<K,V> current = table[hash];
            while(current!=null){
                if(current.key.equals(key)){
                    if(pre == null)
                        table[hash]= current.next;
                    else
                        pre.next = current.next;
                    return true;
                }
            pre = current;
            current = current.next;
            }
        }
    return false;
    }
    public void print(){
        for(int i=0; i<INITIAL_CAPACITY; i++){
            Entry<K,V> entry = table[i];
            while(entry!=null){
                System.out.print("{"+entry.key+"="+entry.value+"}" +" ");
                entry=entry.next;
            }
        }
    }
}

class CustomHashMapTest{
    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put("Ashu", "Happy");
        map.put("Shravya", "Happy");
        map.put("Sony", "Happy");
        map.put("Everyone", "Happy");
        map.print();
        System.out.println("\nAshu is ::"+map.get("Ashu"));
        map.remove("Everyone");
        map.print();
    }

}
