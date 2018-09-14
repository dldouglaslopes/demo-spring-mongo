package com.douglas.demospringmongo;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.douglas.demospringmongo.controller.ConfigBookController;

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
	
	@AfterClass
	public static void afterTest() {
		System.out.println("-----> DESTROY <-----");
	}
}
