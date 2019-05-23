package com.lyyh.greenhouse.util;

import java.util.*;

public class MapList<K , V> {
    private Map<K, List<V>> map = new HashMap<>();

    private Comparator<V> comparator ;

    public MapList(Comparator<V> comparator) {
        this.comparator = comparator;
    }

    public boolean put(K k,V v){
        if(map.containsKey(k)){
            return map.get(k).add(v);
        } else {
            ArrayList<V> list = new ArrayList<>();
            boolean add = list.add(v);
            map.put(k, list);
            return add;
        }
    }

    public List<V> get(K k){
        List<V> list = map.get(k);
        if(list == null){
            return null;
        } else {
            Collections.sort(list,comparator);
            return list;
        }
    }

    public Set<K> keySet(){
        return this.map.keySet();
    }

}
