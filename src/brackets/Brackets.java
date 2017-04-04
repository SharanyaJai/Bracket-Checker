/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brackets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Checks if brackets match or not in a given source code
 *
 * @author sharanya
 */
public class Brackets {

    int  lengthofStr;
    char[] s;

    

    /**
     * Reads the given command line file and stores in character array s
     *
     * @param args contains the name of the file that contains the code to be
     * read
     * @throws IOException
     */
    public void readCode(String args) throws FileNotFoundException, IOException {

        System.out.println("Name of file entered: " + args + "");
        BufferedReader in = new BufferedReader(new FileReader(args)); //Reading source file
        String st;
        st = in.readLine();
        s = new char[st.length()]; //decalring a character array equal to s' length
        System.out.println(st);
        st = st.replace(" ", ""); //deleting white spaces
        
        s = st.toCharArray();
        lengthofStr = st.length();// converting to charcater array
    }

    /**
     * Checks for braces and displays if braces match or not
     * @throws IOException 
     */
    public void checkBraces() throws IOException {
        //Decalring 4 different stacks for each type of bracket { ( [
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        Stack<Character> stack3 = new Stack<>();
       

        //System.out.println(stack1.toString());
        try {
            //System.out.println(s);
            for (int i = 0; i < lengthofStr; i++) {

                //Based on type of bracket, either a push or a pop operation is performed
                //item is pushed onto stack if open brace is encountered, popped if closing brace is encountered
                if (s[i] == '{') {
                    // System.out.println(s[i]);
                    stack1.push(s[i]);
                } else if (s[i] == '(') {
                    // System.out.println(s[i]);
                    stack2.push('(');
                } else if (s[i] == '[') {
                    // System.out.println(s[i]);
                    stack3.push('[');
                }  else if (s[i] == '}') {
                    //System.out.println(s[i]);
                    stack1.pop();
                } else if (s[i] == ')') {
                    //System.out.println(s[i]);
                    stack2.pop();
                } else if (s[i] == ']') {
                    //System.out.println(s[i]);
                    stack3.pop();
                } 

            }
            //If all four stacks are empty, it signifies that all braces match.
            if (stack1.isEmpty() && stack2.isEmpty() && stack3.isEmpty()) {
                System.out.println("Braces Match");
            } else {
                System.out.println("Braces Don't Match"); //If even one or more stacks are not empty then there is a mismatch of braces
            }
        } catch (EmptyStackException e) {
            System.out.println("Braces Don't match"); //Exception occurs when a closing bracket is encountered even before an open bracket. In this case, pop operation throws en empty stack exception which signifies that braces don't match
        }
    }

}
