package ohara.linda.quizApp.repository;

import ohara.linda.quizApp.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
