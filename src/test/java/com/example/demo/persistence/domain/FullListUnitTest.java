package com.example.demo.persistence.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest // spring boot test lets spring know this is a test file and treat as such
@ActiveProfiles("dev")
public class FullListUnitTest {

	@Test
	public void listConstructorTest() {
		FullList list = new FullList("Title");
		assertTrue(list instanceof FullList);
	}
	
	@Test
	public void listConstructorTest2() {
		FullList list = new FullList(1l,"Title");
		assertTrue(list instanceof FullList);
	}
	
	@Test
	public void getListIdTest() {
		FullList list = new FullList(1l,"Title");
		assertEquals(Long.valueOf(1l), list.getId());
	}
	
	@Test
	public void setIDTest() {
		FullList list = new FullList("Title");
		list.setId(1l);
		assertEquals(Long.valueOf(1l), list.getId());
	}
	//Title
	
	@Test
	public void getTitleTest() {
		FullList list = new FullList(1l,"Title");
		assertEquals("Title", list.getTitle());
	}
	
	@Test
	public void setTitleTest() {
		FullList list = new FullList(1l,"Title");
		list.setTitle("Test");
		assertEquals("Test", list.getTitle());
	}
	
	

	@Test
	public void getItemsTest() {
		FullList list = new FullList(1l,"Title");
		
		Item item1 = new Item(1l,"Title", "Message", false);
		Item item2 = new Item(2l,"Title2", "Message2", false);
		List<Item> items = List.of(item1, item2);
		list.setItems(items);
		assertEquals(items, list.getItems());
	}
	
	
	//To String
	
	@Test
	public void toStringTest() {
		FullList list = new FullList(1l,"Title");
		String testString = "FullList(id=1, title=Title, items=null)";
		//String testString = "Item(id=1, title=Title, message=Message, done=false, fullList=null)";
		assertEquals(testString, list.toString());
	}
	
	@Test
	public void equalsTest() {
		FullList list = new FullList(1l,"Title");
		FullList list2 = new FullList(1l,"Title");
		
		assertTrue(list.equals(list2));
	}
	
	@Test
	public void equalsTestFalse() {
		FullList list = new FullList(1l,"Title");
		FullList list2 = new FullList(2l,"Title");
		
		assertFalse(list.equals(list2));
	}
	
	@Test
	public void equalsTestFalse2() {
		FullList list = new FullList(1l,"Title");
		FullList list2 = new FullList(1l,"Title2");
		
		assertFalse(list.equals(list2));
	}
	
	@Test
	public void equalsTestFalseNull() {
		FullList list = new FullList(1l,"Title");
		FullList list2 = new FullList(null,"Title");
		
		assertFalse(list.equals(list2));
	}
	
	@Test
	public void equalsTestFalseNull2() {
		FullList list = new FullList(1l,"Title");
		FullList list2 = new FullList(1l,null);
		
		assertFalse(list.equals(list2));
	}
	
	@Test
	public void hashCodeTest() {
		FullList list = new FullList(1l,"Title");
	
		assertEquals(473547503, list.hashCode());
	}

	
	//Hash code
	//SetFullList
}
