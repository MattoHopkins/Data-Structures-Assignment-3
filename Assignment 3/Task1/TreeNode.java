/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task1;

/**
 *
 * @author sonia
 */
public class TreeNode<K, V> implements BinaryTree<K, V> {

    public V data;
    public K key;
    public TreeNode parent;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
        data = null;
        parent = left = right = null;
    }

    public TreeNode(Association<K, V> newEntry) {
        this.data = newEntry.getValue();
        this.key = newEntry.getKey();
        parent = left = right = null;
    }

    public TreeNode(Association<K, V> newEntry, TreeNode p) {
        this.key = newEntry.getKey();
        data = newEntry.getValue();
        parent = p;
        left = right = null;
    }

    public BinaryTree<K, V> left() // post: returns reference to (possibly empty) left subtree
    {
        return this.left;
    }

    public BinaryTree<K, V> right() // post: returns reference to (possibly empty) left subtree
    {
        return this.right;
    }

    public BinaryTree<K, V> parent() // post: returns reference to parent node, or null
    {
        return this.parent;
    }

    public void setLeft(TreeNode<K, V> newLeft) // post: sets left subtree to newLeft
    {
        this.left = newLeft;
    }

    public void setRight(TreeNode<K, V> newRight) // post: sets left subtree to newLeft
    {
        this.right = newRight;
    }

    // re-parents newLeft if not null
    public void setParent(TreeNode<K, V> newParent) // post: re-parents this node to parent reference, or null
    {
        this.parent = newParent;
    }
//public Iterator<E> iterator()
    // post: returns an in-order iterator of the elements

    public boolean isLeftChild() // post: returns true if this is a left child of parent
    {
        if (this.parent.left == this) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isRightChild() // post: returns true if this is a left child of parent
    {
        if (this.parent.right == this) {
            return true;
        } else {
            return false;
        }
    }

    public V value() // post: returns value associated with this node
    {
        return this.data;
    }

    public void setValue(V value) // post: sets the value associated with this node
    {
        this.data = value;
    }

    public boolean isEmpty() //post: returns true if the data of the node is null else returns false
    {
        if (this.data == null) {
            return true;
        } else {
            return false;
        }
    }

    public K getKey() {
        return this.key;
    }

    public V get(K key)
    {
         if (((String)key).equals((String)getKey())) {
             return data;
            }
        if (((String) key).compareTo((String) getKey()) < 0) {
            if (left == null) {
               
            } else {
            return (V)left.get(key);
            }
        }
        if (((String) key).compareTo((String) getKey()) > 0) {
            if (right == null) {
               
            } else {
             return (V)right.get(key);
            }
        }
       
        
        return null;
    }
    public void add(TreeNode<K, V> newAddition) {

        if (((String) newAddition.getKey()).compareTo((String) getKey()) < 0) {
            if (left == null) {
                left = newAddition;
                //System.out.println("Set left: " + newAddition.getKey());
            } else {
                left.add(newAddition);
            }
        }
        if (((String) newAddition.getKey()).compareTo((String) getKey()) > 0) {
            if (right == null) {
                right = newAddition;
                //System.out.println("Set right: " + newAddition.getKey());

            } else {
                right.add(newAddition);
            }
        }
        if (((String) newAddition.getKey()).compareTo((String) getKey()) == 0) {
                   
               setValue((V)(data + ", " + newAddition.data));
            }

        }    

    
    public int treeHeight(TreeNode n) {
        if (n != null) {
            int height_of_left = treeHeight(n.left);
            int height_of_right = treeHeight(n.right);

            if (height_of_right < height_of_left) {
                return (height_of_left + 1);
            } else {
                return (height_of_right + 1);
            }
        } else {
            return 0;
        }

    }

}
