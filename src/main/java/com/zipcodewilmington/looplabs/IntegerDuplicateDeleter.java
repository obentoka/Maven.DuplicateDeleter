package com.zipcodewilmington.looplabs;

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
        StringBuilder notDupeArray = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            Integer count = 0;
            for (int j = 0; j < array.length; j++) {
                if(array[i].equals(array[j]))
                    count++;
            }
            if(!(count >= maxNumberOfDuplications))
                notDupeArray.append(array[i]);
        }
        Integer[] retArray = new Integer[notDupeArray.length()];
        for (int i = 0; i < notDupeArray.length(); i++) {
            retArray[i] = Integer.parseInt("" + notDupeArray.charAt(i));
        }
        return retArray;
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        StringBuilder notDupeArray = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            Integer count = 0;
            for (int j = 0; j < array.length; j++) {
                if(array[i].equals(array[j]))
                    count++;
            }
            if(!(count == exactNumberOfDuplications))
                notDupeArray.append(array[i]);
        }
        Integer[] retArray = new Integer[notDupeArray.length()];
        for (int i = 0; i < notDupeArray.length(); i++) {
            retArray[i] = Integer.parseInt("" + notDupeArray.charAt(i));
        }
        return retArray;
    }
}
