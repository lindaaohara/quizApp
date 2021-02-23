package ohara.linda.quizApp.repository;

import ohara.linda.quizApp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
