package com.revature.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.exceptions.ArmorNotFoundException;
import com.revature.repository.entity.Armor;

@Controller
@RequestMapping("/armor")
public class ArmorController {
	
	@GetMapping(value="/view", produces="application/json")
	public @ResponseBody List<Armor> getArmors(
			) {
		
		return null;
	}
	
	@GetMapping(value="/{id}", produces="application/json")
	public @ResponseBody Armor getArmor(
			@PathVariable("id") int armor_id
			) throws ArmorNotFoundException {
		
		return null;
	}
	
	@PutMapping(value="/{id}/update")
	public String updateArmor(
			@PathVariable("id") int armor_id,
			@RequestParam(name="armorName", required=false) String name,
			@RequestParam(name="armorDef", required=false) int defense,
			@RequestParam(name="cost", required=false) int cost
			) throws ArmorNotFoundException{

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
			) throws ArmorNotFoundException {

		return "delete";
	}
}
