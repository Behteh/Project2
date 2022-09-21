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
@RequestMapping("/weapon")
public class WeaponController {
	
	@GetMapping(value="/view", produces="application/json")
	public @ResponseBody Object getWeapons( //Change to return Weapon array once implemented
			) {
		
		return null;
	}
	
	@GetMapping(value="/{id}", produces="application/json")
	public @ResponseBody Object getWeapon( //Change to return Weapon once implemented
			@PathVariable("id") int weapon_id) {
		
		return null;
	}
	
	@PutMapping(value="/{id}/update")
	public String updateWeapon(
			@PathVariable("id") int weapon_id,
			@RequestParam(name="weaponID", required=false) String name,
			@RequestParam(name="armorID", required=false) int strength,
			@RequestParam(name="name", required=false) int cost
			) {

		return "update";
	}
	
	@PutMapping(value="/create")
	public String createWeapon(
			@RequestParam(name="weaponID", required=false) String name,
			@RequestParam(name="armorID", required=false) int strength,
			@RequestParam(name="name", required=false) int cost
			) {

		return "create";
	}
	
	@DeleteMapping(value="/{id}/delete")
	public String deleteWeapon(
			@PathVariable("id") int weapon_id
			) {

		return "delete";
	}
}
