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
public interface BinaryTree<K,V> {
      
    public BinaryTree<K,V> parent();
    // post: returns reference to parent node, or null
    public BinaryTree<K,V> left();
    // post: returns reference to (possibly empty) left subtree
    public BinaryTree<K,V> right();
    // post: returns reference to (possibly empty) right subtree
    public void setLeft(TreeNode<K,V> newLeft);
    // post: sets left subtree to newLeft
    // re-parents newLeft if not null
      public void setRight(TreeNode<K,V> newRight);
    // post: sets right subtree to newLeft
    // re-parents newRight if not null
    public void setParent(TreeNode<K,V> newParent);
    // post: re-parents this node to parent reference, or null
    public boolean isLeftChild();
    // post: returns true if this is a left child of parent
       public boolean isRightChild();
    // post: returns true if this is a right child of parent
    public V value();
    // post: returns value associated with this node
    public void setValue(V value);
    // post: sets the value associated with this node
    public boolean isEmpty();
    //post: returns true if data is null for this node
    public K getKey();
    //post: returns key associated with this node
    public void add(TreeNode<K,V> newAddition);
    
    public V get(K key);
    public int treeHeight(TreeNode N);
}
