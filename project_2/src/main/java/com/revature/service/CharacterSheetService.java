package com.revature.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.repository.CharacterSheetRepository;
import com.revature.repository.entity.CharacterSheet;

@Service
public class CharacterSheetService {

	private CharacterSheetRepository characterSheetRepository;

	@Autowired
	public CharacterSheetService(CharacterSheetRepository characterSheetRepository) {
		this.characterSheetRepository = characterSheetRepository;
	}
	
	public Optional<CharacterSheet> findById(Long id)
	{
		return characterSheetRepository.findById(id);
	}
	
	public CharacterSheet save(CharacterSheet characterSheet)
	{
		return characterSheetRepository.save(characterSheet);
	}
	
	public void deleteById(Long id)
	{
		characterSheetRepository.deleteById(id);
	}
}
