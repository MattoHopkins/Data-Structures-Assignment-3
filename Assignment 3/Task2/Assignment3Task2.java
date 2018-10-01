/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task2;

import java.io.FileNotFoundException;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matto
 */
public class Assignment3Task2 {

    public static void main(String[] args) throws FileNotFoundException {

        MapList wordList = new MapList<>();

        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        
       try {
            String read = "";
            String input = "";
            int line_number = 0;
            String[] words;
            while ((read = br.readLine()) != null) {

                line_number++;
                read = read.toLowerCase();
                input += read + "\n";

               
                words = read.split(" ");
                
                for(int k = 0; k<words.length; k++)
                {
                    words[k] = words[k].replace(".","");
                }
                
                
                System.out.println("Words per line: " + words.length);
                ArrayList<Integer> lineList;
                /*
                    This takes each word from each line and sorts it through the MapList. 
                    If they key already exists, the value is stored into the lineList and then it is repeated for each word in the line.
                */
                for (int k = 0; k < words.length; k++) {
                    String test = words[k];
                    lineList = (ArrayList<Integer>) wordList.get(test);
                    if (lineList==null) {
                        System.out.println("List is null");
                        lineList = new ArrayList<Integer>(50);
                        lineList.add(0,line_number);
                        wordList.put(test,lineList);
                    } 
                    else
                    {
                       if(lineList.indexOf(line_number) == -1)
                       lineList.add(lineList.elementCount,line_number);
                    }
                    
                    
                  
                }
            }

            System.out.println(input);
        } catch (IOException ex) {
            Logger.getLogger(Assignment3Task2.class.getName()).log(Level.SEVERE, null, ex);
        }

       System.out.println(wordList.entrySet());
       
        
        
    }
}

