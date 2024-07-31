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
import org.openqa.selenium.*;

class AddSales_Test {

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
	void addSales() throws InterruptedException {
		driver.get("http://localhost:3000");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Login")).click();
	    driver.findElement(By.name("email")).sendKeys("ssubash56781@gmail.com");
	    driver.findElement(By.name("password")).sendKeys("123456");
	    driver.findElement(By.name("L-btn")).click();
	    Thread.sleep(4000);
	    driver.findElement(By.linkText("ADD SALES")).click();
	    Thread.sleep(4000);
		driver.findElement(By.id("saledate")).sendKeys("0012-12-12");
		driver.findElement(By.id("quantitysold")).sendKeys("12");
//		{
//			WebElement dropdown = driver.findElement(By.id("selectId"));
//			dropdown.findElement(By.xpath("//option[. = 'Updated Ring']")).click();
//		}
//		driver.findElement(By.id("As-btn")).click();

//		Thread.sleep(5000);
//		Alert alert = driver.switchTo().alert();
//
//		String alertMessage = driver.switchTo().alert().getText();
//
//		assertEquals("Sale record added successful!", alertMessage);
//		Thread.sleep(5000);
//
//		alert.accept();

//		String currentUrl = driver.getCurrentUrl();
//		assertEquals("http://localhost:3000/viewsales", currentUrl);
//		Thread.sleep(4000);
	}

	@Test
	void inValid_AddSales() throws InterruptedException {
		driver.get("http://localhost:3000");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Login")).click();
	    driver.findElement(By.name("email")).sendKeys("ssubash56781@gmail.com");
	    driver.findElement(By.name("password")).sendKeys("123456");
	    driver.findElement(By.name("L-btn")).click();
	    Thread.sleep(4000);
	    driver.findElement(By.linkText("ADD SALES")).click();
	    Thread.sleep(4000);
		driver.findElement(By.id("saledate")).sendKeys("");
		driver.findElement(By.id("quantitysold")).sendKeys("");

		driver.findElement(By.linkText("ADD SALES")).click();

//		WebElement webElement = driver.findElement(By.id("error-saledate"));
//		assertEquals("Sale Date is required.", webElement.getText());
//		WebElement webElement1 = driver.findElement(By.id("error-quantitysold"));
//		assertEquals("Quantity Sold must be greater than zero.", webElement1.getText());
//		WebElement webElement2 = driver.findElement(By.id("error-select"));
//		assertEquals("Please select at least one Jewelry item.", webElement2.getText());
	}
}
