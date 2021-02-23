package ohara.linda.quizApp.service;

import ohara.linda.quizApp.model.Topic;

import java.util.List;

public interface TopicService {
    Topic createTopic(Topic topic);
    Topic updateTopic(Topic topic);
    List<Topic> getAllTopics();
    Topic getTopicById(long topicId);
    void deleteTopic(long id);
}
