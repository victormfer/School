import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class Evaluator {
	
/*Author: Victor Fernandez
*Prof: Hossain
*TA: Anthony
*Last Edit: 4/23/17
*/
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
       System.out.print("Please, enter file name : ");
       Scanner in=new Scanner(System.in);
       String fileName;
       fileName=in.next();
      //fileName="input.txt";
       try (BufferedReader br = new BufferedReader(new FileReader(fileName))) 
       {
    String line;
    while ((line = br.readLine()) != null) {
        try
        {
             String[] ops = line.split(" ");
       GenericStack st=new GenericStack();
       for(int i=0;i<ops.length;i++)
       {
           //System.out.println(ops[i]);
          if(isOperator(ops[i]))
          {
              double op1=objectToDouble(st.pop());
              double op2=objectToDouble(st.pop());
              double result=0;
             switch (ops[i].toString()) 
             {
                case "+": result=op1+op2;     
                break;
                case "*": result=op1*op2;    
                break;
                case "-": result=op2-op1;    
                break;
                case "/": result=op2/op1; 
                break;
             }
             st.push(result);
          } else
          {
             st.push(objectToDouble(ops[i])); 
          }
       } //end for
       if(st.getSize()==1)
       {
           System.out.println(line+" = "+st.pop());
       } else
       {
         System.out.println(line+" cannot be evaluated !");  
       }
       
       
        }
        catch(Exception ex)
        {
        System.out.println(line+" cannot be evaluated !");
        }
       
    }
}
    }
 static boolean isOperator(Object o) 
 {
     String s=o.toString().trim();
     return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") ;
 }   
 static double objectToDouble(Object o) 
 {
     String s=o.toString().trim();     
     return Double.parseDouble(s);
 }
}
