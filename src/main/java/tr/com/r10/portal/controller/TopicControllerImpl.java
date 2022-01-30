package tr.com.r10.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tr.com.r10.portal.controller.interfaces.TopicController;
import tr.com.r10.portal.dto.PageablePortal;
import tr.com.r10.portal.dto.Topic;
import tr.com.r10.portal.exceptions.NotFoundException;
import tr.com.r10.portal.service.interfaces.TopicService;

import java.util.List;
import java.util.Objects;

@RestController
public class TopicControllerImpl implements TopicController {
    private TopicService topicService;

    @Override
    public List<Topic> getAllTopic() {
        return topicService.getAll();
    }

    @Override
    public List<Topic> getAllTopicPagination(PageablePortal pageablePortal) {
        return topicService.getAllDataWithPagination(pageablePortal);
    }

    @Override
    public Topic saveTopic(Topic topic) {
        return topicService.save(topic);
    }

    @Override
    public Topic updateTopic(Topic topic) {
        return topicService.save(topic);
    }

    @Override
    public Topic deleteTopic(Long id) {
        Topic topic = topicService.get(id);
        if(Objects.isNull(topic)){
            throw new NotFoundException("Topic not found for id is "+id);
        }
        topicService.deleteById(id);
        return topic;
    }

    @Autowired
    public void setTopicService(TopicService topicService) {
        this.topicService = topicService;
    }
}