import javafx.geometry.Pos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/************************************************************************/
/* Class to Upload the txt file and pass it to perform respective tasks.*/
/*************************************************************************/
public class FileInsert{
    String StringNames = "";                    // Individual string names as string data type.
    String summedUp = "";                       // All the names joined up in one string.
    int numberOfNames = 0;                      // Total number of names in the file.

    /* Constructor for FileInsert class. Begins the program and
    /* prompts the user to enter the text file's address.   */

    public FileInsert(){
        System.out.println("Welcome to my program");
        fileUpload();
    }

    /* Method to upload the text file, break and make all the text as one integer. */
    /* Later on passes to sort them out.                                           */


    public void fileUpload(){
        Sorting start = new Sorting();
        Link list = new Link();


        Scanner input = null;
        try {

            input = new Scanner(new File(EnterFileName()));  // Uploads the txt file and prompts to EnterFileName method
            list.addAtTail(input.nextLine());
            while(input.hasNextLine()){                      // Reads the text file and attaches the string as one

                StringNames = input.nextLine();

                start.SortOut(StringNames, list);
            }


        }

        catch (FileNotFoundException e){                      // Throws file not found exception if invalid is entered.
            System.out.println("File Not Found");
            System.out.println("Re-enter the file Name");
            this.fileUpload();

        }
        finally {                                             // Closes up the file, so other application can access it.
            input.close();
            chooseOptions(list);
//            list.print();

        }
    }

    public void chooseOptions(Link list){
        System.out.println("Choose the appropriate option\n One (1) for all list \n Two (2) for choosing characters: ");
        Scanner scan = new Scanner(System.in);
        String choice = scan.next();

        if(choice.equalsIgnoreCase("One") || choice.equalsIgnoreCase("1")){
            list.print("All");
        } else if( choice.equalsIgnoreCase("two") || choice.equalsIgnoreCase("2")) {
            list.print("Specific");
        } else {
            System.out.println("Please select valid number");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            chooseOptions(list);
        }

    }


    /* Method to ask the user about the file Address and passes as an txt file address */

    public static String EnterFileName(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the address of the file. [Ex: C:\\workspace\\390 Assignment 4.1\\src\\Names.txt] ");
        String address = scan.nextLine();
        return address;
    }

}