package com.revature.controller;

import java.util.List;

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

import com.revature.exceptions.CharacterNotFoundException;
import com.revature.exceptions.MessageNotFoundException;
import com.revature.exceptions.NoArmorsException;
import com.revature.exceptions.NoWeaponsException;
import com.revature.repository.entity.Armor;
import com.revature.repository.entity.ChatMessage;
import com.revature.repository.entity.GameUser;
import com.revature.repository.entity.Weapon;

@Controller
@RequestMapping("/character")
public class CharacterController {
	@PostMapping(value="/create")
	public String create(
			@RequestParam(name="name", required=true, defaultValue="") String charname,
			Model model) {

		return "create";
	}

	@PostMapping(value="/login")
	public String login(
			@RequestParam(name="name", required=true, defaultValue="") String charname,
			Model model) throws CharacterNotFoundException {

		return "login";
	}

	@GetMapping(value="/{id}", produces="application/json")
	public @ResponseBody GameUser getCharacter(
			@PathVariable("id") int player_id,
			@RequestParam(name="id", required=true) int char_id
			) throws CharacterNotFoundException, NoArmorsException, NoWeaponsException {
		
		return null;
	}
	
	@PutMapping(value="/{id}/update")
	public String updateUser(
			@PathVariable("id") int player_id,
			@RequestParam(name="id", required=true) int char_id,
			@RequestParam(name="weaponID", required=false) int weapon_iD,
			@RequestParam(name="armorID", required=false) int armor_iD,
			@RequestParam(name="name", required=false) String name
			) throws CharacterNotFoundException {

		return "update";
	}
	
	@DeleteMapping(value="/{id}/delete")
	public @ResponseBody String deleteChar(
			@PathVariable("id") int player_id,
			@RequestParam(name="id", required=true) int char_id
			) throws CharacterNotFoundException {
		
		return "delete";
	}
	
	@GetMapping(value="/{id}/weapons", produces="application/json")
	public @ResponseBody List<Weapon> getWeapons(
			@PathVariable("id") int player_id,
			@RequestParam(name="id", required=true) int char_id
			) throws CharacterNotFoundException, NoWeaponsException{
		
		return null;
	}
	
	@GetMapping(value="/{id}/armor", produces="application/json")
	public @ResponseBody List<Armor> getArmor(
			@PathVariable("id") int player_id,
			@RequestParam(name="id", required=true) int char_id
			) throws CharacterNotFoundException, NoArmorsException {
		
		return null;
	}
	
	@PostMapping(value="/{id}/message")
	public String postMessage(
			@PathVariable("id") int player_id,
			@RequestParam(name="id", required=true) int char_id
			) throws CharacterNotFoundException {
		
		return "message";
	}
	
	@GetMapping(value="/{id}/messages", produces="application/json")
	public @ResponseBody List<ChatMessage> getMessages(
			@PathVariable("id") int player_id,
			@RequestParam(name="id", required=true) int char_id
			) throws CharacterNotFoundException {
		
		return null;
	}
	
	@GetMapping(value="/{id}/message/{mid}", produces="application/json")
	public @ResponseBody ChatMessage getMessage(
			@PathVariable("id") int player_id,
			@PathVariable("mid") int message_id,
			@RequestParam(name="id", required=true) int char_id
			) throws CharacterNotFoundException, MessageNotFoundException {
		
		return null;
	}
	
	@GetMapping(value="/{id}/message/search", produces="application/json")
	public @ResponseBody List<ChatMessage> findMessage(
			@PathVariable("id") int player_id,
			@RequestParam(name="id", required=true) int char_id,
			@RequestParam(name="keywords", required=false) String keywords
			) throws CharacterNotFoundException {
		//Not sure how I should do the keywords param
		
		return null;
	}
	
}
