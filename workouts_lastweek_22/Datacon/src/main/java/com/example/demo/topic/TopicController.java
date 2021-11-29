package com.example.demo.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	@Autowired
	private TopicService topicservice;
	@RequestMapping("/topics")
public List<Topics> getAllTopics()

{
	return topicservice.getAll();
			/*Arrays.asList(new Topics("spring","java","c"),
			new Topics("spring boot","jdbc","c++")
			);*/
}
	@RequestMapping("/topics/{id}")
	public  Topics getTopic(@PathVariable("foo") String id)
	{
		return topicservice.getTopic(id);
	}
	@RequestMapping(method=RequestMethod.POST,value="/topic")
	public void addTopics(@RequestBody Topics topic)
	{
		topicservice.addTopic(topic);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/topic")
	public void updateTopic(@RequestBody Topics topic,@PathVariable String id)
	{
		topicservice.updateTopic(topic,id);
	}

	@RequestMapping(method=RequestMethod.DELETE,value="/topic")
	public void deleteTopic(@RequestBody Topics topic,@PathVariable String id)
	{
		 topicservice.deleteTopic(id);
	}
}
