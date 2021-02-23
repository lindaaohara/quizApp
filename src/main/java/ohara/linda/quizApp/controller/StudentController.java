package ohara.linda.quizApp.controller;

import ohara.linda.quizApp.model.Student;
import ohara.linda.quizApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students/{id}")
    public ResponseEntity<Student>getStudentById(@PathVariable long id){
        return ResponseEntity.ok().body(studentService.getStudentById(id));
    }
    @PostMapping(value="/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return ResponseEntity.ok().body(this.studentService.createStudent(student));
    }


    @PutMapping(value="/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student student){
        student.setId(id);
        return ResponseEntity.ok().body(this.studentService.updateStudent(student));
    }
    @DeleteMapping("students/{id}")
    public HttpStatus deleteStudent(@PathVariable long id){
        this.studentService.deleteStudent(id);
        return HttpStatus.OK;
    }
}
