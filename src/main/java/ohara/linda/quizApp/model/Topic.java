package ohara.linda.quizApp.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "questions")
    private ArrayList<Question> topicQuestions;

    @Column(name = "reference")
    private String reference;

    @Column(name="codeSnippet")
    private String codeSnippet;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Question> getTopicQuestions() {
        return topicQuestions;
    }

    public void setTopicQuestions(ArrayList<Question> topicQuestions) {
        this.topicQuestions = topicQuestions;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getCodeSnippet() {
        return codeSnippet;
    }

    public void setCodeSnippet(String codeSnippet) {
        this.codeSnippet = codeSnippet;
    }
}
