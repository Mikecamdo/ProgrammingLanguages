/*	
    CS 3342 - Programming Languages
    Sample program for homework 2
    Regular Expression - DFA
	
*/

import java.io.*;
import java.lang.String;

public class HW2_RegExp_Sample
{ public static void main(String argv[]) throws IOException
  { 

        File file = new File("test_sample.txt"); 
       
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        
        String st; 
        int line_num = 0;
        while ((st = br.readLine()) != null) 
        {
          line_num++;
          System.out.printf("This is line %d    :  ",line_num); 
          System.out.println(st); 
          String[] parts = st.split(" ");

          System.out.println(" ********* This is for the first RE - (a|b)cd*  "); 
          for (int i=0; i < parts.length; i++ )
          {
            String result = processRE1(parts[i]);
            System.out.println("      From main :  " + result + " - " + parts[i]); 
    
          }

          System.out.println(" ********* This is for the second RE - a(bc)*d  ");
          for (int i=0; i < parts.length; i++ )
          {
            String result = processRE2(parts[i]);
            System.out.println("      From main :  " + result + " - " + parts[i]); 
    
          }
    
      
        }
          
    
  }

  static String processRE1(String in_str) 
  {
    //This is for RE - (a|b)cd*
    int i=0;
    System.out.println("RE is : (a|b)cd* & input string is :  " + in_str);
   
    if (in_str.substring(i,i+1).equals("a") || in_str.substring(i,i+1).equals("b"))
    {        
      i++;
      if (in_str.substring(i,i+1).equals("c"))
      {   
        i++;

        while (i < in_str.length() && in_str.substring(i,i+1).equals("d"))
        {
          i++;
        }
       
        if (in_str.length() == i)
        {
            return "Accept";
        }
         
      }
    }
     return "Reject";
  }

  static String processRE2(String in_str) 
  {
    //This is for RE - a(bc)*d
    int i=0;
    System.out.println("RE is : a(bc)*d & input string is :  " + in_str);
   
    if (in_str.substring(i,i+1).equals("a"))
    {        
      i++;

      while (i < in_str.length() && in_str.substring(i,i+1).equals("b"))
      {
        i++;
        if (in_str.substring(i,i+1).equals("c")) {
          i++;
        } else {
          return "Reject"; 
        }
      }
      if (i < in_str.length() && in_str.substring(i,i+1).equals("d"))
      {   
        i++;
       
        if (in_str.length() == i)
        {
            return "Accept";
        }
         
      }
    }
     return "Reject";
  }

  
}
