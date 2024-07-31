package com.subash.SeleniumExample;




import static org.junit.jupiter.api.Assertions.assertEquals;



import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class Login_Logout_Test {
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
	void loginTest() throws InterruptedException {
		
		driver.get("http://localhost:3000/");
		driver.manage().window().maximize();
	    driver.findElement(By.linkText("Login")).click();
	    driver.findElement(By.name("email")).sendKeys("ssubash56781@gmail.com");
	    driver.findElement(By.name("password")).sendKeys("123456");
	    driver.findElement(By.name("L-btn")).click();
	    Thread.sleep(4000);
	    String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:3000/login", currentUrl);
        Thread.sleep(4000);
	   
	}
	@Test
	void invalidEmailTest() throws InterruptedException {
		
		driver.get("http://localhost:3000/");
		driver.manage().window().maximize();
	    driver.findElement(By.linkText("Login")).click();
	    driver.findElement(By.name("email")).sendKeys("ssubash56781@gmail");
	    Thread.sleep(4000);
	    driver.findElement(By.name("L-btn")).click();
	    WebElement webElement = driver.findElement(By.name("emailerror"));
	    assertEquals("Please enter a valid email address", webElement.getText());
	    Thread.sleep(4000);
	}
	@Test
	void invalidPasswordTest() throws InterruptedException {
		
		driver.get("http://localhost:3000/");
		driver.manage().window().maximize();
	    driver.findElement(By.linkText("Login")).click();
	    Thread.sleep(4000);
	    driver.findElement(By.name("email")).sendKeys("ssubash56781@gmail.com");
	    driver.findElement(By.name("L-btn")).click();
	    WebElement webElement = driver.findElement(By.name("passworderror"));
	    assertEquals("Please enter your password", webElement.getText());
	    Thread.sleep(10000);
	}
	@Test
	void logoutAlertTest() throws InterruptedException {

		driver.get("http://localhost:3000/login");
		driver.manage().window().maximize();
		driver.findElement(By.name("email")).sendKeys("ssubash56781@gmail.com");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("L-btn")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.name("btnbtn")).click();
		Thread.sleep(5000);

		Alert alert = driver.switchTo().alert(); 

		String alertMessage = driver.switchTo().alert().getText(); 

		assertEquals("Successfully Logout - Session Expired", alertMessage);
		Thread.sleep(5000);
		
		alert.accept();
	}
}
