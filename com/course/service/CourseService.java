package com.course.service;

import com.course.model.Course;
import com.course.model.Student;
import com.course.exception.*;

import java.io.*;
import java.util.*;

public class CourseService {

    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course c) {
        courses.add(c);
    }

    public void enrollStudent(int courseId, Student s)
            throws CourseFullException, CourseNotFoundException, DuplicateEnrollmentException {

        Course course = null;

        for (Course c : courses) {
            if (c.getCourseId() == courseId) {
                course = c;
                break;
            }
        }

        if (course == null) {
            throw new CourseNotFoundException("Course not found!");
        }

        for (Student st : course.getEnrolledStudents()) {
            if (st.getStudentId() == s.getStudentId()) {
                throw new DuplicateEnrollmentException("Student already enrolled!");
            }
        }

        if (course.getEnrolledStudents().size() >= course.getMaxSeats()) {
            throw new CourseFullException("Course is full!");
        }

        course.addStudent(s);

        saveEnrollment(course, s);
    }

    private void saveEnrollment(Course c, Student s) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("courses.txt", true));

            bw.write(c.getCourseId() + "," + c.getCourseName() + "," +
                    s.getStudentId() + "," + s.getStudentName());

            bw.newLine();
            bw.close();

        } catch (IOException e) {
            System.out.println("File writing error");
        }
    }

    public void viewCourses() {

        for (Course c : courses) {
            c.displayCourse();
            System.out.println("----------------");
        }

        System.out.println("\nEnrollment File Data:");

        try {
            BufferedReader br = new BufferedReader(new FileReader("courses.txt"));

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("File reading error");
        }
    }
}