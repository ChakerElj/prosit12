package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(1,"chaker",22);
        StudentManagement sm = new StudentManagement();
        Student s2 = new Student(2,"Ali",23);
        System.out.println("Display all students");
        sm.displayStudents(List.of(s1,s2), System.out::println );
        System.out.println("Display students by filter filter(id==1)");
        sm.displayStudentsByFilter(List.of(s1,s2),student -> student.getId()==1 , System.out::println);
        String names = sm.returnStudentsNames(List.of(s1,s2), Student::getNom) ;
        System.out.println("names of students : " + names);
        sm.createStudent(() -> new Student(3,"Mootez",26));
        System.out.println(sm.sortStudentsById(List.of(s1,s2), Comparator.comparingInt(Student::getId)));
        Stream<Student> streamStudents = sm.convertToStream(List.of(s1,s2));
        System.out.println(streamStudents.map(Student::getNom).toList());

    }
}