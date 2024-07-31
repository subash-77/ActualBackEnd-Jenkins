package com.subash.SeleniumExample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class NavBar_Test {

	private WebDriver driver;

	@BeforeEach
	public void setUp() {
		driver = new ChromeDriver();

	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}
	@Test
	void viewJewelry() throws InterruptedException {
		driver.get("http://localhost:3000/login");
		driver.manage().window().maximize();
		driver.findElement(By.name("email")).sendKeys("ssubash56781@gmail.com");
	    driver.findElement(By.name("password")).sendKeys("123456");
	    driver.findElement(By.name("L-btn")).click();
	    Thread.sleep(4000);
	    String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:3000/login", currentUrl);
        Thread.sleep(4000);
        
	    driver.findElement(By.linkText("VIEW JEWELRY")).click();
	    Thread.sleep(4000);

	    String currentUrl1 = driver.getCurrentUrl();
        assertEquals("http://localhost:3000/viewjewelry", currentUrl1);
        Thread.sleep(4000);
        
	}
	@Test
	void viewSales() throws InterruptedException {
		driver.get("http://localhost:3000/login");
		driver.manage().window().maximize();
		driver.findElement(By.name("email")).sendKeys("ssubash56781@gmail.com");
	    driver.findElement(By.name("password")).sendKeys("123456");
	    driver.findElement(By.name("L-btn")).click();
	    Thread.sleep(4000);
	    String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:3000/login", currentUrl);
        Thread.sleep(4000);
        
	    driver.findElement(By.linkText("VIEW SALES")).click();
	    Thread.sleep(4000);

	    String currentUrl1 = driver.getCurrentUrl();
        assertEquals("http://localhost:3000/viewsales", currentUrl1);
        Thread.sleep(4000);
        
	}
//	@Test
//	void addJewelry() throws InterruptedException {
//		driver.get("http://localhost:3000/login");
//		driver.manage().window().maximize();
//		driver.findElement(By.name("email")).sendKeys("ssubash56781@gmail.com");
//	    driver.findElement(By.name("password")).sendKeys("123456");
//	    driver.findElement(By.name("L-btn")).click();
//	    Thread.sleep(4000);
//	    String currentUrl = driver.getCurrentUrl();
//        assertEquals("http://localhost:3000/login", currentUrl);
//        Thread.sleep(4000);
//        
//	    driver.findElement(By.linkText("ADD JEWELRY")).click();
//	    Thread.sleep(4000);
//
//	    String currentUrl1 = driver.getCurrentUrl();
//        assertEquals("http://localhost:3000/addjewelry", currentUrl1);
//        Thread.sleep(4000);
//        
//	}
	@Test
	void addsales() throws InterruptedException {
		driver.get("http://localhost:3000/login");
		driver.manage().window().maximize();
		driver.findElement(By.name("email")).sendKeys("ssubash56781@gmail.com");
	    driver.findElement(By.name("password")).sendKeys("123456");
	    driver.findElement(By.name("L-btn")).click();
	    Thread.sleep(4000);
	    String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:3000/login", currentUrl);
        Thread.sleep(4000);
        
	    driver.findElement(By.linkText("ADD SALES")).click();
	    Thread.sleep(4000);

	    String currentUrl1 = driver.getCurrentUrl();
        assertEquals("http://localhost:3000/addsales", currentUrl1);
        Thread.sleep(4000);
        
	}

}
