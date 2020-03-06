package com.zipcodewilmington.looplabs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {

    public StringDuplicateDeleter(String[] intArray) {
        super(intArray);
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        Map<String, Integer> count = new HashMap<>();
        Integer size = 0;
        for(String e : this.array){
            if(!count.containsKey(e))
                count.put(e, 1);
            else {
                Integer curVal = count.get(e);
                count.replace(e, curVal, curVal + 1);
            }
        }
        List<String> dupe = new ArrayList<>();
        for(Map.Entry<String, Integer> e : count.entrySet()){
            if(e.getValue() >= maxNumberOfDuplications) {
                dupe.add(e.getKey());
                size += e.getValue();
            }
        }
        String[] retArray = new String[this.array.length - size];
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
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        Map<String, Integer> count = new HashMap<>();
        Integer size = 0;
        for(String e : this.array){
            if(!count.containsKey(e))
                count.put(e, 1);
            else
                count.replace(e, count.get(e), count.get(e)+1);
        }
        List<String> dupe = new ArrayList<>();
        for(Map.Entry<String, Integer> e : count.entrySet()){
            if(e.getValue() == exactNumberOfDuplications) {
                size++;
                dupe.add(e.getKey());
            }
        }
        String[] retArray = new String[this.array.length - (size * exactNumberOfDuplications)];
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
