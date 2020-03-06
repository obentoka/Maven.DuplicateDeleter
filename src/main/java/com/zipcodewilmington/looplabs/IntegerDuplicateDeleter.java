package com.zipcodewilmington.looplabs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {
    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
    }

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        Map<Integer, Integer> count = new HashMap<>();
        Integer size = 0;
        for(Integer e : this.array){
            if(!count.containsKey(e))
                count.put(e, 1);
            else {
                Integer curVal = count.get(e);
                count.replace(e, curVal, curVal + 1);
            }
        }
        List<Integer> dupe = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e : count.entrySet()){
            if(e.getValue() >= maxNumberOfDuplications) {
                dupe.add(e.getKey());
                size += e.getValue();
            }
        }
        Integer[] retArray = new Integer[this.array.length - size];
        Integer counter = 0;
        for (int i = 0; i < this.array.length; i++) {
            if(!dupe.contains(this.array[i])){
                retArray[counter] = this.array[i];
                counter++;
            }
        }
        return retArray;
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        Map<Integer, Integer> count = new HashMap<>();
        Integer size = 0;
        for(Integer e : this.array){
            if(!count.containsKey(e))
                count.put(e, 1);
            else
                count.replace(e, count.get(e), count.get(e)+1);
        }
        List<Integer> dupe = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e : count.entrySet()){
            if(e.getValue() == exactNumberOfDuplications) {
                size++;
                dupe.add(e.getKey());
            }
        }
        Integer[] retArray = new Integer[this.array.length - (size * exactNumberOfDuplications)];
        Integer counter = 0;
        for (int i = 0; i < this.array.length; i++) {
            if(!dupe.contains(this.array[i])){
                retArray[counter] = this.array[i];
                counter++;
            }
        }
        return retArray;
    }
}
