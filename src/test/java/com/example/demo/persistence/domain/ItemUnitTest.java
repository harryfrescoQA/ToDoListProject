package com.example.demo.persistence.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
	
	@Test
	public void toStringTest() {
		Item item = new Item(1l,"Title", "Message", false);
		String testString = "Item(id=1, title=Title, message=Message, done=false, fullList=null)";
		assertEquals(testString, item.toString());
	}
	
	@Test
	public void equalsTest() {
		Item item = new Item(1l,"Title", "Message", false);
		Item item2 = new Item(1l,"Title", "Message", false);
		
		assertTrue(item.equals(item2));
	}
	
	@Test
	public void equalsTestFalse() {
		Item item = new Item(1l,"Title", "Message", false);
		Item item2 = new Item(2l,"Title", "Message", false);
		
		assertFalse(item.equals(item2));
	}
	
	@Test
	public void equalsTestFalse2() {
		Item item = new Item(1l,"Title", "Message", false);
		Item item2 = new Item(1l,"Title2", "Message", false);
		
		assertFalse(item.equals(item2));
	}
	
	@Test
	public void equalsTestFalse3() {
		Item item = new Item(1l,"Title", "Message", false);
		Item item2 = new Item(1l,"Title", "Message2", false);
		
		assertFalse(item.equals(item2));
	}
	
	@Test
	public void equalsTestFalse4() {
		Item item = new Item(1l,"Title", "Message", false);
		Item item2 = new Item(1l,"Title", "Message", true);
		
		assertFalse(item.equals(item2));
	}
	
	
	@Test
	public void hashCodeTest() {
		Item item = new Item(1l,"Title", "Message", false);
	
		assertEquals(-310980353, item.hashCode());
	}

	
	//Hash code
	//SetFullList
}
