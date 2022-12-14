package com.sample.demo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Single_Window {

	public static void main(String[] args) throws AWTException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();

	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		WebElement mobiles = driver.findElement(By.xpath("//a[text()='Mobiles']"));

		Actions a = new Actions(driver);
		a.contextClick(mobiles).build().perform();

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		String parent_Id = driver.getWindowHandle(); // online
		System.out.println(parent_Id);

		Set<String> all_Id = driver.getWindowHandles(); // online, mobile
		System.out.println(all_Id);

		for (String id : all_Id) { // online, mobile

			// String id = mobile
			// mobile == online
			if (id.equals(parent_Id)) {

				continue;

			} else {
				driver.switchTo().window(id); // mobile

				String currentUrl = driver.getCurrentUrl();
				System.out.println(currentUrl);

			}
		}
	}

}
