package com.selenium.pages.demosite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddItem {

	// ATTRIBUTES
	
	@FindBy(xpath = "//*[@id=\"listButton\"]")
	public
	WebElement viewList;
	
	@FindBy(id = "addToList")
	public
	WebElement addToList;
	
	@FindBy(xpath = "//*[@id=\"listButton\"]")
	public
	WebElement editItem;
	
	@FindBy(id = "nameInput")
	WebElement nameField;

	@FindBy(id = "messageInput")
	WebElement messageField;
	

	
	@FindBy(xpath = "/html/body/div[2]/div/form/button")
	WebElement saveUser;

	@FindBy(id = "listDiv")
	public
	WebElement checkItem;
	// CONSTRUCTOR
	public AddItem() {
	}

	// METHODS
	public void createItem(String name, String message) {
		nameField.sendKeys(name);
		messageField.sendKeys(message);
		saveUser.click();
	}
	
}
