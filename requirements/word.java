import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;


class word {
         
        public static void main(String args[]) 
        throws FileNotFoundException {
         int loop;
         loop = 2;
         
         Scanner written = new Scanner(new File("type.txt"));
         Scanner myscanner = new Scanner(System.in);
         String karim;
         String space;
         String reader;
         reader = written.nextLine();
         space =" ";
         System.out.println(reader);
         
         karim = myscanner.nextLine();
         
         while (loop != 0) {
         
         
         
         	
         
         
         
         
         
         
         
         
         PrintStream diskWriter =
                       new PrintStream("type.txt");
 	     
         diskWriter.print(reader+space+karim );
       
       	
         }     
}
}