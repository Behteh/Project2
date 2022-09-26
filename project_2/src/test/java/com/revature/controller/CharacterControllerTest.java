package com.revature.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.junit.jupiter.api.Assertions;

import com.revature.exceptions.CharacterNotFoundException;

@SpringBootTest
@AutoConfigureMockMvc
public class CharacterControllerTest{
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void createCharacterTest() throws Exception{
		mvc.perform(MockMvcRequestBuilders.post("/character/create?name=Fylo&user_id=1").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().is(201))
		.andExpect(content().string(equalTo("a")));
	}
	
	@Test
	public void getCharacterTest() throws Exception{
		mvc.perform(MockMvcRequestBuilders.get("/character/1").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().string(equalTo("{\"gold\":10,\"armor_id\":2,\"user_id\":1,\"armor_url\":\"/armor/2\",\"name\":\"markj\",\"weapon_url\":\"/weapon/3\",\"character_id\":1,\"weapon_id\":3}")));
	}
	
	@Test
	public void getCharacterFailedTest() throws Exception{
		Exception e1 = Assertions.assertThrows(CharacterNotFoundException.class, ()->{
			mvc.perform(MockMvcRequestBuilders.get("/character/99999").accept(MediaType.APPLICATION_JSON));});
		assert(e1.getMessage().equals("The character was not found"));
	}
	
	@Test
	public void updateCharacterTest() throws Exception{
		
	}
}