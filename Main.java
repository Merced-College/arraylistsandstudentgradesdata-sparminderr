/*
Names: Harrison Tinley, Jessie Mendez Cruz, Parminder Singh
Date: 2/19/2026
Program: Course Grades Analyzer - accesses course object and gets 
*/

import java.io.*;
import java.util.*;

public class Main {
    private String fileName = "courseAndGradesData.csv";

    ArrayList<Course> courses = new ArrayList<>();

    public void main() {
        readFromCSV(fileName);

        /*
        for (Course course : courses) {
            System.out.println(course.getCourseName() + " A%: " + course.getAPercent());
        }
        */
        printSummaryTable();

        System.out.printf("Highest A%% : %s %.2f \n", findHighestAPercent().getCourseName(), findHighestAPercent().getAPercent());

        Scanner scnr = new Scanner(System.in);
        System.out.print("enter course you want to search: ");
        String searchedCourse = scnr.nextLine();
        System.out.println(findCourseWithSearch(searchedCourse));
    }

    public void readFromCSV(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                //increment which line the reader is on, and if it's the first 2 lines skip them (header lines)
                lineNumber++;
                if (lineNumber <= 2) {
                    continue;
                }

                String[] parts = line.split(",");
                String courseName = parts[0];
                ArrayList<Integer> grades = new ArrayList<>();

                for (int i = 1; i < parts.length; i++) {
                    int count = Integer.parseInt(parts[i].trim());
                    grades.add(count); 
                }

                Course course = new Course(courseName, grades);
                courses.add(course);


            }
        }
        catch(IOException e) {
            System.err.println("Error opening the file " + e.getMessage());
            //System.exit(0);
        }

    }

    public void printSummaryTable() {
        System.out.printf("%-10s %6s %6s %6s %6s %6s %8s %6s \n",
            "Course", "A", "B", "C", "D", "F", "Total", "A%");
        for (Course c : courses) {
            System.out.printf(
                "%-10s %6d %6d %6d %6d %6d %8d %6.2f \n", 
                c.getCourseName(), c.getCourseGrades().get(0), c.getCourseGrades().get(1), c.getCourseGrades().get(2), c.getCourseGrades().get(3), c.getCourseGrades().get(4),
                c.getTotalGrades(), c.getAPercent()
            );
        }
    }

    public Course findHighestAPercent() {
        Course best = courses.get(0);
        for (Course c : courses) {
            if (c.getAPercent() > best.getAPercent()) {
                best = c;
            }
        }
        return best;
    }

    public String findCourseWithSearch(String searchedName) {
        for (Course c : courses) {
            if (c.getCourseName().equals(searchedName)) {
                return c.toString();
            }
        }
        return "Sorry that course was not found :( ";
    }
}