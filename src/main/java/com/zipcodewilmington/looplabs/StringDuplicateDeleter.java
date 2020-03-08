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
        StringBuilder notDupeArray = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            Integer count = 0;
            for (int j = 0; j < array.length; j++) {
                if(array[i].equals(array[j]))
                    count++;
            }
            if(!(count >= maxNumberOfDuplications))
                notDupeArray.append(array[i] + " ");
        }
        if(notDupeArray.length() == 0)
            return new String[0];
        else
            return notDupeArray.toString().split(" ");
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        StringBuilder notDupeArray = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            Integer count = 0;
            for (int j = 0; j < array.length; j++) {
                if(array[i].equals(array[j]))
                    count++;
            }
            if(!(count == exactNumberOfDuplications))
                notDupeArray.append(array[i] + " ");
        }
        if(notDupeArray.length() == 0)
            return new String[0];
        else
            return notDupeArray.toString().split(" ");
    }
}
