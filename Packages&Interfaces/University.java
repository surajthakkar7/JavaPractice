import java.util.Scanner;
import edu.*;

public class University {

    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        School school = null;

        while (true) {

            System.out.println("Please enter a command: ");
            System.out.println("Type 'help'to see available commands.");

            String command = sc.nextLine();

            if (command.equals("create school")) {
                System.out.println("in the create school branch...");

                System.out.println("Enter the name of your school: ");
                String name = sc.nextLine();

                school = new School(name);

                System.out.println(school + " has been created!");
            }

            if (command.equals("exit")) {
                System.out.println("The app has exited...");

                break; // exit loop
            }

            if (command.equals("help")) {
                System.out.println("in the help branch...");
                System.out.println("Below is a description of the possible commands:");
                System.out.println("create school - create a new school");
                System.out.println("create course - create a new course for the school");
                System.out.println("assign student - add a new student to a course");
                System.out.println("assign teacher - assign a new teacher to a course");
                System.out.println("create quiz - add a quiz to a course");
                System.out.println("grade  student- grade a student on a quiz");
                System.out.println("get grade -  get the grade for a student quiz");
                System.out.println("exit  - close the application");
                System.out.println("help - get helpful information about commands");
            }

            if (command.equals("create course")) {
                System.out.println("in the create course branch...");

                System.out.println("Enter the name of the course: ");
                String name = sc.nextLine();

                System.out.println("Enter the course id number: ");
                int id = sc.nextInt();

                Course course = new Course(name, id);
                school.addCourse(course, 0);

                System.out.println("The  course has been added.");
            }

            if (command.equals("assign teacher")) {
                System.out.println("in the assign teacher branch...");

                System.out.print("Please enter the teacher first and last name separated by a space: ");
                String name = sc.nextLine();

                System.out.println("Enter the teacher's staff id number: ");
                int id = sc.nextInt();

                System.out.println("Enter the teacher's course id number: ");
                int courseId = sc.nextInt();

                Teacher teacher = new Teacher(name, id);

                Course course = school.getCourses()[courseId];
                course.addTeacher(teacher);

                System.out.println("The teacher has been assigned to this course.");

            }

            if (command.equals("assign student")) {
                System.out.println("in the assign student branch...");

                System.out.print("Please enter the student first and last name separated by a space: ");
                String name = sc.nextLine();

                System.out.println("Enter the student's id number: ");
                int id = sc.nextInt();

                System.out.println("Enter the students's course id number: ");
                int courseId = sc.nextInt();

                Student student = new Student(name, id);

                Course course = school.getCourses()[courseId];
                course.addStudent(student, id);

                System.out.println("The student has been assigned to this course.");

            }

            if (command.equals("create quiz")) {
                System.out.println("in the create quiz branch...");

                System.out.print("Please enter the title for the quiz: ");
                String name = sc.nextLine();

                System.out.println("Enter the quiz's id number: ");
                int id = sc.nextInt();

                System.out.println("Enter the course id number: ");
                int courseId = sc.nextInt();

                Quiz quiz = new Quiz(name, id);

                Course course = school.getCourses()[courseId];
                course.addQuiz(quiz, id);

                System.out.println("The quiz has been assigned to this course.");

            }

            if (command.equals("grade student")) {
                System.out.println("in the grade student branch...");

                System.out.print("Please enter the id of the course: ");
                int courseId = sc.nextInt();

                System.out.print("Please enter the id of the student: ");
                int studentId = sc.nextInt();

                System.out.println("Enter the quiz's id number: ");
                int quizId = sc.nextInt();

                System.out.println("Enter the Grade: ");
                int gradeScore = sc.nextInt();

                Course course = school.getCourses()[courseId];
                Student student = course.getStudents()[studentId];
                Quiz quiz = course.getQuizzes()[quizId];

                // Add the score to the student and then add it to the list in the course
                // If there is an issue with adding the score, print out a message saying so
                try {
                    course.gradeStudent(student, quiz, new Grade(gradeScore));
                    System.out.println("Grade added successfully!");
                } catch (Exception e) {
                    System.out.println("There was an error grading the student.");
                }

                System.out.println("The quiz has been graded for the student!");

            }

            if (command.equals("get grade ")) {
                System.out.println("in the get grade branch...");

                System.out.print("Please enter the id of the course: ");
                int courseId = sc.nextInt();

                System.out.print("Please enter the id of the student: ");
                int studentId = sc.nextInt();

                System.out.println("Enter the quiz's id number: ");
                int quizId = sc.nextInt();

                Course course = school.getCourses()[courseId];
                Student student = course.getStudents()[studentId];
                Quiz quiz = course.getQuizzes()[quizId];

                System.out.println("Grade: " + course.getGrade(student,quiz).getScore());

            }

        }

    }
}