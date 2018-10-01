/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task1;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author matto
 */
public class BinarySearchTreeMap {

    protected static TreeNode searchTree;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter parent node values\nKey: ");
        String key = scanner.nextLine();
        System.out.println("Value:");
        String value = scanner.nextLine();

        searchTree = new TreeNode(new Association(key, value));
        
        
        boolean exit = false;
        while (exit == false) {
            
            
            System.out.println("");
            System.out.println("Binary Search Tree Map");
            System.out.println("Please Make a Selection:");
            System.out.println("\t1)Enter Data");
            System.out.println("\t2)View Entry Set");
            System.out.println("\t3)View Key Set");
            System.out.println("\t4)View Value Set");
            System.out.println("\t5)Display Tree Height");
            System.out.println("\t6)Search by Key");
            System.out.println("Enter Anything Other Number to Quit");
            try {
                int number_input = scanner.nextInt();

                switch (number_input) {
                    case 1:
                        System.out.println("\n\n1 Entered. Enter Key for new Tree Node");
                        inputNode();
                        break;
                    case 2:
                        System.out.println("\n\n2 Entered. Viewing Entry Set");
                        entrySet(searchTree);
                        break;
                    case 3:
                        System.out.println("\n\n3 Entered. Viewing Key Set");
                        keySet(searchTree);
                        break;
                    case 4:
                        System.out.println("\n\n4 Entered. Viewing Value Set");
                        valueSet(searchTree);
                        break;
                    case 5:
                        System.out.println("\n\n5 Entered. Displaying Tree height");
                        System.out.println(heightOfTree(searchTree));
                        break;
                    case 6:
                        System.out.println("\n\n6 Entered. Finding Key");
                        findKey();
                        break;
                    default:
                        exit = true;
                        break;
                }

            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("Wrong input detected");
            }
        }
    }

    public static void entrySet(TreeNode myBTree) //post: Traverse the Tree inOrder and prints it
    {
        if (myBTree == null) {
            return;
        }
        entrySet(myBTree.left);
        System.out.println("[("+myBTree.getKey() + "), (" + myBTree.data.toString()+")]");
        entrySet(myBTree.right);
    }

    public static void keySet(TreeNode myBTree) //post: Traverse the Tree inOrder and prints it
    {
        if (myBTree == null) {
            return;
        }
        keySet(myBTree.left);
        System.out.println(myBTree.getKey());
        keySet(myBTree.right);
    }

    public static void valueSet(TreeNode myBTree) //post: Traverse the Tree inOrder and prints it
    {
        if (myBTree == null) {
            return;
        }
        valueSet(myBTree.left);
        System.out.println(myBTree.data.toString());
        valueSet(myBTree.right);
    }

    public static int heightOfTree(TreeNode n) {
        int height = n.treeHeight(n);

        return height;
    }

    public static void inputNode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter node values\nKey: ");
        String temp = scanner.nextLine();
        System.out.println("Value:");
        String temp2 = scanner.nextLine();
        searchTree.add(new TreeNode(new Association(temp, temp2)));
    }
    
    public static void findKey()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Key: ");
        String key = scanner.nextLine();
        if(searchTree.get(key)!= null)
        {
            System.out.println(searchTree.get(key));
        }
        else
        {
            System.out.println("Key not found");
        }
        
    }
}
