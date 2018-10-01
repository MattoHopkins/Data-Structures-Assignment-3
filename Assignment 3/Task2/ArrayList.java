/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task2;

import java.text.*;
import java.util.*;

/**
 * @author sonia
 */
public class ArrayList<E> extends AbstractList<E> implements List<E> {

    public Object[] elementData;
    private Object[] timeEntered;
    private int[] seconds;
    private int size;
    private DateFormat dateFormat;
    private Calendar cal;
    //Capacity of ArrayList

    /*Constructs an empty list with an initial capacity of ten. */
    public ArrayList() {
        this(10);
        elementCount = 0;
        size = 10;

    }

    /**
     * * Constructs an empty list with the specified initial capacity.
     */
    public ArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }

        this.elementData = new Object[initialCapacity];
        this.seconds = new int[initialCapacity];
        this.timeEntered = new Object[initialCapacity];
        size = initialCapacity;
        elementCount = 0;
        dateFormat = new SimpleDateFormat("dd/MM/yy hh:mm:ss a");
        cal = Calendar.getInstance();

    }

    /*Returns the element at the specified position in this list. */
    public E get(int index) {
        rangeCheck(index);
        return (E) elementData[index];
    }

    public int getSeconds(int index) {
        rangeCheck(index);
        return seconds[index];
    }

    public E getTime(int index) {
        rangeCheck(index);
        return (E) timeEntered[index];
    }

    /* Replaces the element at the specified position in this list with the specified element.*/
    public E set(int index, E element) {
        rangeCheck(index);
        E oldValue = (E) elementData[index];
        elementData[index] = element;
        return oldValue;
    }

    /* Checks if the given index is in range. */
    private void rangeCheck(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("out Of Bound index");
        }
    }

    /* Inserts the specified element at the specified position in this list. */
    public Object[] add(int index, E element) {

        rangeCheck(index);
        elementData[index] = element;
        seconds[index] = (int) System.currentTimeMillis() / 1000;
        timeEntered[index] = dateFormat.format(cal.getInstance().getTime());
        elementCount++; // Increments  the element count of the array
        return elementData;
    }

    /* Removes the element at the specified position in this list.*/
    public E remove(int index) {
        rangeCheck(index);
        E oldValue = (E) elementData[index];
        seconds[index] = 0;
        elementData[index] = null;
        --elementCount;
        return oldValue;
    }

    public int getSize() {
        return size;
    }

    public int getElementCount() {
        return elementCount;
    }

    public int indexOf(E car) {
        int place = -1;
        System.out.println(car);
        System.out.println(elementData[0]);
        for (int k = 0; k < size; k++) {
            if (elementData[k] != null) {
                if (elementData[k].equals(car)) {
                    place = k;
                    break;
                }
            }
        }
        return place;

    }
    
    public String toString()
    {
        String list = "[";
        for(int k = 0; k<elementCount-1; k++)
        {
            list += elementData[k]+ ", ";
        }
        
        list +=elementData[elementCount-1]+ "]";
        return list;
    }
    
    

}
