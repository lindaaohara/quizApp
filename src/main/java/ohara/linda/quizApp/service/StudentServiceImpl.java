package ohara.linda.quizApp.service;

import ohara.linda.quizApp.controller.ResourceNotFoundException;
import ohara.linda.quizApp.model.Student;
import ohara.linda.quizApp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        Optional<Student> studentDb = this.studentRepository.findById(student.getId());
        if(studentDb.isPresent()){
            Student studentUpdate = studentDb.get();
            studentUpdate.setId(student.getId());
            studentUpdate.setName(student.getName());
            studentUpdate.setQuestionId(student.getQuestionId());
            studentRepository.save(studentUpdate);
            return studentUpdate;
        }else{
            throw new ResourceNotFoundException("Record not found with id: " + student.getId());
        }
    }

    @Override
    public Student getStudentById(long studentId) {
        Optional<Student> studentDb = this.studentRepository.findById(studentId);
        if(studentDb.isPresent()){
            return studentDb.get();
        } else{
            throw new ResourceNotFoundException("Record not found with id: " +studentId);
        }

    }

    @Override
    public void deleteStudent(long studentId) {
        Optional<Student> studentDb= this.studentRepository.findById(studentId);
        if(studentDb.isPresent()){
            this.studentRepository.delete(studentDb.get());
        }else{
            throw new ResourceNotFoundException("Record not found with id: "+ studentId);
        }

    }
}
