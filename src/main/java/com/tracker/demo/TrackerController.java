package com.tracker.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jayway.jsonpath.ParseContext;

@CrossOrigin("*")
@RestController
public class TrackerController {
	
	@Autowired
	TrackerRepository trackerRepository;

	@GetMapping("/tracker")
	public List<Tracker> listtracker(){
		return trackerRepository.findAll();
	}
	@PostMapping("/tracker")
	public Tracker posttracker(@RequestBody Tracker tracker){
		Tracker temp_tracker= new Tracker();
		temp_tracker.setLatitude(tracker.getLatitude());
		temp_tracker.setLongitude(tracker.getLatitude());
		temp_tracker.setTimeStamp(tracker.getTimeStamp());
		temp_tracker.setLocation(tracker.getLocation());
		return trackerRepository.save(temp_tracker);
	}
	@DeleteMapping("/tracker/{id}")
	public void delete(@PathVariable("id") String id){
		 
		 trackerRepository.findAll().forEach((Tracker tracker)->{
			 if(tracker.getID()==Integer.parseInt(id)){
				 trackerRepository.delete(tracker);
			 }
		 });
	}
	
}
