package com.selenium;






import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;


import com.selenium.pages.demosite.AddList;
import com.selenium.pages.demosite.AddItem;
import com.selenium.pages.demosite.Site;

import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DemoSiteTest {

    private static RemoteWebDriver driver;
    private static Logger LOGGER = Logger.getGlobal();
   
    @Before
    public  void initialise(){
        LOGGER.setLevel(Level.ALL);
        System.setProperty("webdriver.chrome.driver", "src/test/resources/selenium/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1366, 768));

        // timeouts
        driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        
    }


    @Test
    public void AcreateList() throws InterruptedException{
    	 
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
    public void BcreateItem() throws InterruptedException{
    	 
        LOGGER.warning("Connecting to site....");
        Site webpage = PageFactory.initElements(driver, Site.class);
        //AddList addList = PageFactory.initElements(driver, AddList.class);
        AddItem addItem = PageFactory.initElements(driver, AddItem.class);
        //DemoLogInUser login = PageFactory.initElements(driver, DemoLogInUser.class);
        // STAGE 1 - navigate to site.
        // ========================================
            // I want to navigate to....
        	driver.get(Site.URL);
        	
        // STAGE 2 - create a list.
        // ========================================
            LOGGER.info("Creating a new list...\n");
           // addList.createUser("Hello");
                        
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
    
    @Test
    public void CupdateList() throws InterruptedException{
    	 
        LOGGER.warning("Connecting to site....");
        Site webpage = PageFactory.initElements(driver, Site.class);
        AddList addList = PageFactory.initElements(driver, AddList.class);
        // STAGE 1 - navigate to site.
        // ========================================
            // I want to navigate to....
        	driver.get(Site.URL);
        	
        // STAGE 2 - delete a list.
        // ========================================
            LOGGER.info("updating list...\n");
            
            webpage.navMainPage();
            List <WebElement> custButtons = driver.findElements(By.id("listButton"));
            custButtons.get(1).click();
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
           //webpage.deleteList();
          // driver.switchTo().alert().accept();
           
            WebElement name = driver.findElement(By.id("nameInput"));
            name.sendKeys("UpdateTest");
            addList.createList.click();
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
            driver.get(Site.URL);
            webpage.navMainPage();

            
        // STAGE 4 - check success.
        // ========================================
            LOGGER.info("Checking success of automated test...\n");

            // Assert success
            String nameUpd, res;
            nameUpd = "HelloUpdateTest";
         
            res = addList.checkItem.getText();
            
            assertEquals("1" +" "+ nameUpd + " "+ "ViewEdit TitleDelete this List", res);


            
    }
    
    @Test
    public void DupdateItem() throws InterruptedException{
    	 
        LOGGER.warning("Connecting to site....");
        Site webpage = PageFactory.initElements(driver, Site.class);
        AddList addList = PageFactory.initElements(driver, AddList.class);
        AddItem addItem = PageFactory.initElements(driver, AddItem.class);
        // STAGE 1 - navigate to site.
        // ========================================
            // I want to navigate to....
        	driver.get(Site.URL);
        	
        // STAGE 2 - delete a list.
        // ========================================
            LOGGER.info("updating list...\n");
            
            webpage.navMainPage();
            addItem.viewList.click();
            List <WebElement> custButtons = driver.findElements(By.id("listButton"));
            custButtons.get(1).click();
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
           //webpage.deleteList();
          // driver.switchTo().alert().accept();
           
            WebElement name = driver.findElement(By.id("nameInput"));
            name.sendKeys("UpdateTest");
            
            WebElement message = driver.findElement(By.id("messageInput"));
            message.sendKeys("UpdateTest");
            addList.updateItem.click();
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
            driver.get(Site.URL);
            webpage.navMainPage();
            addItem.viewList.click();
            
        // STAGE 4 - check success.
        // ========================================
            LOGGER.info("Checking success of automated test...\n");

            // Assert success
            String nameUpd,messUpd, res;
            nameUpd = "List ItemUpdateTest";
            messUpd ="List MessageUpdateTest" ;
            res = addList.checkItem.getText();
            
            assertEquals("1" +" - "+ nameUpd + " - "+ messUpd+"DoneEdit ItemDelete item", res);


    }
    @Test
    public void EdeleteItem() throws InterruptedException{
    	 
        LOGGER.warning("Connecting to site....");
        Site webpage = PageFactory.initElements(driver, Site.class);
       
        // STAGE 1 - navigate to site.
        // ========================================
            // I want to navigate to....
        	driver.get(Site.URL);
        	
        // STAGE 2 - delete an item.
        // ========================================
            LOGGER.info("Deleting list...\n");
            
            webpage.navMainPage();
           // webpage.navListPage();
            List <WebElement> custButtons = driver.findElements(By.id("listButton"));
            custButtons.get(0).click();
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
           //webpage.deleteList();
          
            List <WebElement> custButtons2 = driver.findElements(By.id("listButton"));
            custButtons2.get(2).click();
          driver.switchTo().alert().accept();
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        // STAGE 4 - check success.
        // ========================================
            LOGGER.info("Checking success of automated test...\n");
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
            int exists = driver.findElements( By.id("listDiv") ).size();
            
            assertEquals(1, exists);

    }
    @Test
    public void FdeleteList() throws InterruptedException{
    	 
        LOGGER.warning("Connecting to site....");
        Site webpage = PageFactory.initElements(driver, Site.class);
       
        // STAGE 1 - navigate to site.
        // ========================================
            // I want to navigate to....
        	driver.get(Site.URL);
        	
        // STAGE 2 - delete a list.
        // ========================================
            LOGGER.info("Deleting list...\n");
            
            webpage.navMainPage();
            List <WebElement> custButtons = driver.findElements(By.id("listButton"));
            custButtons.get(2).click();
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
           //webpage.deleteList();
           driver.switchTo().alert().accept();
            
        // STAGE 4 - check success.
        // ========================================
            LOGGER.info("Checking success of automated test...\n");
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
            int exists = driver.findElements( By.id("listDiv") ).size();
            
            assertEquals(1, exists);

    }
    @After
    public  void tearDown() {
        LOGGER.warning("Closing webdriver instance!");

        driver.close();

        LOGGER.info("!!! Webdriver closed successfully !!!");
    }
}