package csvsearch;

/*
 *  take input for text to search for
 *  find directory of csv files
 *  open them one at a time
 *  search for selected text
 *  print: file name, column number, and column title "last name"
 *
 *  Code by: Patrick Hennis
 *  Email: patrickhennis@gmail.com
 */
import java.util.Scanner;
import java.io.*;
public class csvsearch {
   public static void main(String[] args) {
     System.out.println("Output will appear as following: File Name, Row Number, and Specified Column");
     String search, path, column;
     Scanner kb = new Scanner (System.in);
     System.out.print("Enter phrase to search: ");
     search = kb.nextLine();
     System.out.println("Enter full path to Directory of csv files: ");
     path = kb.nextLine();
     System.out.println("Specify column to be printed (Enter none to not print anything): ");
     column = kb.nextLine();
     if (column.equalsIgnoreCase("none")) {
       System.out.print("testing");
     } else {
       System.out.print("testing");
     }
     File[] files = new File(path).listFiles();
     findFiles(files, column);
   }

   public static void findFiles(File[] files, String column) throws IOException {
       for (File file : files) {
           if (file.isDirectory()) {
             BufferedReader reader =new BufferedReader(new FileReader(file.getName()));
             String line = "";
              while((line=reader.readLine())!=null){
                String [] employee =line.trim().split(",");
                System.out.println("File: " + file.getName() + ", Row Number: " + "...");
                if(!column.equalsIgnoreCase("none")) {
                  System.out.println("Specified Column: " + printColumn(files, column));
                } else {
                  System.out.println(".");
                }
              }
              findFiles(files, column);
           } else {
             System.out.println("File: " + file.getName() + ", Row Number: " + "...");
             if(!column.equalsIgnoreCase("none")) {
               System.out.print(", Specified Column: " + "...");
             } else {
               System.out.print(".");
             }
           }
       }
    }

    @SuppressWarnings("deprecation")
	public static String printColumn(File[] files, String column) {
       int columnnum = Integer.parseInt(column.trim());
       String thisLine;
       int count = 0;
       FileInputStream fis = new FileInputStream(files.getName());
       DataInputStream myInput = new DataInputStream(fis);
       int i = 0;
       while ((thisLine = myInput.readLine()) != null) {
          String strar[] = thisLine.split(",");
          String columncon = strar[columnnum];
          return columncon;
      }
  }
}