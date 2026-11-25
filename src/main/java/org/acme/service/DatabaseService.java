package org.acme.service;

import org.acme.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DatabaseService {
    private Long nextId = 1L;
    private final Map<Long, Student> students = new HashMap<>();

    public void reset() {

    }

    public Student getStudent(long id) {
        return students.get(id);
    }

    public Collection<Student> getStudents() {
        return students.values();
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public void deleteStudent(long id) {
        students.remove(id);
    }

    public boolean containsStudent(long id) {
        return students.containsKey(id);
    }
}
