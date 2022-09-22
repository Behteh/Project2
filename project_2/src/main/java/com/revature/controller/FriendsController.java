package com.revature.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.exceptions.GameUserNotFoundException;
import com.revature.exceptions.NoFriendsException;

@Controller
@RequestMapping("/friends")
public class FriendsController {

	@GetMapping(value="/{id}", produces="application/json")
	public @ResponseBody Object getFriends( //Change to return Friends array once implemented
			@PathVariable("id") int user_id
			) throws GameUserNotFoundException, NoFriendsException{
		
		return null;
	}
	@PutMapping(value="/{id}/add")
	public String addFriend(
			@PathVariable("id") int user_id,
			@RequestParam(name="friend_id", required=true) int friend_id
			) throws GameUserNotFoundException{
		
		return "add";
	}
	@DeleteMapping(value="/{id}/delete")
	public String deleteFriend(
			@PathVariable("id") int user_id,
			@RequestParam(name="friend_id", required=true) int friend_id
			) throws GameUserNotFoundException{
		
		return "delete";
	}
}
