package com.herokuapp.theinternet;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeTest {

	

	/*
	 * @Test(priority = 2, groups = { "negativeTest" }) public void
	 * incorectPasswordTest() {
	 * 
	 * System.out.println("Start incorect password");
	 * 
	 * // create driver System.setProperty("webdriver.chrome.driver",
	 * "src/main/resources/chromedriver.exe"); WebDriver driver = new
	 * ChromeDriver();
	 * 
	 * // maximize browser window driver.manage().window().maximize();
	 * 
	 * // open test page String url = "https://the-internet.herokuapp.com/login";
	 * driver.get(url); System.out.println("page is opened");
	 * 
	 * // enter user name :
	 * 
	 * WebElement username = driver.findElement(By.id("username"));
	 * username.sendKeys("tomsmith");
	 * 
	 * // enter password: WebElement password =
	 * driver.findElement(By.name("password"));
	 * //password.sendKeys("SuperSecretPassword!");
	 * password.sendKeys("incorrectPassword!");
	 * 
	 * // click login button WebElement logInButton =
	 * driver.findElement(By.tagName("button")); logInButton.click();
	 * 
	 * // verification: WebElement errorMessage =
	 * driver.findElement(By.id("flash")); String expectedErrorMessage =
	 * "Your password is invalid!"; String actualErrorMessage =
	 * errorMessage.getText();
	 * 
	 * Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
	 * "Actual error message does not contain expected. \nActual: " +
	 * actualErrorMessage + "\nExpected: " + expectedErrorMessage);
	 * 
	 * // Close browser sleep(3000);
	 * 
	 * driver.quit();
	 * 
	 * }
	 */

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
