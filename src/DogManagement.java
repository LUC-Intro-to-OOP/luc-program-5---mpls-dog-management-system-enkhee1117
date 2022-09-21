/*--------------------------------------------
Program 5: MPLS Dog Management System
**Programs 5 and 6 will be similar in functionality.**
The MPLS Dog Boarding company would like for you to create an application that allows for a care attendant to be able 
to create, retrieve and update dog records from the system. MPLS Dog Boarding can only have 12 dogs in their care at a time. When you select the option to **create** a dog record.  You will 
enter the dog's id, dog's name, weight and dog's age  Once information is entered for a dog, the program will display
entered information and reprompt the care attendent to select an option to exit, display, create or update dog records.  When the **update** option
is selected the care attendant will be presented with option to enter the dog's id number and reassign information
pertaining to dog.  When the **retrieve** option is selected, the user will be able to enter the dog's id and be presented
with dog information.

**Hints**
- Consider the use of parallel arrays to store dog Data.  **Declare your arrays at the class level and not in the main method.**
- Consider commenting your code and writing the code in the main method before modularizing the program.
 
#### Listed below is a detailed explanation of the requirements needed to complete the dog management system.  

## Requirement 1 (5 Points) 
Variables are properly declared and initialized; Use of Scanner Object to read input from console. Make use of constant final variables. 
Whenever possible, make sure to declare all variables that will hold data along with declaring final variables that will not change during runtime.
Proper structure used for allowing the end-user to continously select menu option until a sentinel value is entered.

## Requirement 2 (5 Points) 
Input/Output of all necessary information for each item entry; Program properly makes use of arrays/multi-dimensional arrays to structure data;
Program only accepts dog id numbers that have been entered.

## Requirement 3 (5 Points) 
The program should consist of a minimum of 5 methods.  
    1) A welcome method that describes the program.  
    2) A method to display the selection prompt
    3) A method that allows the care attendant to enter a record.  
    4) A method that allows the care attendant to update a record and 
    5) A method that allows the care attendant to retrieve an existent record.

## Requirement 4 (5 Points) 
Style - Proper use of comments, spacing, in program; use of descriptive variable names

## Requirement 5 (5 Points) 
Program is submitted by the due date listed and pushed to assigned GitHub Repository; Repository contains a minimum of three commits.

	
    [REPLACE MY INFORMATION WITH YOURS]
    Course: COMP 170, Fall 1 2022
    System: Visual Studio Code, Windows 10
    Author: C. Fulton
*/

import java.util.Arrays;
import java.util.Scanner; //Importing Scanner Class
public class DogManagement {
    /*
     * Global Declaration for parallel arrays and Scanner Object
     */
    //DECLARING PARALEL ARRAYS OUTSIDE OF MAIN METHOD TO HOLD DOG DATA use the static keyword
    public static int[] dogsAge = new int[12];
    public static String[] dogsName = new String[12];
    public static int[] dogsID = new int[12];
    public static double[] dogsWeight = new double[12];
    public static int dogCount = 0;

    //DECLARING SCANNER OBJECT
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        welcome();
        int menuOption = displayPrompt();
        
