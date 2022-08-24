package oop;

import java.util.Scanner; // import Scanner class

// class GradeBook
class GradeBook{
    private String courseName; // instance variable
    private int[] grade; // array of student grades
    
    // constructor and methods
    // Constructor
    public GradeBook(String cName, int[] stuGrade){
        courseName = cName; // assign cName to courseName
        grade = stuGrade; // assign stuGrade to grade
    }// end of Constructor GradeBook
    
    public void setCourse(String course){
        courseName = course;
    } // end of setCourse
    
    public String getCourse(){
        return courseName;
    }// end of getCourse
    
    public void showMessage(){
        System.out.printf("Welcome to Grade book for\n%s!\n\n", getCourse());
    } // end of showMessage
    
    public int getMinimum(){
        int lowGrade = grade[0];
        for(int list : grade){
            if(list < lowGrade){
                lowGrade = list;
            }
        }
        return lowGrade;
    } // end of getMinimum
    
    public int getMaximum(){
        int highGrade = grade[0];
        for(int list : grade){
            if(list > highGrade){
                highGrade = list;
            }
        }
        return highGrade;
    } // end of getMaximum
    
    public int getTotal(){
        int total =0;
        for(int list : grade){
            total+= list; // sums up grades
        }
        return total;
    } // end of getTotal
    
    public double getAverage(){
        // using enhanced for-loop
        // using method getTotal within getAverage
        return (double) (getTotal() / grade.length);
    } // end of getAverage
    
    public void process(){
        System.out.println("The Grades are : \n");
        for(int count = 0; count < grade.length; count++){
            System.out.printf("Student %d : %d\n", (count + 1), grade[count]);
        } // end of for-loop
        
        System.out.println("\n");
        
        // calling all other methods within class GradeBook
        // calling getTotal
        System.out.printf("Total Grades of Class = %d\n", getTotal());
        // calling getaverage
        getAverage();
        // calling getMinimum
        System.out.printf("Lowest Grade = %d\n", getMinimum());
        // calling getMaximum
        System.out.printf("Highest Grade = %d\n", getMaximum());
    }
    
} // end of class GradeBook


public class OOP_GradeBookTest{
    
    public static void main(String[] args){
        // create object of Scanner
        Scanner input = new Scanner(System.in);
        
        // user input
        // class size
        int size;
        System.out.print("Enter class size : ");
        size = input.nextInt();
        
        // declare array
        int[] Grades = new int[size];
        
        
        
        System.out.println("Enter Students Grades : \n");
        // filling array  Grades using for-loop
        for(int i = 0; i < size; i++){
            System.out.printf("Student %d : ", (i+1));
            Grades[i] = input.nextInt();
        } // end of for-loop
        
        // create object of class GradeBook
        GradeBook book = new GradeBook("INF 201: Introduction to Java", Grades);
        
        // calling method showMessage from class GradeBook
        book.showMessage();
        
        // calling process
        book.process();
        
        /*
        // calling getMinimum
        System.out.printf("The Minimum Grade = %d\n", book.getMinimum());
        
        // calling getMaximum
        System.out.printf("The Maximum Grade = %d\n", book.getMaximum());
        
        // display total marks
        System.out.printf("Total Marks = %d\n", book.getTotal());
        
        // display getAverage
        System.out.printf("Avearge Grade = %.2f\n", book.getAverage());
        */
    } // end of main method
    
} // end of class OOP_GradeBookTest