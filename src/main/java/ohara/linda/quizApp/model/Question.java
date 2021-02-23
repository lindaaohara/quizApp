package ohara.linda.quizApp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
    @Table(name="questions")
    public class Question {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @ManyToMany
        @JoinTable(name = "student_question", joinColumns=@JoinColumn(name = "question_id"),
            inverseJoinColumns= @JoinColumn(name="student_id"))
        private Set<Student> students;

        @Column(name = "prompt")
        private String prompt;

        @Column(name = "answer")
        private String answer;

        @Column(name = "topic")
        private String topic;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
