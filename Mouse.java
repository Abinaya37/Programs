package com.sample.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mouse {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement login = driver.findElement(By.xpath("//a[text()='Log in']"));

		js.executeScript("arguments[0].scrollIntoView()", login);

		Thread.sleep(2000);

		WebElement email = driver.findElement(By.xpath("//input[contains(@placeholder,'address ')]"));

		js.executeScript("arguments[0].scrollIntoView()", email);

		js.executeScript("arguments[0].value='abinaya@gmail.com'", email);

		js.executeScript("arguments[0].setAttribute('style','color:red')", email);

		js.executeScript("arguments[0].scrollIntoView()", login);
		
		Thread.sleep(2000);

		js.executeScript("arguments[0].click()", login);

	}

}
