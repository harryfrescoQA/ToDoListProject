package com.selenium;






import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;


import com.selenium.pages.demosite.AddList;
import com.selenium.pages.demosite.AddItem;
import com.selenium.pages.demosite.Site;

public class DemoSiteTest {

    private static RemoteWebDriver driver;
    private static Logger LOGGER = Logger.getGlobal();
   
    @Before
    public static void initialise(){
        LOGGER.setLevel(Level.ALL);
        System.setProperty("webdriver.chrome.driver", "src/test/resources/selenium/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1366, 768));

        // timeouts
        driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        
    }


    @Test
    public void createList() throws InterruptedException{
    	 
        LOGGER.warning("Connecting to site....");
        Site webpage = PageFactory.initElements(driver, Site.class);
        AddList addList = PageFactory.initElements(driver, AddList.class);

        // STAGE 1 - navigate to site.
        // ========================================
            // I want to navigate to....
        	driver.get(Site.URL);
        	
        // STAGE 2 - create a list.
        // ========================================
            LOGGER.info("Creating a new list...\n");
            
            webpage.navMainPage();
            webpage.navListPage();
            addList.createUser("Hello");
                        
        // STAGE 3 - Create item
        // ========================================

        
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
            driver.get(Site.URL);
            webpage.navMainPage();

            
        // STAGE 4 - check success.
        // ========================================
            LOGGER.info("Checking success of automated test...\n");

            // Assert success
            String name, res;
            name = "Hello";
         
            res = addList.checkItem.getText();
            
            assertEquals("1" +" "+ name + " "+ "ViewEdit TitleDelete this List", res);

    }
    @Test
    public void createItem() throws InterruptedException{
    	 
        LOGGER.warning("Connecting to site....");
        Site webpage = PageFactory.initElements(driver, Site.class);
        AddList addList = PageFactory.initElements(driver, AddList.class);
        AddItem addItem = PageFactory.initElements(driver, AddItem.class);
        //DemoLogInUser login = PageFactory.initElements(driver, DemoLogInUser.class);
        // STAGE 1 - navigate to site.
        // ========================================
            // I want to navigate to....
        	driver.get(Site.URL);
        	
        // STAGE 2 - create a list.
        // ========================================
            LOGGER.info("Creating a new list...\n");
            
            webpage.navMainPage();
            webpage.navListPage();
            addList.createUser("Hello");
                        
        // STAGE 3 - Create item
        // ========================================

        
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
            driver.get(Site.URL);
            webpage.navMainPage();
            addItem.viewList.click();
            addItem.addToList.click();
            addItem.createItem("List Item", "List Message");
            
        // STAGE 4 - check success.
        // ========================================
            LOGGER.info("Checking success of automated test...\n");

            // Assert success
            String item, message, res;
            item = "List Item";
            message = "List Message";
            res = addItem.checkItem.getText();
            
            assertEquals("1" +" - "+ item + " - "+ message+"DoneEdit ItemDelete item", res);

    }
    @After
    public static void tearDown() {
        LOGGER.warning("Closing webdriver instance!");

        driver.close();

        LOGGER.info("!!! Webdriver closed successfully !!!");
    }
}