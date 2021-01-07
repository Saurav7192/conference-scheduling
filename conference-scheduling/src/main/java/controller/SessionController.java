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

import com.fasterxml.jackson.databind.util.BeanUtil;

import model.Session;
import repository.SessionRepository;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {
	
	@Autowired
	private SessionRepository sessionRepo;
	
	@GetMapping
	public List<Session> getAllSession(){
		
		System.out.println("here================================================");
		return sessionRepo.findAll();
		
	}
	
	@GetMapping
	@RequestMapping("{id}")
	public Session findOne(@PathVariable Long id) {
		
		return sessionRepo.getOne(id);
	}
	
	@PostMapping
	public Session createSession(@RequestBody Session session) {
		return sessionRepo.saveAndFlush(session);
	}
	
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteOne(@PathVariable Long id) {
		
		sessionRepo.deleteById(id);
		
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Session updateSession(@PathVariable Long id, @RequestBody Session newSession) {
		
		Session session = sessionRepo.getOne(id);
		
		BeanUtils.copyProperties(newSession, session, "session_id");
		return sessionRepo.saveAndFlush(session);
	}

}
