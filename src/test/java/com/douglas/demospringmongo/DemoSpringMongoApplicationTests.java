package com.douglas.demospringmongo;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.douglas.demospringmongo.controller.ConfigBookController;
import com.douglas.demospringmongo.domain.Address;
import com.douglas.demospringmongo.domain.BranchMap;
import com.douglas.demospringmongo.domain.ConfigBook;
import com.douglas.demospringmongo.domain.Contact;
import com.douglas.demospringmongo.domain.CostCenter;
import com.douglas.demospringmongo.domain.IPAddress;
import com.douglas.demospringmongo.domain.Queue;
import com.douglas.demospringmongo.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoSpringMongoApplication.class)
public class DemoSpringMongoApplicationTests {
	
	@Autowired
	private ConfigBookController bookController;
	
	@BeforeClass
	public static void setUp() {
		System.out.println("-----> SETUP <-----");
	}
	
	@Test
	public void contextLoads() {
		assertEquals("class com.douglas.demospringmongo.controller.ConfigBookController",
						this.bookController.getClass().toString());
	}
	
	@Test
	public void testControllerCreateNewConfigBook() {		
		ConfigBook newConfigBook = new ConfigBook();
		newConfigBook.setName("XYZ");
		newConfigBook.setAddress(new Address());
		newConfigBook.setUser(new User());
		newConfigBook.setBranchMaps(new ArrayList<BranchMap>());
		newConfigBook.setContacts(new ArrayList<Contact>());
		newConfigBook.setCostCenters(new ArrayList<CostCenter>());
		newConfigBook.setIpAddresses(new ArrayList<IPAddress>());
		newConfigBook.setQueues(new ArrayList<Queue>());
		
		if(newConfigBook != null) {
			assertThat(bookController.save(newConfigBook), instanceOf(ConfigBook.class));
			assertNotNull("Name isn't not null", newConfigBook.getName());
			assertNotNull("Address isn't null", newConfigBook.getAddress());
			assertNotNull("User isn't null", newConfigBook.getUser());
		}
		
		assertNotNull("New ConfigBook is not null", newConfigBook);	
	}
	
	@AfterClass
	public static void afterTest() {
		System.out.println("-----> DESTROY <-----");
	}
}
