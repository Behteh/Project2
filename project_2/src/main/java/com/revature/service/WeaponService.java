package com.revature.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.repository.WeaponRepository;
import com.revature.repository.entity.Weapon;

public class WeaponService {

	WeaponRepository weaponRepository;

	@Autowired
	public WeaponService(WeaponRepository weaponRepository) {
		this.weaponRepository = weaponRepository;
	}
	
	public Optional<Weapon> findById(Long id)
	{
		return weaponRepository.findById(id);
	}
	
	public Weapon save(Weapon weapon)
	{
		return weaponRepository.save(weapon);
	}
	
	public void deleteById(Long id)
	{
		weaponRepository.deleteById(id);
	}
	
}
