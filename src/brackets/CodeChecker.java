/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brackets;

import java.io.IOException;

/**Invokes Brackets object to check if braces match in a given file
 * @author sharanya
 */
public class CodeChecker {
 public static void main(String[] args) throws IOException
 {
     Brackets obj= new Brackets(); //Declare an object method
     obj.readCode(args[0]);
     obj.checkBraces();//invole checkbrackets method of Brackets class
 }
}
