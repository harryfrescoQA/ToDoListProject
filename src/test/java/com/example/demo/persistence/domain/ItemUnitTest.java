package com.example.demo.persistence.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest // spring boot test lets spring know this is a test file and treat as such
@ActiveProfiles("dev")
public class ItemUnitTest {

	@Test
	public void itemConstructorTest() {
		Item item = new Item("Title", "Message", false);
		assertTrue(item instanceof Item);
	}
	
	@Test
	public void itemConstructorTest2() {
		Item item = new Item(1l,"Title", "Message", false);
		assertTrue(item instanceof Item);
	}
	
	@Test
	public void getItemIdTest() {
		Item item = new Item(1l,"Title", "Message", false);
		assertEquals(Long.valueOf(1l), item.getId());
	}
	
	@Test
	public void setIDTest() {
		Item item = new Item("Title", "Message", false);
		item.setId(1l);
		assertEquals(Long.valueOf(1l), item.getId());
	}
	//Title
	
	@Test
	public void getTitleIdTest() {
		Item item = new Item(1l,"Title", "Message", false);
		assertEquals("Title", item.getTitle());
	}
	
	@Test
	public void setTitleTest() {
		Item item = new Item("Title", "Message", false);
		item.setTitle("Test");
		assertEquals("Test", item.getTitle());
	}
	//Message
	@Test
	public void getMessageTest() {
		Item item = new Item(1l,"Title", "Message", false);
		assertEquals("Message", item.getMessage());
	}
	
	@Test
	public void setMessageTest() {
		Item item = new Item("Title", "Message", false);
		item.setMessage("Test");
		assertEquals("Test", item.getMessage());
	}
	
	//Done
	@Test
	public void getDoneTest() {
		Item item = new Item(1l,"Title", "Message", false);
		assertEquals(false, item.isDone());
	}
	
	@Test
	public void setDoneTest() {
		Item item = new Item("Title", "Message", false);
		item.setDone(true);
		assertEquals(true, item.isDone());
	}
	//To String
	// Equals
}
