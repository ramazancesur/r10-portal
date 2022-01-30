package tr.com.r10.portal.controller.interfaces;

import org.springframework.web.bind.annotation.*;
import tr.com.r10.portal.dto.PageablePortal;
import tr.com.r10.portal.dto.Topic;

import java.util.List;

@RequestMapping("/topic")
public interface TopicController {
    @GetMapping("/all")
    List<Topic> getAllTopic();

    @PostMapping("/pageWithData")
    List<Topic> getAllTopicPagination(@RequestBody PageablePortal pageablePortal);

    @PostMapping("/save")
    Topic saveTopic(@RequestBody Topic pageablePortal);

    @PostMapping("/update")
    Topic updateTopic(@RequestBody Topic topic);

    @DeleteMapping("/delete")
    Topic deleteTopic(@RequestParam(value = "id") Long id);
}