package com.subash.SeleniumExample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class AddJewellery_Test {
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
	void addJewelry() throws InterruptedException {
		driver.get("http://localhost:3000");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Login")).click();
	    driver.findElement(By.name("email")).sendKeys("ssubash56781@gmail.com");
	    driver.findElement(By.name("password")).sendKeys("123456");
	    driver.findElement(By.name("L-btn")).click();
	    Thread.sleep(4000);
	    driver.findElement(By.linkText("ADD JEWELRY")).click();
	    Thread.sleep(4000);
	    driver.findElement(By.id("name")).sendKeys("Ring");
	    driver.findElement(By.id("description")).sendKeys("Ring");
	    driver.findElement(By.id("price")).sendKeys("10000");
	    driver.findElement(By.id("stock")).sendKeys("10");
	    
//	    driver.findElement(By.linkText("Submit")).click();
//	    Thread.sleep(4000);
//	    
//	    Alert alert = driver.switchTo().alert(); 
//
//		String alertMessage = driver.switchTo().alert().getText(); 
//
//		assertEquals("Data added Successfully", alertMessage);
//		Thread.sleep(5000);
//		
//		alert.accept();
//		
//	    String currentUrl = driver.getCurrentUrl();
//        assertEquals("http://localhost:3000/viewjewelry", currentUrl);
//        Thread.sleep(4000);
	}

}
