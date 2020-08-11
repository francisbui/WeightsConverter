/*
 * Francis Bui
 * CMIS 242
 * Dr. Schmeelk
 * Project 1 - Weight Computation
 * The purpose of this program is to read data from an input file using
 * the JFilechooser class. It will then convert the weight to an array
 * which will be then be manipulated in varies computation. Should the
 * data exceed 25 lines (total amount of weights), the program will
 * displayed error and the program itself will then terminate.
 */

import java.util.*;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class Project1 {


    // Methods begin
    private double findMinimum(double[] tempArray) {
        // accepts array of weights as a parameter with the the number of valid weights it contains
        // returns the SMALLEST weight in that array
        Arrays.sort(tempArray);
        double minValue = tempArray[0];
        System.out.println("The smallest weight in the file is " + minValue);
        return minValue;
    }
    private double findMaximum(double[] tempArray) {
        // accepts array of weights as a parameter with the the number of valid weights it contains
        // returns the LARGEST weight in that array
        Arrays.sort(tempArray);
        double maxValue = tempArray[tempArray.length -1];
        System.out.println("The largest weight in the file is " + maxValue);
        return maxValue;
    }
    private double findAverage(double[] tempArray) {
        // accepts array of weights as a parameter with the the number of valid weights it contains
        // returns the AVERAGE weight in that array
        double total = 0;
        for(int i=0; i<tempArray.length; i++){
            total = total + tempArray[i];
        }
        double average = total / tempArray.length;
        System.out.println("The average weight in the file is " + average);
        return average;
    }

    //Methods end

    public static void main(String[] args) {
        // Reads the file of weights and store them in an array of type Weights
        // Display the smallest, largest, and average weight by calling the remaining methods
        // Use JFileChooser class
        // File contains one weight per line
        // If the weight is greater than 25, an error message will display and the program will terminate


        // Project Class Object
        Project1 projectTest = new Project1();


        // Initialize JFileChooser import fields
        int list = 0; // Saves number of lines are in the array


        // JFileChooser Importing
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
            try {
                Scanner s1 = new Scanner(new File(String.valueOf(selectedFile)));
                while ((s1.hasNextLine())) {
                    list++;
                    s1.next();
                }
                double[] numbOfWeights = new double[list];
                Scanner s2 = new Scanner(new File(String.valueOf(selectedFile)));
                for (int i = 0; i < list; i++) {
                    numbOfWeights[i] = Double.parseDouble(s2.next());

                }
                if (list < 25) {
                    System.out.println();
                    System.out.println("###################### Weights Object Information ######################");
                    System.out.println();
                    Weights obj3 = new Weights(numbOfWeights[0]);
                    System.out.println(obj3);
                    System.out.println();
                    Weights obj4 = new Weights(numbOfWeights[1]);
                    System.out.println(obj4);
                    System.out.println();

                    System.out.println("###################### Weights Object Comparison ######################");
                    System.out.println();
                    System.out.println(obj3.lessThan(obj4));
                    System.out.println();
                    System.out.println(obj3.addTo(obj4));
                    System.out.println();
                    System.out.println(obj3.divide(obj4));
                    System.out.println();

                    System.out.println("###################### Project1 Class Information ######################");
                    System.out.println();
                    System.out.println("Import file information: ");
                    System.out.println(Arrays.toString(numbOfWeights));
                    System.out.println();
                    System.out.println("Class methods information: ");
                    projectTest.findMinimum(numbOfWeights);// array find min
                    projectTest.findMaximum(numbOfWeights);// array find max
                    projectTest.findAverage(numbOfWeights);// array find average
                }
                else {
                    System.out.println("Number of weights in file exceeds 25. Program will now terminate");
                }

            }

            catch (IOException ex) {
                ex.printStackTrace(); //Prints the stack trace for troubleshooting
            }

        }// End file read and array assignment



    }// End main



}
