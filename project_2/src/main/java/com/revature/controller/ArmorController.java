package com.revature.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/armor")
public class ArmorController {
	
	@GetMapping(value="/view", produces="application/json")
	public @ResponseBody Object getArmors( //Change to return Armor array once implemented
			) {
		
		return null;
	}
	
	@GetMapping(value="/{id}", produces="application/json")
	public @ResponseBody Object getArmor( //Change to return Armor once implemented
			@PathVariable("id") int armor_id) {
		
		return null;
	}
	
	@PutMapping(value="/{id}/update")
	public String updateArmor(
			@PathVariable("id") int armor_id,
			@RequestParam(name="weaponID", required=false) String name,
			@RequestParam(name="armorID", required=false) int defense,
			@RequestParam(name="name", required=false) int cost
			) {

		return "update";
	}
	
	@PutMapping(value="/create")
	public String createArmor(
			@RequestParam(name="weaponID", required=false) String name,
			@RequestParam(name="armorID", required=false) int defense,
			@RequestParam(name="name", required=false) int cost
			) {

		return "create";
	}
	
	@DeleteMapping(value="/{id}/delete")
	public String deleteArmor(
			@PathVariable("id") int armor_id
			) {

		return "delete";
	}
}
