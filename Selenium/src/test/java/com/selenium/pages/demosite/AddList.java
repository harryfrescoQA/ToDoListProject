package com.selenium.pages.demosite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddList {

	// ATTRIBUTES
	@FindBy(id = "nameInput")
	WebElement listField;
	
	@FindBy(xpath = "/html/body/div[2]/div/form/button")
	WebElement createList;

	@FindBy(id = "listDiv")
	public
	WebElement checkItem;
	
	// CONSTRUCTOR
	public AddList() {
	}

	// METHODS
	public void createUser(String listName) {
		listField.sendKeys(listName);
		createList.click();
	}
}
