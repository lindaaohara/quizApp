package ohara.linda.quizApp.service;

import ohara.linda.quizApp.controller.ResourceNotFoundException;
import ohara.linda.quizApp.model.Topic;
import ohara.linda.quizApp.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public Topic createTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Override
    public Topic updateTopic(Topic topic) {
        Optional<Topic> topicDb = this.topicRepository.findById(topic.getId());
        if(topicDb.isPresent()){
            Topic topicUpdate = topicDb.get();
            topicUpdate.setId(topic.getId());
            topicUpdate.setName(topic.getName());
            topicUpdate.setTopicQuestions(topic.getTopicQuestions());
            topicUpdate.setCodeSnippet(topic.getCodeSnippet());
            topicUpdate.setReference(topic.getReference());
            topicRepository.save(topicUpdate);
            return topicUpdate;
        }else{
            throw new ResourceNotFoundException("Record not found with Id: "+ topic.getId());
        }
    }

    @Override
    public List<Topic> getAllTopics() {
        return this.topicRepository.findAll();
    }



    @Override
    public Topic getTopicById(long topicId) {
        Optional<Topic> topicDb= this.topicRepository.findById(topicId);
        if(topicDb.isPresent()){
            return topicDb.get();
        }else{
            throw new ResourceNotFoundException("Record not found with id: " + topicId);
        }
    }

    @Override
    public void deleteTopic(long topicId) {
        Optional<Topic> topicDb= this.topicRepository.findById(topicId);
        if(topicDb.isPresent()){
            this.topicRepository.delete(topicDb.get());
        }else{
            throw new ResourceNotFoundException("Record not found with id: "+ topicId);
        }

    }
}
