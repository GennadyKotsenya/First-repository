package day9.Task1;

public class Task1 {
    public static void main(String[] args) {

        Student student = new Student("Коценя Г.Я.", "301B");
        Teacher teacher = new Teacher("Шпак Н.О.", "Астрономия");

        student.printInfo();
        teacher.printInfo();
    }
}

class Human {
    private String name;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    void printInfo() {
        System.out.println("Этот человек с именем " + name);
    }
}

class Student extends Human {
    private String groupName;

    public Student(String name, String groupName) {
        super(name);
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    @Override
    void printInfo() {
        super.printInfo();
        System.out.println("Этот студент с именем " + getName());
    }
}

class Teacher extends Human {
    private String subjectName;

    public Teacher(String name, String subjectName) {
        super(name);
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    @Override
    void printInfo() {
        super.printInfo();
        System.out.println("Этот преподаватель с именем " + getName());
    }
}