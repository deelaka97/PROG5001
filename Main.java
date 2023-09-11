
/**
 *
 * @Stu_ID 2416 8157
 * @version 9/11/2023
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String assignmentName;
        List<Integer> studentsMarks = new ArrayList<>();

        System.out.print("Enter the assignment name: ");
        assignmentName = scanner.nextLine();
        inputStudentMarks(0, studentsMarks, scanner);

        System.out.println("Assignment Name: " + assignmentName);
        System.out.println("Students' Marks: " + studentsMarks);

        int highestMark = Collections.max(studentsMarks);
        int lowestMark = Collections.min(studentsMarks);
        System.out.println("Highest Mark: " + highestMark);
        System.out.println("Lowest Mark: " + lowestMark);

        double mean = calculateMean(studentsMarks);
        double standardDeviation = calculateStandardDeviation(studentsMarks);
        System.out.println("Mean: " + mean);
        System.out.println("Standard Deviation: " + standardDeviation);
    }

    public static void inputStudentMarks(int index, List<Integer> studentsMarks, Scanner scanner) {
        if (index >= 30) {
            scanner.close();
            return;
        }

        System.out.print("Enter the mark for student " + (index + 1) + ": ");
        int mark = scanner.nextInt();
        if (isValidMark(mark)) {
            studentsMarks.add(mark);
            inputStudentMarks(index + 1, studentsMarks, scanner);
        } else {
            System.out.println("Invalid input. Please enter a mark between 0 and 30.");
            inputStudentMarks(index, studentsMarks, scanner);
        }
    }

    public static boolean isValidMark(int mark) {
        return mark >= 0 && mark <= 30;
    }

    public static double calculateMean(List<Integer> studentsMarks) {
        int sum = 0;
        for (int mark : studentsMarks) {
            sum += mark;
        }
        return (double) sum / studentsMarks.size();
    }

    public static double calculateStandardDeviation(List<Integer> studentsMarks) {
        double mean = calculateMean(studentsMarks);
        double sumOfSquaredDifferences = 0;
        for (int mark : studentsMarks) {
            sumOfSquaredDifferences += Math.pow(mark - mean, 2);
        }
        return Math.sqrt(sumOfSquaredDifferences / studentsMarks.size());
    }
}

