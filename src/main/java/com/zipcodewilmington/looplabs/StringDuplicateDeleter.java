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
        Integer differentNumbers = 1;
        for (int i = 1; i < array.length; i++) {
            if(!array[i].equals(array[i-1]))
                differentNumbers++;
        }
        String[][] mapInt = new String[2][differentNumbers];
        Integer mapIntCounter = 0;
        for (int i = 1; i < array.length; i++) {
            if(i == 1){
                mapInt[0][mapIntCounter] = array[i-1];
                mapInt[1][mapIntCounter] = "1";
            }
            if(array[i].equals(array[i-1])){
                mapInt[1][mapIntCounter] += "1";
            }else {
                mapIntCounter++;
                mapInt[0][mapIntCounter] = array[i];
                mapInt[1][mapIntCounter] = "1";
            }
        }
        Integer sumOfDupes = 0;
        for (int i = 0; i < differentNumbers; i++) {
            if(mapInt[1][i].length() >= maxNumberOfDuplications)
                sumOfDupes += mapInt[1][i].length();
        }
        String[] retArray = new String[array.length - sumOfDupes];
        Integer retArrayCounter = 0;
        for (int i = 0; i < array.length; i++) {
            Boolean isNotDupe = true;
            for (int j = 0; j < differentNumbers; j++) {
                if(mapInt[0][j].equals(array[i]) && mapInt[1][j].length() >= maxNumberOfDuplications){
                    isNotDupe = false;
                }
            }
            if(isNotDupe) {
                retArray[retArrayCounter] = array[i];
                retArrayCounter++;
            }
        }
        return retArray;
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        Integer differentNumbers = 1;
        for (int i = 1; i < array.length; i++) {
            if(!array[i].equals(array[i-1]))
                differentNumbers++;
        }
        String[][] mapInt = new String[2][differentNumbers];
        Integer mapIntCounter = 0;
        for (int i = 1; i < array.length; i++) {
            if(i == 1){
                mapInt[0][mapIntCounter] = array[i-1];
                mapInt[1][mapIntCounter] = "1";
            }
            if(array[i].equals(array[i-1])){
                mapInt[1][mapIntCounter] += "1";
            }else {
                mapIntCounter++;
                mapInt[0][mapIntCounter] = array[i];
                mapInt[1][mapIntCounter] = "1";
            }
        }
        Integer sumOfDupes = 0;
        for (int i = 0; i < differentNumbers; i++) {
            if(mapInt[1][i].length() == exactNumberOfDuplications)
                sumOfDupes += mapInt[1][i].length();
        }
        String[] retArray = new String[array.length - sumOfDupes];
        Integer retArrayCounter = 0;
        for (int i = 0; i < array.length; i++) {
            Boolean isNotDupe = true;
            for (int j = 0; j < differentNumbers; j++) {
                if(mapInt[0][j].equals(array[i]) && mapInt[1][j].length() == exactNumberOfDuplications){
                    isNotDupe = false;
                }
            }
            if(isNotDupe) {
                retArray[retArrayCounter] = array[i];
                retArrayCounter++;
            }
        }
        return retArray;
    }
}
