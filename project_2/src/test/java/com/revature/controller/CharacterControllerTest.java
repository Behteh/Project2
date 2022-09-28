
package com.revature.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.NestedServletException;

import com.revature.exceptions.CharacterNotFoundException;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CharacterControllerTest{

        static int fylo_char_id = 0;
        @Autowired
        private MockMvc mvc;

        /*@Test
        @Order(1)
        public void createCharacterTest() throws Exception{
                String result = mvc.perform(MockMvcRequestBuilders.post("/character/create").param("name", "Fylo").param("user_id", "2"))
                        .andExpect(status().is(201))
                        .andReturn().getResponse().getContentAsString();

                String[] resultSplit = result.split("[:,]");
                fylo_char_id = Integer.parseInt(resultSplit[1]);
        }

        @Test
        @Order(2)
        public void createCharacterDuplicateErrorTest() throws Exception{
        	Assertions.assertThrows(NestedServletException.class, ()->
            	mvc.perform(MockMvcRequestBuilders.post("/character/create").param("user_id", "2").param("name", "Fylo")));
        }
		
        @Test
        @Order(3)
        public void updateCharacterTest() throws Exception{
        	//System.out.println("Fylo's ID is "+fylo_char_id);
			mvc.perform(MockMvcRequestBuilders.put("/character/"+fylo_char_id+"/update")
                .param("user_id", "2").param("weapon_id", "5").param("armor_id", "5").param("name", "Dustin").param("gold", "55").param("health", "77"))
               	.andExpect(status().is(200));
        }
        
        @Test
        @Order(4)
        public void updateCharacterDuplicateNameTest() throws Exception{
			Assertions.assertThrows(NestedServletException.class, ()->
        		mvc.perform(MockMvcRequestBuilders.put("/character/"+fylo_char_id+"/update")
	                .param("user_id", "2").param("name", "philips")));
        }
        
        @Test
        public void updateCharacterNotFoundTest() throws Exception{
        		mvc.perform(MockMvcRequestBuilders.put("/character/99999999/update")
	                .param("user_id", "2").param("name", "philips"))
        			.andExpect(status().is(404));
        }

        @Test
        @Order(5)
        public void deleteCharacterTest() throws Exception{
            mvc.perform(MockMvcRequestBuilders.delete("/character/"+fylo_char_id+"/delete"))
            .andExpect(status().is(204));
        }

        @Test
        @Order(6)
        public void deleteCharacterNotFoundTest() throws Exception{
            mvc.perform(MockMvcRequestBuilders.delete("/character/"+fylo_char_id+"/delete"))
            	.andExpect(status().is(404));
        }
        
        @Test
        public void getCharacterTest() throws Exception{
                mvc.perform(MockMvcRequestBuilders.get("/character/1").accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(content().string(equalTo("{\"gold\":10,\"armor_id\":2,\"user_id\":1,\"armor_url\":\"/armor/2\",\"name\":\"markj\",\"weapon_url\":\"/weapon/3\",\"character_id\":1,\"weapon_id\":3}")));
        }

        @Test
        public void getCharacterNotFoundTest() throws Exception{
        	mvc.perform(MockMvcRequestBuilders.get("/character/99999"))
        		.andExpect(status().is(404));
        }*/
        
        @Test
        public void getWeaponsTest() throws Exception{
        	//Not sure what it's supposed to return, but now it's returning "[]" which is probably incorrect
        	mvc.perform(MockMvcRequestBuilders.get("/character/2/weapons"))
        		.andExpect(content().string(equalTo("a")));
        }
        
        @Test
        public void getWeaponsNotFoundTest() throws Exception{
        	mvc.perform(MockMvcRequestBuilders.get("/character/9999999/weapons"))
        		.andExpect(status().is(404));
        }
        
        @Test
        public void getArmorsTest() throws Exception{
        	//Not sure what it's supposed to return, but now it's returning "[]" which is probably incorrect
        	mvc.perform(MockMvcRequestBuilders.get("/character/2/armors"))
        		.andExpect(content().string(equalTo("a")));
        }
        
        @Test
        public void getArmorsNotFoundTest() throws Exception{
        	mvc.perform(MockMvcRequestBuilders.get("/character/9999999/armors"))
        		.andExpect(status().is(404));
        }
}