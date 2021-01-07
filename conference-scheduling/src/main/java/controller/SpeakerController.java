package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Speaker;
import repository.SpeakerRepository;

@RestController
@RequestMapping("/speakers")
public class SpeakerController {

	@Autowired
	SpeakerRepository speakerRepo;
	
	@GetMapping
	public List<Speaker> getAllSpeaker(){
		return speakerRepo.findAll();
	}
	
	@GetMapping
	@RequestMapping("{id}")
	public Speaker getOne(@PathVariable Long id) {
		return speakerRepo.getOne(id);
	}
	
	@PostMapping
	public Speaker createSpeaker(@RequestBody Speaker speaker) {
		return speakerRepo.saveAndFlush(speaker);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteSpeaker(@PathVariable Long id) {
		speakerRepo.deleteById(id);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Speaker updateSpeaker(@PathVariable Long id, @RequestBody Speaker newSpeaker) {
		
		Speaker speaker = speakerRepo.getOne(id);
		
		BeanUtils.copyProperties(newSpeaker, speaker, "speaker_id");
		
		return speakerRepo.saveAndFlush(speaker);
	}

}
