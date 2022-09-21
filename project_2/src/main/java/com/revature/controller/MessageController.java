package com.revature.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/message")
public class MessageController {

	@GetMapping(value="/view", produces="application/json")
	public @ResponseBody Object getMessages( //Change to return Message array once implemented
			@RequestParam(name="page", required=false) int page
			) {
		
		return null;
	}
}
