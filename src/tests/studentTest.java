package tests;

import instances.Student;

public class studentTest {
    public static void main(String[] args) {
        Student s1 = new Student("Akzhol", "Abil", 24, 15);
        Student s2 = new Student("Symbat", "Dulatuly", 23, 16);
        Student s3 = new Student("Akzhol", "Abil", 24, 15);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s2.equals(s3));
    }
}
