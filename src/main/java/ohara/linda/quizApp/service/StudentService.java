package ohara.linda.quizApp.service;

import ohara.linda.quizApp.model.Student;

public interface StudentService {
    Student createStudent(Student student);
    Student updateStudent(Student student);
    Student getStudentById(long studentId);
    void deleteStudent(long id);
}
