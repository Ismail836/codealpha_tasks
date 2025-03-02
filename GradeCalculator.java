import java.util.ArrayList;
import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> grades = new ArrayList<>();
                // Input grades
                System.out.println("Enter students' grades (enter -1 to finish):");
                while (true) {
                    System.out.print("Enter grade for student " + (grades.size() + 1) + ": ");
                    double grade = scanner.nextDouble();
        
                    if (grade == -1) {
                        break; // Exit the loop if the teacher enters -1
                    }
        
                    if (grade < 0 || grade > 100) {
                        System.out.println("Invalid grade! Please enter a grade between 0 and 100.");
                        continue;
                    }
        
                    grades.add(grade); // Add the valid grade to the list
                }
        
        //Compute statistics
        if (grades.isEmpty()) {
            System.out.println("No grades entered. Exiting program.");
            return;
        }

        double sum = 0;
        double highest = grades.get(0);
        double lowest = grades.get(0);

        for (double grade : grades) {
            sum += grade; // Calculate the sum of grades
            if (grade > highest) {
                highest = grade; // Update the highest grade
            }
            if (grade < lowest) {
                lowest = grade; // Update the lowest grade
            }
        }

        double average = sum / grades.size(); // Calculate the average
    }}