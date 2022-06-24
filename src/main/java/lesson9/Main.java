package lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* 1. Написать функцию, принимающую список Student и возвращающую список уникальных курсов,
на которые подписаны студенты.
2. Написать функцию, принимающую на вход список Student и возвращающую список из трех
самых любознательных (любознательность определяется количеством курсов).
3. Написать функцию, принимающую на вход список Student и экземпляр Course,
возвращающую список студентов,которые посещают этот курс.*/

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Петя", Arrays.asList(new Course("Алгебра"), new Course("Русский язык"), new Course("Геометрия"))));
        students.add(new Student("Таня", Arrays.asList(new Course("Русский язык"),new Course("Геометрия"), new Course("Английский язык"))));
        students.add(new Student("Костя", Arrays.asList(new Course("Физика"))));
        students.add(new Student("Марина", Arrays.asList(new Course("Физика"), new Course("Геометрия"))));
        students.add(new Student("Вася", Arrays.asList(new Course("Физика"))));

        System.out.println("КУРСЫ: "+ students.stream()
                .map(a -> a.getCourses())
                .flatMap(b -> b.stream())
                .collect(Collectors.toSet()));
        System.out.println ();
        System.out.println ("Список любознательных студентов:");
        System.out.println(students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(2)
                .collect(Collectors.toList()));

        Course course = new Course("Физика");
        System.out.println ();
        System.out.println ("Список студентов,которые посещают курс по Физике: ");
        System.out.println(students.stream()
                .filter(s -> s.getCourses().contains(course))
                .collect(Collectors.toList()));
    }
}