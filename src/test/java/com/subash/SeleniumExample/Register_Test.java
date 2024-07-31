package com.subash.SeleniumExample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class Register_Test {

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
	void registerTest() throws InterruptedException {

		driver.get("http://localhost:3000/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Register")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("username")).sendKeys("naga");
		driver.findElement(By.id("emailaddress")).sendKeys("naga12345@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("confirmpassword")).sendKeys("123456");
		driver.findElement(By.id("R-btn")).click();
		Thread.sleep(4000);

		Alert alert = driver.switchTo().alert();

		String alertMessage = driver.switchTo().alert().getText();

		assertEquals("Registration successful", alertMessage);
		Thread.sleep(5000);

		alert.accept();

		String currentUrl = driver.getCurrentUrl();
		assertEquals("http://localhost:3000/login", currentUrl);
		Thread.sleep(4000);
	}

	@Test
	void inValidUsername() throws InterruptedException {

		driver.get("http://localhost:3000/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Register")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("username")).sendKeys("");

		driver.findElement(By.id("R-btn")).click();
		Thread.sleep(4000);

		WebElement webElement = driver.findElement(By.id("error-username"));
		assertEquals("Username is required", webElement.getText());
	}

	@Test
	void inValidEmailAddress_1() throws InterruptedException {

		driver.get("http://localhost:3000/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Register")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("emailaddress")).sendKeys("");

		driver.findElement(By.id("R-btn")).click();
		Thread.sleep(4000);

		WebElement webElement = driver.findElement(By.id("error-emailaddress"));
		assertEquals("Email is required", webElement.getText());
	}

	@Test
	void inValidEmailAddress_2() throws InterruptedException {

		driver.get("http://localhost:3000/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Register")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("emailaddress")).sendKeys("naga1234@gmail");

		driver.findElement(By.id("R-btn")).click();
		Thread.sleep(4000);

		WebElement webElement = driver.findElement(By.id("error-emailaddress"));
		assertEquals("Email is invalid", webElement.getText());
	}

	@Test
	void inValidPassword() throws InterruptedException {

		driver.get("http://localhost:3000/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Register")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("password")).sendKeys("");

		driver.findElement(By.id("R-btn")).click();
		Thread.sleep(4000);

		WebElement webElement = driver.findElement(By.id("error-password"));
		assertEquals("Password is required", webElement.getText());
	}

	@Test
	void inValidConfirmPassword() throws InterruptedException {

		driver.get("http://localhost:3000/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Register")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("confirmpassword")).sendKeys("123");
		driver.findElement(By.id("R-btn")).click();
		Thread.sleep(4000);

		WebElement webElement = driver.findElement(By.id("error-confirmpassword"));
		assertEquals("Passwords not match", webElement.getText());
	}
}
