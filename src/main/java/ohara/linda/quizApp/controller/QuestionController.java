package ohara.linda.quizApp.controller;

import ohara.linda.quizApp.model.Question;
import ohara.linda.quizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/questions")
    public ResponseEntity<List<Question>>getAllQuestions(){
        return ResponseEntity.ok().body(questionService.getAllQuestions());
    }
/*
    @GetMapping("/questions")
    public ResponseEntity<List<Question>>getQuestionsByTopic(){
        return ResponseEntity.ok().body(questionService.getQuestionsByTopic());
    }
*/
    @GetMapping("/questions/{id")
    public ResponseEntity<Question> getQuestionId(@PathVariable long id){
        return ResponseEntity.ok().body(questionService.getQuestionById(id));
    }

    @PostMapping("/questions")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question){
        return ResponseEntity.ok().body(this.questionService.createQuestion(question));
    }

    @PutMapping("/questions/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable long id, @RequestBody Question question){
        question.setId(id);
        return ResponseEntity.ok().body(this.questionService.updateQuestion(question));
    }
    @DeleteMapping("/question/{id}")
    public HttpStatus deleteQuestion(@PathVariable long id){
        this.questionService.deleteQuestion(id);
        return HttpStatus.OK;
    }
}
