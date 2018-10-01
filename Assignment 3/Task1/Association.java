package Task1;

import Task2.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sonia
 */

public class Association<K,V>
{
protected K theKey; // the key of the key-value pair
protected V theValue; // the value of the key-value pair
/*
for example:
Association<String,Integer> personAttribute =
new Assocation<String,Integer>("Age",34);
*/
public Association(K key, V value)
// pre: key is non-null
// post: constructs a key-value pair
{
    theKey=key;
    theValue=value;
}
public V getValue()
// post: returns value from association
{
    return this.theValue;
}
public K getKey()
// post: returns key from association
{
    return theKey;
}
public V setValue(V value)
// post: sets association's value to value
{
    this.theValue=value;
    return value;
}

public String getValue2()
// post: returns value from association
{
    return this.theValue.toString();
}
}


