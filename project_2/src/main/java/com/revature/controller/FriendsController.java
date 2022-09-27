package com.revature.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.revature.exceptions.GameUserNotFoundException;
import com.revature.exceptions.NoFriendsException;
import com.revature.repository.entity.Friend;
import com.revature.service.FriendService;

import net.minidev.json.JSONObject;

@Controller
@RequestMapping("/friends")
public class FriendsController {

	private FriendService friendsService;
	
	
	
	public FriendsController(FriendService friendsService) {
		this.friendsService = friendsService;
	}
	@GetMapping(value="/{id}", produces="application/json")
	public @ResponseBody ResponseEntity<?> getFriends( //Change to return Friends array once implemented
			@PathVariable("id") long user_id
			) throws GameUserNotFoundException, NoFriendsException{
		List<Friend> friends = friendsService.findAllFriendsByUser1(user_id);
		return ResponseEntity.ok(friends);
	}
	@PutMapping(value="/{id}/add")
	public ResponseEntity<?> addFriend(
			@PathVariable("id") long user_id,
			@RequestParam(name="id", required=true) long id
			) throws GameUserNotFoundException{
		
		Friend friend = new Friend();
		friend.setUser1(user_id);
		friend.setUser2(id);
		return ResponseEntity.status(201).body(friendsService.save(friend));
	}
	@DeleteMapping(value="/{id}/delete")
	public ResponseEntity<?> deleteFriend(
			@PathVariable("id") long id
			) throws GameUserNotFoundException{
		if(friendsService.exists(id))
		{
			friendsService.deleteById(id);
			return ResponseEntity.status(204).body("");
		}
		throw new GameUserNotFoundException();
	}
	
	@ExceptionHandler(GameUserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Object onGameUserAlreadyExistsException() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.appendField("error_code", 404);
		jsonObject.appendField("error_message", "The user does not exist.");
		jsonObject.appendField("error_cause", "You navigated directly rather than using a link.");
		jsonObject.appendField("date", LocalDate.now());
		jsonObject.appendField("time", LocalTime.now());
		return jsonObject;
	}
	
	@ExceptionHandler(NoFriendsException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Object onNoFriendsException() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.appendField("error_code", 404);
		jsonObject.appendField("error_message", "The user does not have any friends.");
		jsonObject.appendField("error_cause", "The user needs to add friends.");
		jsonObject.appendField("date", LocalDate.now());
		jsonObject.appendField("time", LocalTime.now());
		return jsonObject;
	}
}
