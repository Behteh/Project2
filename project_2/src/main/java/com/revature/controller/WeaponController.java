package com.revature.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.GameUserNotFoundException;
import com.revature.exceptions.NoWeaponsException;
import com.revature.exceptions.WeaponNotFoundException;
import com.revature.repository.entity.Armor;
import com.revature.repository.entity.Weapon;
import com.revature.service.WeaponService;

import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/weapon")
public class WeaponController {
	
	private WeaponService weaponService;

	public WeaponController(WeaponService weaponService) {
		this.weaponService = weaponService;
	}
	
	@GetMapping(value="/view", produces="application/json")
	public @ResponseBody ResponseEntity<?> getWeapons(
			) throws NoWeaponsException {
		ArrayList<Weapon> weaponList = weaponService.findAll();
		
		ArrayList<JSONObject> jsonObject = new ArrayList<>();
		
		for(Weapon weapon : weaponList)
		{
			JSONObject object = new JSONObject();
			object.appendField("weapon_id", weapon.getWeapon_id());
			object.appendField("name", weapon.getName());
			object.appendField("strength", weapon.getStrength());
			object.appendField("cost", weapon.getCost());
			object.appendField("url", "/weapon/" + weapon.getWeapon_id());
			jsonObject.add(object);
		}
		return ResponseEntity.ok(jsonObject);
	}
	
	@GetMapping(value="/{id}", produces="application/json")
	public @ResponseBody ResponseEntity<?> getWeapon( //Change to return Weapon once implemented
			@PathVariable("id") long weapon_id
			) throws WeaponNotFoundException {
		Optional<Weapon> weapon = weaponService.findById(weapon_id);
		if(weapon.isPresent())
		{
			JSONObject object = new JSONObject();
			object.appendField("weapon_id", weapon.get().getWeapon_id());
			object.appendField("name", weapon.get().getName());
			object.appendField("strength", weapon.get().getStrength());
			object.appendField("cost", weapon.get().getCost());
			object.appendField("url", "/weapon/view");
			return ResponseEntity.ok(object);
		}
		throw new WeaponNotFoundException("The weapon was not found");
	}
	
	@PutMapping(value="/{id}/update")
	public ResponseEntity updateWeapon(
			@PathVariable("id") long weapon_id,
			@RequestParam(name="name", required=false) String name,
			@RequestParam(name="strength", required=false) int strength,
			@RequestParam(name="cost", required=false) int cost
			) throws WeaponNotFoundException {
		
	Weapon weapon = weaponService.save(new Weapon(weapon_id, name, strength, cost));
	if(weapon == null)
	{
		throw new WeaponNotFoundException("The weapon was not found");
	}
	JSONObject object = new JSONObject();
	object.appendField("weapon_id", weapon.getWeapon_id());
	object.appendField("name", weapon.getName());
	object.appendField("strength", weapon.getStrength());
	object.appendField("cost", weapon.getCost());
	object.appendField("url", "/weapon/" + weapon.getWeapon_id());
	return ResponseEntity.ok(object);
	}
	
	@PutMapping(value="/create")
	public String createWeapon(
			@RequestParam(name="name", required=false) String name,
			@RequestParam(name="strength", required=false) int strength,
			@RequestParam(name="cost", required=false) int cost
			) {

		return "create";
	}
	
	@DeleteMapping(value="/{id}/delete")
	public String deleteWeapon(
			@PathVariable("id") int weapon_id
			) throws WeaponNotFoundException {

		return "delete";
	}
	
	@ExceptionHandler(WeaponNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Object onWeaponNotFoundException() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.appendField("error_code", 404);
		jsonObject.appendField("error_message", "The weapon does not exist.");
		jsonObject.appendField("error_cause", "You navigated directly to the page instead of using a link.");
		jsonObject.appendField("date", LocalDate.now());
		jsonObject.appendField("time", LocalTime.now());
		return jsonObject;
	}
}
