package com.selenium.pages.demosite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddList {

	// ATTRIBUTES
	@FindBy(id = "nameInput")
	WebElement listField;
	
	@FindBy(xpath = "/html/body/div[2]/div/form/button")
	public
	WebElement createList;

	@FindBy(id = "listDiv")
	public
	WebElement checkItem;
	
	@FindBy(xpath = "/html/body/div[2]/div/form/button")
	public
	WebElement updateItem;
	
	// CONSTRUCTOR
	public AddList() {
	}

	// METHODS
	public void createUser(String listName) {
		listField.sendKeys(listName);
		createList.click();
	}
}
