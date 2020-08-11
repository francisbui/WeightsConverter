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

public class Weights {

    private double importWeight;
    private double objectWeight;


    public Weights (double tempWeight) {
        this.objectWeight = tempWeight; // may change
        this.importWeight = tempWeight; // normalized
        System.out.println(this.objectWeight);
        toString();
        System.out.println(toOunces());
    }


    public String lessThan(Weights weightObject) {
        // accepts one weight as a parameter and returns whether the weight object on which it is invoked is
        // less than the weight supplied as a parameters
        Weights compare = weightObject;
        double value = compare.normalize();
        return "Object " + Math.min(this.objectWeight, value) + " weighs less than object " + Math.max(this.objectWeight, value);
    }

    public String addTo(Weights weightObject) {
        // accepts one weight as a parameter and adds the weight supplied as a parameter to the weight object
        // on which it is invoked. It should normalize the result.
        Weights compare = weightObject;
        double value = compare.normalize();
        return "The combined weight of the objects are: " + (this.objectWeight + value) * (16) + " in ounces";
    }

    public String divide(Weights weightObject) {
        // accepts an integer divisor as a parameter. It should divide the weight object on which the method
        // is invoked by the supplied divisor and normalize the result.
        Weights compare = weightObject;
        double value = compare.normalize();
        return "The object divided by the parameterized object is: " + this.objectWeight / value * (16) + " in ounces";
    }

    public String toString() {
        // method that returns a string that looks as follows: x lbs y oz, where x is the number of pounds
        // and y is the number of ounces.
        double pounds = this.importWeight;
        String numberD = String.valueOf(pounds);
        String numberC = String.valueOf(pounds);
        numberD = numberD.substring(numberD.indexOf("."));
        numberC = numberC.substring(0,numberC.indexOf("."));

        return "The object's weight in lbs and oz are: " + numberC + " lbs " + numberD + " oz";
    }

    private String toOunces() {
        // returns the total number of ounces in the weight object on which it was invoked
        double ounces = this.objectWeight;
        ounces = ounces * 16;

        return "The object's weight in ounces is: " + ounces + " oz";
    }

    private double normalize() {
        // normalizes the weight on which it was invoked.
        return this.importWeight;
    }
}
