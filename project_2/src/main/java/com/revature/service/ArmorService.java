package com.revature.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.repository.ArmorRepository;
import com.revature.repository.entity.Armor;

public class ArmorService {

	ArmorRepository armorRepository;

	@Autowired
	public ArmorService(ArmorRepository armorRepository) {
		this.armorRepository = armorRepository;
	}
	
	public Optional<Armor> findById(Long id)
	{
		return armorRepository.findById(id);
	}
	
	public Armor save(Armor armor)
	{
		return armorRepository.save(armor);
	}
	
	public void deleteById(Long id)
	{
		armorRepository.deleteById(id);
	}
	
}
