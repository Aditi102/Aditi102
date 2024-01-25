package CodingSamurai;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private ArrayList<Integer> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    public double calculateAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }

        return (double) sum / grades.size();
    }
}
public class GradeTracker {
    private ArrayList<Student> students;

    public GradeTracker() {
        this.students = new ArrayList<>();
    }

    public void addStudent(String name) {
        Student student = new Student(name);
        students.add(student);
    }

    public void addGrade(String studentName, int grade) {
        for (Student student : students) {
            if (student.getName().equals(studentName)) {
                student.addGrade(grade);
                return;
            }
        }
        System.out.println("No student found: " + studentName);
    }

    public void displayResults() {
        System.out.println("*****Student Record:***** ");

        for (Student student : students) {
            System.out.print(student.getName() + ": ");
            ArrayList<Integer> grades = student.getGrades();
            if (grades.isEmpty()) {
                System.out.println("Records are not available");
            } else {
                System.out.print("Grades: ");
                for (int grade : grades) {
                    System.out.print(grade + " ");
                }
                System.out.println("Average: " + student.calculateAverage());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GradeTracker gradeTracker = new GradeTracker();
        Scanner scanner = new Scanner(System.in);

        gradeTracker.addStudent("Aditi");
        gradeTracker.addStudent("Karan");
        gradeTracker.addStudent("Puja");
        gradeTracker.addStudent("Sam");


        gradeTracker.addGrade("Aditi", 95);
        gradeTracker.addGrade("Karan", 75);
        gradeTracker.addGrade("Puja", 80);
        gradeTracker.addGrade("Sam", 90);


        gradeTracker.displayResults();
    }
}
