package uk.ac.cam.mp2226.part1a.oop.supo2.Q5P4OnlyCS;

import java.util.List;

public class Main {
    static List<Student> getStudents() {
        // This would, in reality be fetched from a database
        // or something similar.
        return List.of(
                new Student("Jim", 18),
                new Student("John", 20),
                new Student("Jeffery", 10),
                new Student("Jeremy", 20),
                new Student("Johnathan", 14)
                );
    }

    public static void main(String[] args) {
        List<Student> students = getStudents();
        for(Student s: students) {
            System.out.println(s.getName() + (s.pass() ? " passed" : " failed"));
        }
    }
}
