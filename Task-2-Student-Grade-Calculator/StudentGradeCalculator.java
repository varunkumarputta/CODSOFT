package com.practice.basicpgm;

import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int totalSubjects  = scanner.nextInt();
        int totalMarks = 0;
        for (int i = 0; i < totalSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " out of 100: ");
            int marks = scanner.nextInt();
            totalMarks += marks;
        }
        double averagePercentage = (double) totalMarks / totalSubjects;
        char grade = calculateGrade(averagePercentage);
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks + "/" + (totalSubjects * 100));
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }
    public static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
