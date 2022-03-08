package day6;

import java.util.Random;

public class Task3 {
    public static void main(String[] args) {

        Teacher teacher = new Teacher("Шпак Н.П.", "Физика");
        Student student = new Student("Коценя Г.Я.");

        teacher.evaluate(student);
    }
}


class Teacher {
    private String teacherName;
    private String subject;

    public Teacher(String teacherName, String subject) {
        this.teacherName = teacherName;
        this.subject = subject;
    }

    void evaluate(Student student) {

        Random random = new Random();
        String grade = "";
        int randomNumber = random.nextInt(4) + 2;

        switch (randomNumber) {
            case 2:
                grade = "неудовлетворительно";
                break;
            case 3:
                grade = "удовлетворительно";
                break;
            case 4:
                grade = "хорошо";
                break;
            case 5:
                grade = "отлично";
                break;
        }

        System.out.printf("Преподователь %s оценил студента с именем %s по " +
                        "предмету '%s' на оцеку '%s'.%n", this.teacherName,
                student.getStudentName(), this.subject, grade);
    }
}

class Student {
    private String studentName;

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }
}
