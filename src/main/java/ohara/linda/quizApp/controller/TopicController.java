package ohara.linda.quizApp.controller;

import ohara.linda.quizApp.model.Topic;
import ohara.linda.quizApp.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/topics")
    public ResponseEntity<List<Topic>>getAllTopics(){
        return ResponseEntity.ok().body(topicService.getAllTopics());
    }
/*
    @GetMapping("/topics/{name}")
    public ResponseEntity<Topic> getTopicByName(@PathVariable String name){
        return ResponseEntity.ok().body(topicService.getTopicByName(name));
    }
*/
    @PostMapping(value = "/topics")
    public ResponseEntity<Topic> createTopic(@RequestBody Topic topic){
        return ResponseEntity.ok().body(this.topicService.createTopic(topic));
    }

    @PutMapping("/topics/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable long id, @RequestBody Topic topic){
        topic.setId(id);
        return ResponseEntity.ok().body((this.topicService.updateTopic(topic)));
    }

    @DeleteMapping("/topics/{id}")
    public HttpStatus deleteTopic(@PathVariable long id){
        this.topicService.deleteTopic(id);
        return HttpStatus.OK;
    }
}
