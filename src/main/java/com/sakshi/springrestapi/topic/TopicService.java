package com.sakshi.springrestapi.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
		// Accessing the data via JPA
	
		@Autowired
		TopicRepository topicRepository;
		
		
		//	private List<Topic> topics = new ArrayList<>();
		
		public TopicService() {
			//	topics.add(new Topic("spring", "Spring Framework", "Spring Framework Description"));
			//	topics.add(new Topic("javascript", "Javascript", "Javascript Description"));
			//	topics.add(new Topic("java", "Java", "Java Description"));
		}
		
		public List<Topic> getAllTopics() {
			//	return topics;
			List<Topic> topics = new ArrayList<>();
			topicRepository.findAll().forEach(topics::add);
			return topics;
		}
		
		public Optional<Topic> getTopicById(String id) {
			//	return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
			return topicRepository.findById(id);
		}
		
		public void addTopic(Topic topic) {
			// topics.add(topic);
			topicRepository.save(topic);
		}
		
		public void updateTopic(String id, Topic topic) {
			//	for(int i=0; i<topics.size(); i++) {
			//		if(topics.get(i).getId().equals(id)) {
			//			topics.set(i, topic);
			//			return;
			//		}
			//	}
			topicRepository.save(topic);
		}
		
		public void deleteTopic(String id) {
			// topics.removeIf(t -> t.getId().equals(id));
			topicRepository.deleteById(id);
		}

}
