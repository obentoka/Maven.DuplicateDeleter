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
        Integer differentNumbers = 1;
        for (int i = 1; i < array.length; i++) {
            if(array[i] != array[i-1])
                differentNumbers++;
        }
        Integer[][] mapInt = new Integer[2][differentNumbers];
        Integer mapIntCounter = 0;
        for (int i = 1; i < array.length; i++) {
            if(i == 1){
                mapInt[0][mapIntCounter] = array[i-1];
                mapInt[1][mapIntCounter] = 1;
            }
            if(array[i] == array[i-1]){
                mapInt[1][mapIntCounter] += 1;
            }else {
                mapIntCounter++;
                mapInt[0][mapIntCounter] = array[i];
                mapInt[1][mapIntCounter] = 1;
            }
        }
        Integer sumOfDupes = 0;
        for (int i = 0; i < differentNumbers; i++) {
            if(mapInt[1][i] >= maxNumberOfDuplications)
                sumOfDupes += mapInt[1][i];
        }
        Integer[] retArray = new Integer[array.length - sumOfDupes];
        Integer retArrayCounter = 0;
        for (int i = 0; i < array.length; i++) {
            Boolean isNotDupe = true;
            for (int j = 0; j < differentNumbers; j++) {
                if(mapInt[0][j] == array[i] && mapInt[1][j] >= maxNumberOfDuplications){
                    isNotDupe = false;
                }
            }
            if(isNotDupe) {
                retArray[retArrayCounter] = array[i];
                retArrayCounter++;
            }
        }
        return retArray;
//        Map<Integer, Integer> count = new HashMap<>();
//        Integer size = 0;
//        for(Integer e : this.array){
//            if(!count.containsKey(e))
//                count.put(e, 1);
//            else {
//                Integer curVal = count.get(e);
//                count.replace(e, curVal, curVal + 1);
//            }
//        }
//        List<Integer> dupe = new ArrayList<>();
//        for(Map.Entry<Integer, Integer> e : count.entrySet()){
//            if(e.getValue() >= maxNumberOfDuplications) {
//                dupe.add(e.getKey());
//                size += e.getValue();
//            }
//        }
//        Integer[] retArray = new Integer[this.array.length - size];
//        Integer counter = 0;
//        for (int i = 0; i < this.array.length; i++) {
//            if(!dupe.contains(this.array[i])){
//                retArray[counter] = this.array[i];
//                counter++;
//            }
//        }
//        return retArray;
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        Integer differentNumbers = 1;
        for (int i = 1; i < array.length; i++) {
            if(array[i] != array[i-1])
                differentNumbers++;
        }
        Integer[][] mapInt = new Integer[2][differentNumbers];
        Integer mapIntCounter = 0;
        for (int i = 1; i < array.length; i++) {
            if(i == 1){
                mapInt[0][mapIntCounter] = array[i-1];
                mapInt[1][mapIntCounter] = 1;
            }
            if(array[i] == array[i-1]){
                mapInt[1][mapIntCounter] += 1;
            }else {
                mapIntCounter++;
                mapInt[0][mapIntCounter] = array[i];
                mapInt[1][mapIntCounter] = 1;
            }
        }
        Integer sumOfDupes = 0;
        for (int i = 0; i < differentNumbers; i++) {
            if(mapInt[1][i] == exactNumberOfDuplications)
                sumOfDupes += mapInt[1][i];
        }
        Integer[] retArray = new Integer[array.length - sumOfDupes];
        Integer retArrayCounter = 0;
        for (int i = 0; i < array.length; i++) {
            Boolean isNotDupe = true;
            for (int j = 0; j < differentNumbers; j++) {
                if(mapInt[0][j] == array[i] && mapInt[1][j] == exactNumberOfDuplications){
                    isNotDupe = false;
                }
            }
            if(isNotDupe) {
                retArray[retArrayCounter] = array[i];
                retArrayCounter++;
            }
        }
        return retArray;
//        Map<Integer, Integer> count = new HashMap<>();
//        Integer size = 0;
//        for(Integer e : this.array){
//            if(!count.containsKey(e))
//                count.put(e, 1);
//            else
//                count.replace(e, count.get(e), count.get(e)+1);
//        }
//        List<Integer> dupe = new ArrayList<>();
//        for(Map.Entry<Integer, Integer> e : count.entrySet()){
//            if(e.getValue() == exactNumberOfDuplications) {
//                size++;
//                dupe.add(e.getKey());
//            }
//        }
//        Integer[] retArray = new Integer[this.array.length - (size * exactNumberOfDuplications)];
//        Integer counter = 0;
//        for (int i = 0; i < this.array.length; i++) {
//            if(!dupe.contains(this.array[i])){
//                retArray[counter] = this.array[i];
//                counter++;
//            }
//        }
//        return retArray;
    }
}
