package com.revature.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/character")
public class CharacterController {
	@PostMapping(value="/create")
	public String create(
			@RequestParam(name="name", required=true, defaultValue="") String charname,
			Model model) {

		return "create";
	}

	@GetMapping(value="/login")
	public String login(
			@RequestParam(name="name", required=true, defaultValue="") String charname,
			Model model) {

		return "login";
	}

	@GetMapping(value="/{id}", produces="application/json")
	public @ResponseBody Object getCharacter( //Change to return User once implemented
			@PathVariable("id") int player_id,
			@RequestParam(name="id", required=true) int char_id) {
		
		return null;
	}
	
	@PutMapping(value="/{id}/update")
	public String updateUser(
			@PathVariable("id") int player_id,
			@RequestParam(name="id", required=true) int char_id,
			@RequestParam(name="weaponID", required=false) int weapon_iD,
			@RequestParam(name="armorID", required=false) int armor_iD,
			@RequestParam(name="name", required=false) String name
			) {

		return "update";
	}
	
	@DeleteMapping(value="/{id}/delete")
	public @ResponseBody String deleteChar(
			@PathVariable("id") int player_id,
			@RequestParam(name="id", required=true) int char_id
			) {
		
		return "delete";
	}
	
	@GetMapping(value="/{id}/weapons", produces="application/json")
	public @ResponseBody Object getWeapons( //Change to Weapon array once implemented
			@PathVariable("id") int player_id,
			@RequestParam(name="id", required=true) int char_id
			) {
		
		return null;
	}
	
	@GetMapping(value="/{id}/armor", produces="application/json")
	public @ResponseBody Object getArmor( //Change to Armor array once implemented
			@PathVariable("id") int player_id,
			@RequestParam(name="id", required=true) int char_id
			) {
		
		return null;
	}
	
	@PostMapping(value="/{id}/message")
	public String postMessage(
			@PathVariable("id") int player_id,
			@RequestParam(name="id", required=true) int char_id
			) {
		
		return "message";
	}
	
	@GetMapping(value="/{id}/messages", produces="application/json")
	public @ResponseBody Object getMessages( //Change to Message array once implemented
			@PathVariable("id") int player_id,
			@RequestParam(name="id", required=true) int char_id
			) {
		
		return null;
	}
	
	@GetMapping(value="/{id}/message/{mid}", produces="application/json")
	public @ResponseBody Object getMessage( //Change to Message once implemented
			@PathVariable("id") int player_id,
			@PathVariable("mid") int message_id,
			@RequestParam(name="id", required=true) int char_id
			) {
		
		return null;
	}
	
	@GetMapping(value="/{id}/message/search", produces="application/json")
	public @ResponseBody Object findMessage( //Change to Message array once implemented
			@PathVariable("id") int player_id,
			@RequestParam(name="id", required=true) int char_id,
			@RequestParam(name="keywords", required=false) String keywords
			) {
		//Not sure how I should do the keywords param
		
		return null;
	}
	
}
