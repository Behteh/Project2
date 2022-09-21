package com.revature.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/friends")
public class UserController {

	@GetMapping(value="/{id}/profile", produces="application/json")
	public @ResponseBody Object getUser( //Change to return User once implemented
			@PathVariable("id") int user_id) {

		return null;
	}
	
	@PostMapping(value="/register")
	public String register(
			@RequestParam(name="username", required=true, defaultValue="") String username,
			@RequestParam(name="password", required=true, defaultValue="") String password,
			Model model) {

		return "create";
	}

	@GetMapping(value="/login")
	public String login(
			@RequestParam(name="username", required=true, defaultValue="") String username,
			@RequestParam(name="password", required=true, defaultValue="") String password,
			Model model) {

		return "login";
	}
}
