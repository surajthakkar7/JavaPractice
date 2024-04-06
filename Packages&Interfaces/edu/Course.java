package edu;

public class Course {
    private String name;
    private int id;
    private Teacher teacher;
    private Student[] students = new Student[30];
    private Quiz[] quizzes = new Quiz[10];
    private Grade[][] grades = new Grade[students.length][quizzes.length];

    public Course(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void addTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void addStudent(Student student, int slot) {
        students[slot] = student;
    }

    public void addQuiz(Quiz quiz, int slot) {
        quizzes[slot] = quiz;
    }

    public Student[] getStudents() {
        return students;
    }

    public Quiz[] getQuizzes() {
        return quizzes;
    }

    public void gradeStudent(Student student, Quiz quiz, Grade grade) {
        grades[student.studentid][quiz.getId()] = grade;
    }

    public Grade getGrade(Student student, Quiz quiz) {
        return grades[student.studentid][quiz.getId()];
    }

}
