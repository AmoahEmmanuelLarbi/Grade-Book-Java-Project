package oop;

import java.util.Scanner; // import Scanner class

// define class GradeBook2
class GradeBook2 {

    // instance variables
    private final String courseName; // keep course name
    private final int[][] grades; // 2D array to keep grades of students

    // Constructor
    GradeBook2(String name, int[][] marks) {
        courseName = name;
        grades = marks;
    }

    public String getCourseName() {
        return courseName;
    } //  end of method getCourseName

    // public method displayMessage
    public void displayMessage() {
        System.out.printf("Welcome to Grade book for \n%s!\n\n", getCourseName());
    } // end of method displayMessage

    // method to display grades
    public void outputGrade() {
        System.out.printf("%-15s", "Candidate #");
        // create a column heading for each of the tests
        for (int row = 0; row < grades[0].length; row++) {
            System.out.printf("Test %-4d", (row + 1));
        } // end of for loop
        System.out.println("Average"); // student average column heading

        // create rows/columns of text representing array grades
        for (int student = 0; student < grades.length; student++) {
            System.out.printf("%-8s%3d", "Student ", (student + 1));
            for (int mark : grades[student]) {
                // display marks for each test
                System.out.printf("%8d", mark);
            } // end of inner loop
            System.out.printf(" %10.2f", Average(grades[student])); // display avearge of each student
            System.out.println();
        } // end of outer for loop
    } // end of method outputGrade

    public double Average(int[] score){
        int total = 0;
        
        for(int i : score){
            total+= i;
        }
        return (double)total/score.length;
    } // end of method Average
    
    public int getMin(){
        int min = grades[0][0];
       for(int[] list_arr : grades){
           for(int list : list_arr){
               if(list < min){
                   min = list;
               }
           }
       } 
       return min;
    } // end of getMin
    
    public int getMax(){
        int max = grades[0][0];
        for(int[] list_arr : grades){
            for(int list : list_arr){
                if(list > max){
                    max = list;
                }
            }
        }
        return max;
    } // end of getMax
    
    public void outputGraph(){
        int[] frequency = new int[11];
        for(int[] list_arr : grades){
            for(int list : list_arr){
                ++frequency[list/10]; // filling array frequency
            } // end of inner loop
        } // end of outer loop
        
        for(int i = 0; i < frequency.length; i++){
            if(i == 10){
                System.out.printf("%5d: ", (i*10));
            }else{
                System.out.printf("%02d-%02d: ", (i*10), (i*10+9));
            } // end of if-else statement
            
            for(int j = 0; j < frequency[i]; j++){
                System.out.print("*");
            } // en of inner for loop
            System.out.println();
        } // end of for loop
        
        
    } // end of outputGraph
    
    
    
}// end of class GradeBook2





public class GradeBookTest2 {

    public static void main(String[] args) {
        // create object of Scanner
        Scanner input = new Scanner(System.in);
        
        String program;
        int size;
        int tests;
        
        System.out.print("Enter name of Program : ");
        program = input.nextLine();
        
        System.out.print("Enter Class Size : ");
        size = input.nextInt();
        
        System.out.print("Enter # of test written : ");
        tests = input.nextInt();
        
        int[][] exams = new int[size][tests];
        
        // filling array exams
        for(int row = 0; row < size; row++){
            System.out.printf("Student %d\n", (row+1));
            for(int col =0; col < tests; col++){
                System.out.printf("Test %d :", (col+1));
                exams[row][col] = input.nextInt();
            }
        }
        
        
        // create object of class GradeBook2
        GradeBook2 grade = new GradeBook2(program, exams);

        grade.displayMessage();
        grade.outputGrade();

        System.out.println();
        System.out.println("Lowest Grade = " + grade.getMin());
        System.out.println("Highest Grade = " + grade.getMax());
        
        System.out.println();
        
        System.out.println("***** OVERALL GRADE DISTRIBUTION *****\n");
        grade.outputGraph();
    } // end of main method

} // end of class GradeBookTest2
