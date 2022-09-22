package com.revature.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.repository.entity.ChatMessage;

@Controller
@RequestMapping("/message")
public class MessageController {

	@GetMapping(value="/view", produces="application/json")
	public @ResponseBody List<ChatMessage> getMessages(
			@RequestParam(name="page", required=false) int page
			) {

		return null;
	}
}