        while(menuOption != 4){
            switch (menuOption) {
                case 1:
                // Create new Dog: 
                    createDog();
                    menuOption = displayPrompt();
                    break;
                case 2:
                // Display Dog record:
                    displayDog();
                    menuOption = displayPrompt();
                    break;
                case 3:
                // Update Dog report:
                    updateDog();
                    menuOption = displayPrompt();
                    break;
                default:
                    System.out.println("Invalid menu option \n");
                    menuOption = displayPrompt();
            } //END OF SWITCH
        } // END of WHILE
        System.out.println("Program has ended!");
    }
    public static void createDog(){
        int id;
        String name;
        double weight;
        int age;

        System.out.println("You have selected to enter a new dog.");
        System.out.print("Enter dog ID #: "); id = Integer.parseInt(scn.nextLine());
        System.out.print("Enter dog Name: "); name = scn.nextLine();
        System.out.print("Enter dog weight: "); weight = Double.parseDouble(scn.nextLine());
        System.out.print("Enter dog age: "); age = Integer.parseInt(scn.nextLine());

        // Validation

        // Creation:
        if (dogCount >= 12) return;
        dogsAge[dogCount] = age;
        dogsID[dogCount] = id;
        dogsWeight[dogCount] = weight;
        dogsName[dogCount] = name;
        System.out.println("The following information has been entered:");
        System.out.println("\t ID #: " + dogsID[dogCount]);
        System.out.println("\t Name #: " + dogsName[dogCount]);
        System.out.println("\t Weight #: " + dogsWeight[dogCount]);
        System.out.println("\t Age #: " + dogsAge[dogCount]);
        dogCount++;
    }
    public static void displayDog(){
        // Display a list of dogs from the database
        for (int i = 0 ; i < dogCount ; i++ ){
            System.out.println("ID #: " + dogsID[i] + " for " + dogsName[i]);
        }
        System.out.print("Please enter ID # to from above to display record:"); 
        // Get user input on ID to display
        int displayId = Integer.parseInt(scn.nextLine());
        int matchingIndex = -1;
        for (int i = 0 ; i < dogCount ; i++){
            if (dogsID[i] == displayId) matchingIndex = i;
        }
        if (matchingIndex == -1) {
            System.out.println("Id # does not match dog id in system");
            return;
        } else {
            System.out.println("\t ID #: " + dogsID[matchingIndex]);
            System.out.println("\t Name #: " + dogsName[matchingIndex]);
            System.out.println("\t Weight #: " + dogsWeight[matchingIndex]);
            System.out.println("\t Age #: " + dogsAge[matchingIndex]);
        }
    }
    public static void updateDog() {
        // Display a list of dogs from the database
        for (int i = 0 ; i < dogCount ; i++ ){
            System.out.println("ID #: " + dogsID[i] + " for " + dogsName[i]);
        }
        System.out.println("Please enter the dog ID # to update record"); 
        int updateDogID = Integer.parseInt(scn.nextLine());
        int matchingIndex = -1;

        // Finding matching index
        for (int i = 0 ; i < dogCount ; i++){
            if (dogsID[i] == updateDogID) matchingIndex = i;
        }
        // If matching index is not found
        if (matchingIndex == -1) {
            System.out.println("Id # does not match dog id in system");
            return;
        } else {
            // Get update info and update a dog. 
            System.out.println("You have selected to update " + dogsName[matchingIndex]);
            System.out.print("Enter dog ID #: "); int id = Integer.parseInt(scn.nextLine());
            dogsID[matchingIndex] = id;
            System.out.print("Enter dog Name: "); String name = scn.nextLine();
            dogsName[matchingIndex] = name;
            System.out.print("Enter dog weight: "); Double weight = Double.parseDouble(scn.nextLine());
            dogsWeight[matchingIndex] = weight;
            System.out.print("Enter dog age: "); int age = Integer.parseInt(scn.nextLine());
            dogsAge[matchingIndex] = age;
            
            // Updated information
            System.out.println("\n The following information has been updated:");
            System.out.println("\t ID #: " + dogsID[matchingIndex]);
            System.out.println("\t Name #: " + dogsName[matchingIndex]);
            System.out.println("\t Weight #: " + dogsWeight[matchingIndex]);
            System.out.println("\t Age #: " + dogsAge[matchingIndex]);
        }
    }

    //Welcome method that outputs introductory text explaining program
    public static void welcome(){
        System.out.println("Welcome, this program allows for a care attendant to be able to create, retrieve and update a dog record from the system.");
    }

    //Method to display prompt and return integer values
    public static int displayPrompt(){
        //Local Variables
        int menuOption;

        System.out.println("\nSelect a menu option:");
        System.out.println("\t1) Create a dog record");
        System.out.println("\t2) Display dog record");
        System.out.println("\t3) Update dog record");
        System.out.println("\t4) Exit Program");
        
        System.out.print("Enter selection here --> ");
        //INPUT
        menuOption = Integer.parseInt(scn.nextLine());

        return menuOption;
    }
}
