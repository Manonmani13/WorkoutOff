package com.example.demo.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	@Autowired
	private TopicRepos tr;
	public List<Topics> getAll()
	{
		//return topic;
		List<Topics> topic=new ArrayList<>();
		tr.findAll().forEach(topic::add);
		return topic;
	}
	public Optional<Topics> getTopic(String id)
	{
		//return topic.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return tr.findById(id);
	}
	public void addTopic(Topics topic)
	{
		tr.save(topic);
	}

	public void updateTopic(Topics topic, String id) {
		tr.save(topic);
	}
	public void deleteTopic(String id) {
		//topic.removeIf(t->t.getId().equals(id));
		tr.deleteById(id);
	}
	

}
