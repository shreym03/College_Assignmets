import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

class FileHandle 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("Your file should be placed at : " + System.getProperty("user.dir"));
        Scanner readMyFile = new Scanner(new File(args[0]));

        //Open file for writing content
        System.out.println("Output file will be created at : " + System.getProperty("user.dir"));
        PrintWriter writeToMyFile = new PrintWriter(new File(args[1]));
        while(readMyFile.hasNext()) 
        {
            // Read the content of input file
            // Read 3 integers
            int a=readMyFile.nextInt();
            int b=readMyFile.nextInt();
            int c=readMyFile.nextInt();

            //Read the string
            String name=readMyFile.next(); //not readMyFile.nextLine()
            //Read a float
            float f=readMyFile.nextFloat();

            //Display the content of input file
            System.out.printf("%d %d %d %s %f%n", a,b,c,name,f);
	




	    //You can also use System.out.print to display one data type at a time.
            /*
             * %n is a new line character appropriate to the platform running the application. 
             * You should always use %n, rather than \n. 
             */

            //Write data to file
            int result=(a*a) + (b*b) +(c*c);
            System.out.format("(a*a + b*b + c*c) = %d %s %f%n", result, name, f);
            writeToMyFile.format("(a*a + b*b + c*c) = %d %s %f%n", result, name, f);
            /*
             * Again writeToMyFile.print can be use to write one data type at a type.
             */
        }
        readMyFile.close();
        writeToMyFile.close();
    }
}
/* now try to read inputs for these fields from keyboard */
