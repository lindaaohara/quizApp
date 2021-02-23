package ohara.linda.quizApp.service;

import ohara.linda.quizApp.model.Question;

import java.util.List;

public interface QuestionService {
    Question createQuestion(Question question);
    Question updateQuestion(Question question);
    Question getQuestionById(long questionId);
    List<Question> getAllQuestions();
//    List<Question> getQuestionsByTopic();
    void deleteQuestion(long qestionId);
}
