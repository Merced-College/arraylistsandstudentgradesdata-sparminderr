 /*
Names: Harrison Tinley, Jessie Mendez Cruz, Parminder Singh
Date: 2/19/2026
Program: Course Grades Analyzer - will read csv of grade count in classes and find the percentage of students with A's
*/

import java.util.ArrayList;

public class Course {
    private String courseName;
    private ArrayList<Integer> courseGrades;



    public Course(String name, ArrayList<Integer> grades) {
        this.courseName = name;
        this.courseGrades = grades;
    }


    //default contructor when Course object is made
    public Course() {
        this.courseName = "Unknown";
        this.courseGrades = courseGrades;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String name) {
        this.courseName = name;
    }


    public ArrayList<Integer> getCourseGrades() {
        return courseGrades;
    }

    public void setCourseGrades(ArrayList<Integer> newGrades) {
        this.courseGrades = newGrades;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + "'," +
                "courseGrades=" + courseGrades + "}";
    }


    //sumOf{A+B+C+D+F} 
    public int getTotalGrades() {
        int total = 0;
        for (int value : courseGrades) {
            total += value;
        }
        return total;
    }

    public double getAPercent() {
        int total = getTotalGrades();
        if (total == 0) 
        return 0.0;
        return (double) courseGrades.get(0) / total * 100.0;
    }

}