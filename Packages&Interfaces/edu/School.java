package edu;

public class School {

    private String name;
    private Course[] courses = new Course[100];

    public School(String name) {
        this.name = name;
    }

    public void addCourse(Course course, int slot) {
        courses[slot] = course;
    }

    public Course[] getCourses() {
        return courses;
    }
}