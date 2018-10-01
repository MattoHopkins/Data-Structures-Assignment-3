package Task2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author sonia
 */
public class Node <K,V> {
public Association<K,V> data;
public Node<K,V> link;

  public Node(Association<K,V> data1) {
            data=data1;
            link=null;
  }


}

     
    
    