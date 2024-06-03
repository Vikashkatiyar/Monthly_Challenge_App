/**
 * 
 */
package com.boot.ChallengeApp;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vikash katiyar
 *
 */

@RestController
@RequestMapping("/challenges")
@CrossOrigin(origins = "http://localhost:3000/")
public class ChallengeController {
  
	private ChallengeService challengeService;
	
	
	public ChallengeController(ChallengeService challengeService) {
		this.challengeService=challengeService;
	}
	
	@GetMapping
	public ResponseEntity<List<Challenge>> getAllChallenges(){
		return new ResponseEntity<List<Challenge>>(challengeService.getAllChallenges(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge) {
		boolean isChallengeAccepted= challengeService.addChallenge(challenge);
		
		if(isChallengeAccepted)
		   return new ResponseEntity<String>("Challenge added successfully", HttpStatus.OK);
		else
			return new ResponseEntity<String>("Challenge Not Added Successfully", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{month}")
	public ResponseEntity<Challenge> getChallenge(@PathVariable String month){
		 Challenge challenge = challengeService.getChallenge(month);
		 if(challenge!=null) {
			 return new ResponseEntity<Challenge>(challenge, HttpStatus.OK);
		 }else {
			 return new ResponseEntity<Challenge>(HttpStatus.NOT_FOUND);
		 }
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateChallenge(@PathVariable Long id,@RequestBody Challenge updatedChallenge){
		boolean isChallengeUpdated = challengeService.updateChallenge(id, updatedChallenge);
		if(isChallengeUpdated)
			return new ResponseEntity<String>("Challenge Updated successfully", HttpStatus.OK);
		else
			return new ResponseEntity<String>("Challenge Not Updated Successfully", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
		 boolean isChallengeDeleted=challengeService.deleteChallenge(id);
		 if(isChallengeDeleted) {
			 return new ResponseEntity<String>("Challenge deleted successfully", HttpStatus.OK);
		 }else {
			 return new ResponseEntity<String>("Challenge Not deleted Successfully", HttpStatus.NOT_FOUND);
		 }
	}
	
	
	
	
}

     
