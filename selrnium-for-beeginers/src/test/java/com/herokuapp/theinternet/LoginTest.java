package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {
	private WebDriver driver ; 

//	@SuppressWarnings("deprecation")
	@Parameters({ "browser" })
	@BeforeTest(alwaysRun = true )
	private void setUp(@Optional String browser) {
		// create driver

		switch (browser) {
		case "chrome":			
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
			break;
			
		default:
			System.out.println("Starting chrome") ;
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		
		// sleep for 3 seconds
		sleep(3000);

		// maximize browser window
		driver.manage().window().maximize();
		
		//implicit wait 
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(priority = 1, groups = { "positiveTest", "smokeTests" })
	public void positiveLoginTest() {

		System.out.println("Start login test");

//		open test page 
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("page is opened");

		// sleep for 2 seconds
		sleep(2000);

//		enter user name :

		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");

		sleep(2000);

		// enter password:
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("SuperSecretPassword!");

	//	WebDriverWait wait = new WebDriverWait(driver, 10);


		sleep(4000);

		// click login button
		WebElement logInButton = driver.findElement(By.tagName("button"));
		//wait.until(ExpectedConditions.elementToBeClickable(logInButton));
		logInButton.click();

//		verification:
//			new url
		String expectedUrl = "https://the-internet.herokuapp.com/secure";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page is not the same as expected!!");

//		logout button is visible 
		WebElement logOutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
		Assert.assertTrue(logOutButton.isDisplayed(), "log out button is not visible");

		// successful logout massage
		// WebElement successMessage = driver.findElement(By.cssSelector("#flash"));

		WebElement successMessage = driver.findElement(By.xpath("//div[@id='flash']"));
		String expectedMessage = "You logged into a secure area!";
		String actualMessage = successMessage.getText();
		
		// Assert.assertEquals(actualMessage, expectedMessage, "Actual message is not
		// the same as expected!!") ;
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"Actual message does not contain expected messaege.\n" + actualMessage + "\nExpected message:"
						+ expectedMessage);

		sleep(4000);


	}



	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 2, groups = { "negativeTest", "smokeTests" })
	public void negativeLoginTest(String username, String password, String expectedMessage) {
		System.out.println("Start incorect user name with" + username + "and" + password);

		

//		open test page 
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("page is opened");

//		enter user name :

		WebElement usernameElement = driver.findElement(By.id("username"));
		usernameElement.sendKeys(username);
		// username.sendKeys("tomsmith");

		// enter password:
		WebElement passwordElement = driver.findElement(By.name("password"));
		passwordElement.sendKeys(password);
		// password.sendKeys("incorrectUsername");

		// click login button
		WebElement logInButton = driver.findElement(By.tagName("button"));
		logInButton.click();

//verification:
		WebElement errorMessage = driver.findElement(By.id("flash"));
		// String expectedErrorMessage = "Your username is invalid!";
		String actualErrorMessage = errorMessage.getText();

		Assert.assertTrue(actualErrorMessage.contains(expectedMessage),
				"Actual error message does not contain expected. \nActual: " + actualErrorMessage + "\nExpected: "
						+ expectedMessage);

		// Close browser
		sleep(3000);

	}
	
	@AfterMethod(alwaysRun = true )
	private void tearDown() {
		// close browser
		driver.quit();
	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
