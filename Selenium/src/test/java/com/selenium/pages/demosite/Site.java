package com.selenium.pages.demosite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Site {
	// ATTRIBUTES
	public static final String URL = "localhost:9092";
	
	@FindBy(xpath = "//*[@id=\"landingA\"]")
	private WebElement enterLink;
	
	@FindBy(xpath = "//*[@id=\"createList\"]/a")
	private WebElement addList;
	
	
	@FindBy(xpath="/html/body/div[2]/div/div/button")
	private WebElement deleteList;

	
	// pages
	public AddList addListPage;
	
	// CONSTRUCTOR
	public Site(WebDriver driver) {
		addListPage = PageFactory.initElements(driver, AddList.class);
	}
	
	// METHODS
	public void navMainPage() {
		enterLink.click();
	}
	
	public void navListPage() {
		addList.click();
	}
	
	public void deleteList() {
		deleteList.click();
	}

}
