package ohara.linda.quizApp.service;

import ohara.linda.quizApp.controller.ResourceNotFoundException;
import ohara.linda.quizApp.model.Question;
import ohara.linda.quizApp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        Optional<Question> questionDb = this.questionRepository.findById(question.getId());

        if (questionDb.isPresent()) {
            Question questionUpdate = questionDb.get();
            questionUpdate.setId(question.getId());
            questionUpdate.setPrompt(question.getPrompt());
            questionUpdate.setAnswer(question.getAnswer());
            questionUpdate.setTopic(question.getTopic());
            questionRepository.save(questionUpdate);
            return questionUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + question.getId());
        }
    }

    @Override
    public Question getQuestionById(long questionId){
        Optional<Question> questionDb = this.questionRepository.findById(questionId);
        if(questionDb.isPresent()){
            return questionDb.get();
        }else{
            throw new ResourceNotFoundException("Record not found with id: " + questionId);
        }
    }

    @Override
    public List<Question> getAllQuestions() {
        return this.questionRepository.findAll();
    }
/*
    @Override
    public List<Question> getQuestionsByTopic() {
        Optional<Question> questionDb=this.questionRepository.findAll(topic);
        if(questionDb.isPresent()){
            return questionDb.get();
        }else{
        throw new ResourceNotFoundException("Record not found with topic: "+ topic);
    }
*/
    @Override
    public void deleteQuestion(long questionId) {
        Optional<Question> questionDb = this.questionRepository.findById(questionId);
        if (questionDb.isPresent()) {
            this.questionRepository.delete(questionDb.get());

        } else {
            throw new ResourceNotFoundException("Record not found with id: " + questionId);
        }
    }
}

