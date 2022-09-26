package com.revature.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
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
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.CharacterNotFoundException;
import com.revature.exceptions.MessageNotFoundException;
import com.revature.exceptions.NoArmorsException;
import com.revature.exceptions.NoWeaponsException;
import com.revature.repository.CharacterSheetRepository;
import com.revature.repository.entity.Armor;
import com.revature.repository.entity.CharacterSheet;
import com.revature.repository.entity.ChatMessage;
import com.revature.repository.entity.GameUser;
import com.revature.repository.entity.PrivateMessage;
import com.revature.repository.entity.Weapon;
import com.revature.service.CharacterSheetService;
import com.revature.service.CharacterWeaponsService;
import com.revature.service.PrivateMessageService;

import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/character")
public class CharacterController {
	
	private CharacterSheetService characterSheetService;
	private CharacterWeaponsService characterWeaponsService;
	private PrivateMessageService privateMessageService;
	

	public CharacterController(CharacterSheetService characterSheetService,
			CharacterWeaponsService characterWeaponsService, PrivateMessageService privateMessageService) {
		this.characterSheetService = characterSheetService;
		this.characterWeaponsService = characterWeaponsService;
		this.privateMessageService = privateMessageService;
	}

	@PostMapping(value="/create")
	public ResponseEntity<?> create(
			@RequestParam(name="name", required=true, defaultValue="") String charname,
			@RequestParam(name="user_id", required=true) long user_id
			) {
		CharacterSheet characterSheet = new CharacterSheet();
		characterSheet.setName(charname);
		characterSheet.setUser_id(user_id);
		CharacterSheet newCharacter = characterSheetService.save(characterSheet);
		return ResponseEntity.status(201).body(newCharacter);
	}

	@GetMapping(value="/{id}", produces="application/json")
	public @ResponseBody ResponseEntity<?> getCharacter(
			@PathVariable("id") long player_id
			) throws CharacterNotFoundException, NoArmorsException, NoWeaponsException {
		Optional<CharacterSheet> characterSheet = characterSheetService.findById(player_id);
		if(characterSheet.isPresent())
		{
			JSONObject json = new JSONObject();
			json.appendField("character_id", characterSheet.get().getCharacter_id());
			json.appendField("name", characterSheet.get().getName());
			json.appendField("gold", characterSheet.get().getGold());
			json.appendField("weapon_id", characterSheet.get().getWeapon_id());
			json.appendField("weapon_url", "/weapon/" + characterSheet.get().getWeapon_id());
			json.appendField("armor_id", characterSheet.get().getArmor_id());
			json.appendField("armor_url", "/armor/" + characterSheet.get().getArmor_id());
			json.appendField("user_id", characterSheet.get().getUser_id());
			return ResponseEntity.ok(json);
		}
		throw new CharacterNotFoundException("The character was not found");
	}
	
	@PutMapping(value="/{id}/update")
	public ResponseEntity<?> updateUser(
			@PathVariable("id") long player_id,
			@RequestParam(name="id", required=true) long char_id,
			@RequestParam(name="weapon_id", required=false, defaultValue = "0") long weapon_id,
			@RequestParam(name="armor_id", required=false, defaultValue = "0") long armor_id,
			@RequestParam(name="name", required=false, defaultValue = "0") String name
			) throws CharacterNotFoundException {
		if(!characterSheetService.exists(char_id))
		{
			throw new CharacterNotFoundException("The character was not found");
		}
		CharacterSheet characterSheet = new CharacterSheet();
		if(weapon_id != 0)
		{
			characterSheet.setWeapon_id(weapon_id);
		}
		if(armor_id != 0)
		{
			characterSheet.setArmor_id(armor_id);
		}
		if(!name.equals("0"))
		{
			characterSheet.setName(name);
		}
		return ResponseEntity.ok(characterSheetService.save(characterSheet));
	}
	
	@DeleteMapping(value="/{id}/delete")
	public @ResponseBody ResponseEntity<?> deleteChar(
			@PathVariable("id") long player_id
			) throws CharacterNotFoundException {
		if(characterSheetService.exists(player_id))
		{
			characterSheetService.deleteById(player_id);
			return ResponseEntity.status(204).body("");
		}
		throw new CharacterNotFoundException("The character was not found");
	}
	
	@GetMapping(value="/{id}/weapons", produces="application/json")
	public @ResponseBody ResponseEntity<?> getWeapons(
			@PathVariable("id") long player_id
			) throws CharacterNotFoundException, NoWeaponsException{
	
		ArrayList<Weapon> weapons = characterWeaponsService.findWeaponsByCharacterId(player_id);
		return ResponseEntity.ok(weapons);
	}
	
	@GetMapping(value="/{id}/armor", produces="application/json")
	public @ResponseBody List<Armor> getArmor(
			@PathVariable("id") int player_id,
			@RequestParam(name="id", required=true) int char_id
			) throws CharacterNotFoundException, NoArmorsException {
		
		return null;
	}
	
	@PutMapping(value="/{id}/message")
	public ResponseEntity<PrivateMessage> postMessage(
			@PathVariable("id") long player_id,
			@RequestParam(name="id", required=true) long char_id,
			@RequestParam(name="topic", required=true) String topic,
			@RequestParam(name="message", required=true) String message
			) throws CharacterNotFoundException {
		if(characterSheetService.exists(player_id))
		{
			PrivateMessage pm = new PrivateMessage();
			pm.setFromUserId(char_id);
			pm.setToUserId(player_id);
			pm.setTopic(topic);
			pm.setMessage(message);
			pm.setTimestamp(LocalDateTime.now());
			return ResponseEntity.status(201).body(privateMessageService.save(pm));
		}
		throw new CharacterNotFoundException();
	}
	
	@GetMapping(value="/{id}/messages", produces="application/json")
	public @ResponseBody ResponseEntity<List<PrivateMessage>> getMessages(
			@PathVariable("id") int player_id
			) throws CharacterNotFoundException {
	
		if(characterSheetService.exists(player_id))
		{
			Optional<List<PrivateMessage>> messages = privateMessageService.getRecentMessages(player_id);
			if(messages.isPresent())
			{
				return ResponseEntity.ok(messages.get());
			}
			return ResponseEntity.status(204).body(messages.get());
		}
		else
		{
			throw new CharacterNotFoundException();
		}
		
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
