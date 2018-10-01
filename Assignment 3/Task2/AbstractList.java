/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task2;

/**
 *
 */
public abstract class AbstractList<E> implements List<E> {

    protected int elementCount;

    public boolean isEmpty() {
        return elementCount == 0;
    }

}
