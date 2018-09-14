package com.douglas.demospringmongo;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.eq;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.douglas.demospringmongo.controller.ConfigBookController;
import com.douglas.demospringmongo.domain.ConfigBook;
import com.douglas.demospringmongo.repository.ConfigBookRepository;

@RunWith(MockitoJUnitRunner.class)
public class ConfigBookControllerTest {

	@Mock
	private ConfigBookRepository configBookRepository; 
	
	@InjectMocks
	private ConfigBookController configBookController;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllTheConfigBooks() throws Exception {
		when(configBookController.findAll()).thenReturn(new ArrayList<ConfigBook>());
        List<ConfigBook> configBooks = configBookController.findAll();
        assertNotNull(configBooks);
        verify(configBookRepository).findAll();
	}
	
	@Test
	public void testGetOneConfigBook() throws Exception {
		String id = "5b8d757ba89dfe2828055665";
		when(configBookController.findById(id)).thenReturn(Optional.of(new ConfigBook()));
        Optional<ConfigBook> configBook = configBookController.findById(id);
        assertNotNull(configBook);
        verify(configBookRepository).findById(id);
	}
	
	@Test
	public void testSaveConfigBook() throws Exception {
		final ConfigBook configBook = new ConfigBook();
		configBookController.save(configBook);
        verify(configBookRepository).save(eq(configBook));
	}
	
	@Test
	public void testDeleteConfigBook() throws Exception {
		String id = "5b903291a89dfe22b9d5976b";		
		configBookController.deleteById(id);        
        verify(configBookRepository).deleteById(id);
	}
}

/*
@Mock
private MongoTemplate mongoTemplate; 
 
mockMvc = MockMvcBuilders.standaloneSetup(configBookController)
								.build(); 
 
mockMvc.perform(MockMvcRequestBuilders.get("localhost:8080/clients/5b8d757ba89dfe2828055665")
										.accept(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("Joao Humberto Rios")));

mockMvc.perform(MockMvcRequestBuilders.get("/clients/"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("Hello"));
*/
