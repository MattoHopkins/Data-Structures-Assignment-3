package Task2;


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.List;
import java.util.SortedSet;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sonia
 */
public class MapList<K,V> implements Map<K,V> {
    public Node<K,V> front;
    public Node<K,V> last;
    protected int count;
   
    public MapList (Association<K,V> data1)
        {
          Node<K,V> newNode= new Node(data1); 
          front=last=newNode;
          count=1;
        }
    
    public MapList ()
        {
            front=null;
            last=null;
            count=0;
        }
    
    
    public V put(K k, V v)
    // pre: k and v are non-null
    // post: inserts a mapping from k to v in the map
    {
        Association<K,V> temp = new Association<K,V>(k,v);
        V result = remove(k);
        
        add(temp);
        if (result == null) return null;
        else return result;
    }
    
  
    public void add(Association<K,V> val)
    {
        Node<K,V> prevNode= isExist(val.getKey());
        count++;
        
        if(prevNode==null)
        {
            System.out.println("Node not found");
            Node<K,V> newNode= new Node(val); 
             if(front==null)
                  front=last=newNode;
             else
             {
                 last.link=newNode;
                 last=newNode;
             }
        }
        else
         prevNode.data=val;
        

    }
    
    
    public V remove(K newKey)
    {
        V returnVal=null;
         
        Node<K,V> prevNode= isExist(newKey);
    
        
        if(prevNode!=null)
        {
            returnVal= prevNode.data.getValue();
            
            if(front==last)            
                front=last=null;
            else
            {
               Node <K,V> tmp=getParent(newKey);
               tmp.link=prevNode.link;
               if(tmp.link==null)
                   last=tmp;
            }
        count--; 
        }
            
        return returnVal;
    }
    
    private Node getParent(K newKey)
    {
        Node i=front;
        Node iParent=null;
        
        while(i!=null)
        {
            if(i.data.getKey()==newKey)
                return iParent;
            
            iParent=i;
            i=i.link;
        }
        
        return iParent;
    }
    
    
    
    private Node isExist(K newKey)
    {
        Node i=front;
        
        while(i!=null)
        {
            if(i.data.getKey().equals(newKey))
                return i;
            
            i=i.link;
        }
        
        return null;
    }
    

    public boolean isEmpty() {
        if(count==0)
            return true;
        else
                return false;
    }

    public boolean containsKey(K k) {
        if(isExist(k)!=null)
            return true;
        else
            return false;
    }

    public boolean containsValue(V v) {
        
        Node i=front;
        
        while(i!=null)
        {
            if(i.data.getValue()==v)
                return true;
            
            i=i.link;
        }
        
        return false;
    }

    public V get(K k) {
        Node<K,V> temp=isExist(k);
        if(temp==null)
            return null;
        else
            return temp.data.getValue();
    }


    
    public void clear() {
        front=last=null;
        count=0;
    }

    public int size()
    {
        return count;
    }
    
    
    public Set keySet() {
        Set keys = new HashSet();
        Node i=front;
        boolean t;
        
        while(i!=null)
        {
           t=keys.add(i.data.getKey());
        
            i=i.link;
        }
        return keys;
    }

    public Set entrySet() {
        Set keys = new LinkedHashSet();
        Node i=front;
        boolean t;
        
        
        while(i!=null)
        {
           t=keys.add((String) "("+ i.data.getKey()+""+ i.data.getValue2()+")\n");
        
           i=i.link;
        }
        
        
        return keys;
    }

    public void putAll(Map<K, V> other) {
        Set newData= other.entrySet();
        
        for(Object i : newData)
        {
            add((Association<K,V>)i);
        }
    }

   public Set values()
   {
          Set values = new HashSet();
        Node i=front;
        boolean t;
        
        while(i!=null)
        {
           t=values.add(i.data.getValue());
        
            i=i.link;
        }
        return values;
   }
    // post: returns a set that contains the range of the map
    

}
