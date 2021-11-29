package com.example.demo.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	private List<Topics> topic=Arrays.asList(new Topics("spring","java","c"),
	new Topics("spring boot","jdbc","c++")
	);
	public List<Topics> getAll()
	{
		return topic; 
	}
	public Topics getTopic(String id)
	{
		return topic.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	public void addTopic(Topics topic)
	{
		topic.add(topic);
	}

	public void updateTopic(Topics topic2, String id) {
		// TODO Auto-generated method stub
		for(int i=0;i<topic.size();i++)
		{
			Topics t=topic.get(i);
			if(t.getId().equals(id))
			{
				topic.set(i,(Topics) topic);
				return;
			}
		}
	}
	public void deleteTopic(String id) {
		// TODO Auto-generated method stub
		topic.removeIf(t->t.getId().equals(id));
	}
	

}
